package com.upsight.android.analytics.internal.configuration;

import android.content.res.Resources;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.R.raw;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.analytics.dispatcher.EndpointResponse;
import com.upsight.android.analytics.event.config.UpsightConfigExpiredEvent;
import com.upsight.android.analytics.event.config.UpsightConfigExpiredEvent.Builder;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import com.upsight.android.persistence.UpsightSubscription;
import com.upsight.android.persistence.annotation.Created;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

public final class ConfigurationManager
{
  public static final String CONFIGURATION_RESPONSE_SUBTYPE = "upsight.configuration";
  public static final String CONFIGURATION_SUBTYPE = "upsight.configuration.configurationManager";
  private static final String LOG_TAG = "Configurator";
  private final ManagerConfigParser mConfigParser;
  private Config mCurrentConfig;
  private final UpsightDataStore mDataStore;
  private UpsightSubscription mDataStoreSubscription;
  private boolean mIsLaunched = false;
  private boolean mIsOutOfSync;
  private final UpsightLogger mLogger;
  private final ConfigurationResponseParser mResponseParser;
  private Action0 mSyncAction = new Action0()
  {
    public void call()
    {
      UpsightConfigExpiredEvent.createBuilder().record(mUpsight);
    }
  };
  private final UpsightContext mUpsight;
  private final Scheduler.Worker mWorker;
  private Subscription mWorkerSubscription;
  
  ConfigurationManager(UpsightContext paramUpsightContext, UpsightDataStore paramUpsightDataStore, ConfigurationResponseParser paramConfigurationResponseParser, ManagerConfigParser paramManagerConfigParser, Scheduler paramScheduler, UpsightLogger paramUpsightLogger)
  {
    mUpsight = paramUpsightContext;
    mDataStore = paramUpsightDataStore;
    mResponseParser = paramConfigurationResponseParser;
    mConfigParser = paramManagerConfigParser;
    mLogger = paramUpsightLogger;
    mWorker = paramScheduler.createWorker();
  }
  
  private boolean applyConfiguration(String paramString)
  {
    try
    {
      paramString = mConfigParser.parse(paramString);
      if ((paramString == null) || (!paramString.isValid()))
      {
        mLogger.w("Configurator", "Incoming config is invalid", new Object[0]);
        return false;
      }
      if (paramString.equals(mCurrentConfig))
      {
        mLogger.w("Configurator", "Current config is equals to incoming config, rejecting", new Object[0]);
        return true;
      }
      if ((mWorkerSubscription != null) && (!mWorkerSubscription.isUnsubscribed())) {
        mWorkerSubscription.unsubscribe();
      }
      if (mIsOutOfSync) {}
      for (long l = 0L;; l = requestInterval)
      {
        mWorkerSubscription = mWorker.schedulePeriodically(mSyncAction, l, requestInterval, TimeUnit.MILLISECONDS);
        mIsOutOfSync = false;
        mCurrentConfig = paramString;
        return true;
      }
      return false;
    }
    catch (IOException paramString)
    {
      mLogger.e("Configurator", "Could not parse incoming configuration", new Object[] { paramString });
    }
  }
  
  private void applyDefaultConfiguration()
  {
    try
    {
      applyConfiguration(IOUtils.toString(mUpsight.getResources().openRawResource(R.raw.configurator_config)));
      return;
    }
    catch (IOException localIOException)
    {
      mLogger.e("Configurator", "Could not read default config", new Object[] { localIOException });
    }
  }
  
  private void fetchCurrentConfig()
  {
    mDataStore.fetch(UpsightConfiguration.class, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        mLogger.e("Configurator", "Could not fetch existing configs from datastore", new Object[] { paramAnonymousUpsightException });
        if (mCurrentConfig == null) {
          ConfigurationManager.this.applyDefaultConfiguration();
        }
      }
      
      public void onSuccess(Set<UpsightConfiguration> paramAnonymousSet)
      {
        if (mCurrentConfig != null) {}
        int i;
        do
        {
          return;
          i = 0;
          boolean bool = false;
          if (paramAnonymousSet.size() > 0)
          {
            paramAnonymousSet = paramAnonymousSet.iterator();
            for (;;)
            {
              i = bool;
              if (!paramAnonymousSet.hasNext()) {
                break;
              }
              UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramAnonymousSet.next();
              if (localUpsightConfiguration.getScope().equals("upsight.configuration.configurationManager")) {
                bool = ConfigurationManager.this.applyConfiguration(localUpsightConfiguration.getConfiguration());
              }
            }
          }
        } while (i != 0);
        ConfigurationManager.this.applyDefaultConfiguration();
      }
    });
  }
  
  public void launch()
  {
    if (mIsLaunched) {
      return;
    }
    mIsLaunched = true;
    mIsOutOfSync = true;
    mCurrentConfig = null;
    mDataStoreSubscription = mDataStore.subscribe(this);
    mWorkerSubscription = null;
    fetchCurrentConfig();
  }
  
  @Created
  public void onEndpointResponse(EndpointResponse paramEndpointResponse)
  {
    if (!"upsight.configuration".equals(paramEndpointResponse.getType())) {
      return;
    }
    for (;;)
    {
      try
      {
        paramEndpointResponse = mResponseParser.parse(paramEndpointResponse.getContent());
        mDataStore.fetch(UpsightConfiguration.class, new UpsightDataStoreListener()
        {
          public void onFailure(UpsightException paramAnonymousUpsightException) {}
          
          public void onSuccess(Set<UpsightConfiguration> paramAnonymousSet)
          {
            paramAnonymousSet = paramAnonymousSet.iterator();
            while (paramAnonymousSet.hasNext())
            {
              UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramAnonymousSet.next();
              mDataStore.remove(localUpsightConfiguration);
            }
          }
        });
        paramEndpointResponse = paramEndpointResponse.iterator();
        if (!paramEndpointResponse.hasNext()) {
          break;
        }
        UpsightConfiguration localUpsightConfiguration = (UpsightConfiguration)paramEndpointResponse.next();
        if (localUpsightConfiguration.getScope().equals("upsight.configuration.configurationManager"))
        {
          if (applyConfiguration(localUpsightConfiguration.getConfiguration())) {
            mDataStore.store(localUpsightConfiguration);
          }
        }
        else {
          mDataStore.store(localUpsightConfiguration);
        }
      }
      catch (IOException paramEndpointResponse)
      {
        mLogger.e("Configurator", "Could not parse incoming configurations", new Object[] { paramEndpointResponse });
        return;
      }
    }
  }
  
  public void terminate()
  {
    if (mDataStoreSubscription != null)
    {
      mDataStoreSubscription.unsubscribe();
      mDataStoreSubscription = null;
    }
    if (mWorkerSubscription != null)
    {
      mWorkerSubscription.unsubscribe();
      mWorkerSubscription = null;
    }
    mCurrentConfig = null;
    mIsLaunched = false;
  }
  
  public static final class Config
  {
    public final long requestInterval;
    
    Config(long paramLong)
    {
      requestInterval = paramLong;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
      } while (requestInterval == requestInterval);
      return false;
    }
    
    public boolean isValid()
    {
      return requestInterval > 0L;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */