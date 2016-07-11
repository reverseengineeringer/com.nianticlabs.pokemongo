package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.analytics.dispatcher.AnalyticsEventDeliveryStatus;
import com.upsight.android.analytics.dispatcher.EndpointResponse;
import com.upsight.android.analytics.internal.AnalyticsContext;
import com.upsight.android.analytics.internal.DataStoreRecord;
import com.upsight.android.analytics.internal.DataStoreRecord.Action;
import com.upsight.android.analytics.internal.dispatcher.routing.Router;
import com.upsight.android.analytics.internal.dispatcher.routing.RouterBuilder;
import com.upsight.android.analytics.internal.dispatcher.routing.RoutingListener;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder;
import com.upsight.android.analytics.internal.dispatcher.util.Selector;
import com.upsight.android.analytics.internal.session.Session;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import com.upsight.android.persistence.UpsightSubscription;
import com.upsight.android.persistence.annotation.Created;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Dispatcher
  implements RoutingListener
{
  public static final String CONFIGURATION_SUBTYPE = "upsight.configuration.dispatcher";
  static final int DISPATCHER_CONFIGURATION_MAX_SESSIONS = 2;
  private static final String LOG_TAG = "Dispatcher";
  private ConfigParser mConfigParser;
  private AnalyticsContext mContext;
  private Config mCurrentConfig;
  private volatile Router mCurrentRouter;
  private UpsightSubscription mDataStoreSubscription;
  private Collection<Router> mExpiredRouters;
  private boolean mIsLaunched = false;
  private UpsightLogger mLogger;
  private Set<DataStoreRecord> mPendingRecords;
  private RouterBuilder mRouterBuilder;
  private SchemaSelectorBuilder mSchemaSelectorBuilder;
  private SessionManager mSessionManager;
  private Queue<DataStoreRecord> mUnroutedRecords;
  private UpsightDataStore mUpsightDataStore;
  
  Dispatcher(AnalyticsContext paramAnalyticsContext, SessionManager paramSessionManager, UpsightDataStore paramUpsightDataStore, ConfigParser paramConfigParser, RouterBuilder paramRouterBuilder, SchemaSelectorBuilder paramSchemaSelectorBuilder, UpsightLogger paramUpsightLogger)
  {
    mContext = paramAnalyticsContext;
    mSessionManager = paramSessionManager;
    mUpsightDataStore = paramUpsightDataStore;
    mConfigParser = paramConfigParser;
    mRouterBuilder = paramRouterBuilder;
    mSchemaSelectorBuilder = paramSchemaSelectorBuilder;
    mLogger = paramUpsightLogger;
  }
  
  private boolean applyConfiguration(String paramString)
  {
    paramString = parseConfiguration(paramString);
    if (paramString == null) {
      return false;
    }
    if (!paramString.isValid())
    {
      mLogger.w("Dispatcher", "Incoming configuration is not valid", new Object[0]);
      return false;
    }
    if (paramString.equals(mCurrentConfig)) {
      return true;
    }
    mCurrentConfig = paramString;
    Object localObject1 = mExpiredRouters;
    Object localObject2 = mCurrentRouter;
    if ((localObject1 != null) && (localObject2 != null))
    {
      ((Collection)localObject1).add(localObject2);
      ((Router)localObject2).finishRouting();
    }
    localObject1 = mSchemaSelectorBuilder.buildSelectorByName(paramString.getIdentifierConfig());
    localObject2 = mSchemaSelectorBuilder.buildSelectorByType(paramString.getIdentifierConfig());
    mCurrentRouter = mRouterBuilder.build(paramString.getRoutingConfig(), (Selector)localObject1, (Selector)localObject2, this);
    paramString = mUnroutedRecords;
    if ((paramString != null) && (mCurrentRouter != null)) {
      while (!paramString.isEmpty()) {
        routeRecords((DataStoreRecord)paramString.poll());
      }
    }
    fetchCreatedRecords();
    return true;
  }
  
  private void applyDefaultConfiguration()
  {
    applyConfiguration(mContext.getDefaultDispatcherConfiguration());
  }
  
  private void fetchCreatedRecords()
  {
    mUpsightDataStore.fetch(DataStoreRecord.class, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        mLogger.e("Dispatcher", "Could not fetch records from store.", new Object[] { paramAnonymousUpsightException });
      }
      
      public void onSuccess(Set<DataStoreRecord> paramAnonymousSet)
      {
        paramAnonymousSet = paramAnonymousSet.iterator();
        while (paramAnonymousSet.hasNext())
        {
          DataStoreRecord localDataStoreRecord = (DataStoreRecord)paramAnonymousSet.next();
          Dispatcher.this.routeRecords(localDataStoreRecord);
        }
      }
    });
  }
  
  private void fetchCurrentConfig()
  {
    mUpsightDataStore.fetch(UpsightConfiguration.class, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        mLogger.e("Dispatcher", "Could not fetch config from store.", new Object[] { paramAnonymousUpsightException });
        if (mCurrentConfig == null) {
          Dispatcher.this.applyDefaultConfiguration();
        }
      }
      
      public void onSuccess(Set<UpsightConfiguration> paramAnonymousSet)
      {
        if (mCurrentConfig != null) {}
        boolean bool;
        do
        {
          return;
          bool = false;
          paramAnonymousSet = paramAnonymousSet.iterator();
          while (paramAnonymousSet.hasNext())
          {
            UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramAnonymousSet.next();
            if (("upsight.configuration.dispatcher".equals(localUpsightConfiguration.getScope())) && (Dispatcher.this.isUpsightConfigurationValid(localUpsightConfiguration))) {
              bool = Dispatcher.this.applyConfiguration(localUpsightConfiguration.getConfiguration());
            }
          }
        } while (bool);
        Dispatcher.this.applyDefaultConfiguration();
      }
    });
  }
  
  private boolean isUpsightConfigurationValid(UpsightConfiguration paramUpsightConfiguration)
  {
    return mSessionManager.getCurrentSession().getSessionNumber() - paramUpsightConfiguration.getSessionNumberCreated() <= 2;
  }
  
  private Config parseConfiguration(String paramString)
  {
    try
    {
      paramString = mConfigParser.parseConfig(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      mLogger.e("Dispatcher", "Could not apply incoming config", new Object[] { paramString });
    }
    return null;
  }
  
  private void routeRecords(DataStoreRecord paramDataStoreRecord)
  {
    if (!DataStoreRecord.Action.Created.equals(paramDataStoreRecord.getAction())) {
      mUpsightDataStore.remove(paramDataStoreRecord);
    }
    Object localObject;
    Set localSet;
    do
    {
      do
      {
        return;
        localObject = mCurrentRouter;
        localSet = mPendingRecords;
        if (localObject != null) {
          break;
        }
        localObject = mUnroutedRecords;
      } while (((Queue)localObject).contains(paramDataStoreRecord));
      ((Queue)localObject).add(paramDataStoreRecord);
      return;
    } while ((localSet == null) || (localSet.contains(paramDataStoreRecord)) || (!((Router)localObject).routeEvent(paramDataStoreRecord)));
    localSet.add(paramDataStoreRecord);
  }
  
  public boolean hasPendingRecords()
  {
    Set localSet = mPendingRecords;
    return (localSet == null) || (!localSet.isEmpty());
  }
  
  public void launch()
  {
    if (mIsLaunched) {
      return;
    }
    mIsLaunched = true;
    mCurrentRouter = null;
    mExpiredRouters = new HashSet();
    mUnroutedRecords = new ConcurrentLinkedQueue();
    mPendingRecords = Collections.synchronizedSet(new HashSet());
    mCurrentConfig = null;
    mDataStoreSubscription = mUpsightDataStore.subscribe(this);
    fetchCurrentConfig();
  }
  
  @Created
  public void onConfigurationCreated(UpsightConfiguration paramUpsightConfiguration)
  {
    if (("upsight.configuration.dispatcher".equals(paramUpsightConfiguration.getScope())) && (isUpsightConfigurationValid(paramUpsightConfiguration))) {
      applyConfiguration(paramUpsightConfiguration.getConfiguration());
    }
  }
  
  @Created
  public void onDataStoreRecordCreated(DataStoreRecord paramDataStoreRecord)
  {
    routeRecords(paramDataStoreRecord);
  }
  
  public void onDelivery(DataStoreRecord paramDataStoreRecord, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {}
    for (paramString = AnalyticsEventDeliveryStatus.fromSuccess(paramDataStoreRecord.getID());; paramString = AnalyticsEventDeliveryStatus.fromFailure(paramDataStoreRecord.getID(), paramString))
    {
      mUpsightDataStore.store(paramString, new UpsightDataStoreListener()
      {
        public void onFailure(UpsightException paramAnonymousUpsightException)
        {
          mLogger.e("Dispatcher", paramAnonymousUpsightException, "Could not store DeliveryStatus.", new Object[0]);
        }
        
        public void onSuccess(AnalyticsEventDeliveryStatus paramAnonymousAnalyticsEventDeliveryStatus)
        {
          mUpsightDataStore.remove(paramAnonymousAnalyticsEventDeliveryStatus);
        }
      });
      if ((paramBoolean1) || (paramBoolean2)) {
        mUpsightDataStore.remove(paramDataStoreRecord);
      }
      paramString = mPendingRecords;
      if (paramString != null) {
        paramString.remove(paramDataStoreRecord);
      }
      return;
    }
  }
  
  public void onResponse(EndpointResponse paramEndpointResponse)
  {
    mUpsightDataStore.store(paramEndpointResponse, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        mLogger.e("Dispatcher", paramAnonymousUpsightException, "Could not store EndpointResponse.", new Object[0]);
      }
      
      public void onSuccess(EndpointResponse paramAnonymousEndpointResponse)
      {
        mUpsightDataStore.remove(paramAnonymousEndpointResponse);
      }
    });
  }
  
  public void onRoutingFinished(Router paramRouter)
  {
    Collection localCollection = mExpiredRouters;
    if (localCollection != null) {
      localCollection.remove(paramRouter);
    }
  }
  
  public void terminate()
  {
    if (mCurrentRouter != null)
    {
      mCurrentRouter.finishRouting();
      mCurrentRouter = null;
    }
    if (mDataStoreSubscription != null)
    {
      mDataStoreSubscription.unsubscribe();
      mDataStoreSubscription = null;
    }
    mCurrentConfig = null;
    mPendingRecords = null;
    mUnroutedRecords = null;
    mExpiredRouters = null;
    mCurrentRouter = null;
    mIsLaunched = false;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Dispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */