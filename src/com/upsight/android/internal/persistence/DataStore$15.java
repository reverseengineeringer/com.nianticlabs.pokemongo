package com.upsight.android.internal.persistence;

import rx.Observable;
import rx.functions.Func1;

class DataStore$15
  implements Func1<T, Observable<T>>
{
  DataStore$15(DataStore paramDataStore) {}
  
  public Observable<T> call(T paramT)
  {
    return this$0.removeObservable(paramT);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.DataStore.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */