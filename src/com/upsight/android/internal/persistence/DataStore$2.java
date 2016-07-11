package com.upsight.android.internal.persistence;

import com.upsight.android.UpsightException;
import com.upsight.android.persistence.UpsightDataStoreListener;
import rx.functions.Action1;

class DataStore$2
  implements Action1<Throwable>
{
  DataStore$2(DataStore paramDataStore, UpsightDataStoreListener paramUpsightDataStoreListener) {}
  
  public void call(Throwable paramThrowable)
  {
    val$listener.onFailure(new UpsightException(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.DataStore.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */