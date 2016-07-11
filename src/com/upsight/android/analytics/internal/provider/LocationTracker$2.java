package com.upsight.android.analytics.internal.provider;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class LocationTracker$2
  implements UpsightDataStoreListener<Set<UpsightLocationTracker.Data>>
{
  LocationTracker$2(LocationTracker paramLocationTracker) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    LocationTracker.access$200(this$0).e("Upsight", "Failed to remove stale location data.", new Object[] { paramUpsightException });
  }
  
  public void onSuccess(Set<UpsightLocationTracker.Data> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      UpsightLocationTracker.Data localData = (UpsightLocationTracker.Data)paramSet.next();
      LocationTracker.access$000(this$0).remove(localData);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.LocationTracker.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */