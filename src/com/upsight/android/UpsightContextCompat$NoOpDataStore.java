package com.upsight.android;

import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import com.upsight.android.persistence.UpsightStorableSerializer;
import com.upsight.android.persistence.UpsightSubscription;
import java.util.Set;
import rx.Observable;

class UpsightContextCompat$NoOpDataStore
  implements UpsightDataStore
{
  public <T> UpsightSubscription fetch(Class<T> paramClass, UpsightDataStoreListener<Set<T>> paramUpsightDataStoreListener)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> UpsightSubscription fetch(Class<T> paramClass, Set<String> paramSet, UpsightDataStoreListener<Set<T>> paramUpsightDataStoreListener)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> Observable<T> fetchObservable(Class<T> paramClass)
  {
    return Observable.empty();
  }
  
  public <T> Observable<T> fetchObservable(Class<T> paramClass, String... paramVarArgs)
  {
    return Observable.empty();
  }
  
  public <T> UpsightSubscription remove(Class<T> paramClass, Set<String> paramSet)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> UpsightSubscription remove(Class<T> paramClass, Set<String> paramSet, UpsightDataStoreListener<Set<T>> paramUpsightDataStoreListener)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> UpsightSubscription remove(T paramT)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> UpsightSubscription remove(T paramT, UpsightDataStoreListener<T> paramUpsightDataStoreListener)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> Observable<T> removeObservable(Class<T> paramClass, String... paramVarArgs)
  {
    return Observable.empty();
  }
  
  public <T> Observable<T> removeObservable(T paramT)
  {
    return Observable.empty();
  }
  
  public <T> void setSerializer(Class<T> paramClass, UpsightStorableSerializer<T> paramUpsightStorableSerializer) {}
  
  public <T> UpsightSubscription store(T paramT)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> UpsightSubscription store(T paramT, UpsightDataStoreListener<T> paramUpsightDataStoreListener)
  {
    return new NoOpSubscription(null);
  }
  
  public <T> Observable<T> storeObservable(T paramT)
  {
    return Observable.empty();
  }
  
  public UpsightSubscription subscribe(Object paramObject)
  {
    return new NoOpSubscription(null);
  }
  
  private static class NoOpSubscription
    implements UpsightSubscription
  {
    public boolean isSubscribed()
    {
      return false;
    }
    
    public void unsubscribe() {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightContextCompat.NoOpDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */