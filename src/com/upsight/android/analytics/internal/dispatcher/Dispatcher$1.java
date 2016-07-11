package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.internal.DataStoreRecord;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class Dispatcher$1
  implements UpsightDataStoreListener<Set<DataStoreRecord>>
{
  Dispatcher$1(Dispatcher paramDispatcher) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    Dispatcher.access$100(this$0).e("Dispatcher", "Could not fetch records from store.", new Object[] { paramUpsightException });
  }
  
  public void onSuccess(Set<DataStoreRecord> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      DataStoreRecord localDataStoreRecord = (DataStoreRecord)paramSet.next();
      Dispatcher.access$000(this$0, localDataStoreRecord);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Dispatcher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */