package com.upsight.android.analytics.internal.provider;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class LocationTracker$1
  implements UpsightDataStoreListener<Set<UpsightLocationTracker.Data>>
{
  LocationTracker$1(LocationTracker paramLocationTracker, UpsightLocationTracker.Data paramData) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    LocationTracker.access$200(this$0).e(LocationTracker.access$100(), paramUpsightException, "Failed to fetch location data.", new Object[0]);
  }
  
  public void onSuccess(Set<UpsightLocationTracker.Data> paramSet)
  {
    Object localObject = null;
    Iterator localIterator = paramSet.iterator();
    paramSet = (Set<UpsightLocationTracker.Data>)localObject;
    if (localIterator.hasNext())
    {
      paramSet = (UpsightLocationTracker.Data)localIterator.next();
      paramSet.setLatitude(val$newLocation.getLatitude());
      paramSet.setLongitude(val$newLocation.getLongitude());
      paramSet.setTimeZone(val$newLocation.getTimeZone());
    }
    localObject = paramSet;
    if (paramSet == null) {
      localObject = val$newLocation;
    }
    LocationTracker.access$000(this$0).store(localObject);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.LocationTracker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */