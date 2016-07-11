package com.upsight.android.persistence;

import java.util.Set;
import rx.Observable;

public abstract interface UpsightDataStore
{
  public abstract <T> UpsightSubscription fetch(Class<T> paramClass, UpsightDataStoreListener<Set<T>> paramUpsightDataStoreListener);
  
  public abstract <T> UpsightSubscription fetch(Class<T> paramClass, Set<String> paramSet, UpsightDataStoreListener<Set<T>> paramUpsightDataStoreListener);
  
  public abstract <T> Observable<T> fetchObservable(Class<T> paramClass);
  
  public abstract <T> Observable<T> fetchObservable(Class<T> paramClass, String... paramVarArgs);
  
  public abstract <T> UpsightSubscription remove(Class<T> paramClass, Set<String> paramSet);
  
  public abstract <T> UpsightSubscription remove(Class<T> paramClass, Set<String> paramSet, UpsightDataStoreListener<Set<T>> paramUpsightDataStoreListener);
  
  public abstract <T> UpsightSubscription remove(T paramT);
  
  public abstract <T> UpsightSubscription remove(T paramT, UpsightDataStoreListener<T> paramUpsightDataStoreListener);
  
  public abstract <T> Observable<T> removeObservable(Class<T> paramClass, String... paramVarArgs);
  
  public abstract <T> Observable<T> removeObservable(T paramT);
  
  public abstract <T> void setSerializer(Class<T> paramClass, UpsightStorableSerializer<T> paramUpsightStorableSerializer);
  
  public abstract <T> UpsightSubscription store(T paramT);
  
  public abstract <T> UpsightSubscription store(T paramT, UpsightDataStoreListener<T> paramUpsightDataStoreListener);
  
  public abstract <T> Observable<T> storeObservable(T paramT);
  
  public abstract UpsightSubscription subscribe(Object paramObject);
}

/* Location:
 * Qualified Name:     com.upsight.android.persistence.UpsightDataStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */