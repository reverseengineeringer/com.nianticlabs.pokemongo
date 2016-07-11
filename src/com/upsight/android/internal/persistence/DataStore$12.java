package com.upsight.android.internal.persistence;

import rx.Observable;
import rx.functions.Func1;

class DataStore$12
  implements Func1<Storable, Observable<Storable>>
{
  DataStore$12(DataStore paramDataStore, boolean paramBoolean) {}
  
  public Observable<Storable> call(Storable paramStorable)
  {
    if (val$hasID) {
      return ContentObservables.update(DataStore.access$000(this$0), paramStorable);
    }
    return ContentObservables.insert(DataStore.access$000(this$0), paramStorable);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.DataStore.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */