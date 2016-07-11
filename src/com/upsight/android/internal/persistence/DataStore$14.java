package com.upsight.android.internal.persistence;

import rx.Observable;
import rx.functions.Func1;

class DataStore$14
  implements Func1<Storable, Observable<Storable>>
{
  DataStore$14(DataStore paramDataStore) {}
  
  public Observable<Storable> call(Storable paramStorable)
  {
    return ContentObservables.remove(DataStore.access$000(this$0), paramStorable);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.DataStore.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */