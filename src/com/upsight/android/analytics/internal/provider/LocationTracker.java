package com.upsight.android.analytics.internal.provider;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.provider.UpsightLocationTracker;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class LocationTracker
  extends UpsightLocationTracker
{
  private static final String LOG_TAG = LocationTracker.class.getSimpleName();
  private UpsightDataStore mDataStore;
  private UpsightLogger mLogger;
  
  @Inject
  LocationTracker(UpsightContext paramUpsightContext)
  {
    mDataStore = paramUpsightContext.getDataStore();
    mLogger = paramUpsightContext.getLogger();
  }
  
  public void purge()
  {
    mDataStore.fetch(UpsightLocationTracker.Data.class, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        mLogger.e("Upsight", "Failed to remove stale location data.", new Object[] { paramAnonymousUpsightException });
      }
      
      public void onSuccess(Set<UpsightLocationTracker.Data> paramAnonymousSet)
      {
        paramAnonymousSet = paramAnonymousSet.iterator();
        while (paramAnonymousSet.hasNext())
        {
          UpsightLocationTracker.Data localData = (UpsightLocationTracker.Data)paramAnonymousSet.next();
          mDataStore.remove(localData);
        }
      }
    });
  }
  
  public void track(final UpsightLocationTracker.Data paramData)
  {
    mDataStore.fetch(UpsightLocationTracker.Data.class, new UpsightDataStoreListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        mLogger.e(LocationTracker.LOG_TAG, paramAnonymousUpsightException, "Failed to fetch location data.", new Object[0]);
      }
      
      public void onSuccess(Set<UpsightLocationTracker.Data> paramAnonymousSet)
      {
        Object localObject = null;
        Iterator localIterator = paramAnonymousSet.iterator();
        paramAnonymousSet = (Set<UpsightLocationTracker.Data>)localObject;
        if (localIterator.hasNext())
        {
          paramAnonymousSet = (UpsightLocationTracker.Data)localIterator.next();
          paramAnonymousSet.setLatitude(paramData.getLatitude());
          paramAnonymousSet.setLongitude(paramData.getLongitude());
          paramAnonymousSet.setTimeZone(paramData.getTimeZone());
        }
        localObject = paramAnonymousSet;
        if (paramAnonymousSet == null) {
          localObject = paramData;
        }
        mDataStore.store(localObject);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.LocationTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */