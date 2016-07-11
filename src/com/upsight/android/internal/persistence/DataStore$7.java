package com.upsight.android.internal.persistence;

import com.upsight.android.persistence.UpsightDataStoreListener;
import rx.functions.Action1;

class DataStore$7
  implements Action1<T>
{
  DataStore$7(DataStore paramDataStore, UpsightDataStoreListener paramUpsightDataStoreListener) {}
  
  public void call(T paramT)
  {
    val$listener.onSuccess(paramT);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.DataStore.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */