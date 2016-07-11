package com.upsight.android.internal.persistence;

import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.HashSet;
import java.util.List;
import rx.functions.Action1;

class DataStore$5
  implements Action1<List<T>>
{
  DataStore$5(DataStore paramDataStore, UpsightDataStoreListener paramUpsightDataStoreListener) {}
  
  public void call(List<T> paramList)
  {
    val$listener.onSuccess(new HashSet(paramList));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.DataStore.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */