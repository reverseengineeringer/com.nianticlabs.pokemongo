package com.upsight.android;

import android.content.Context;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.logger.UpsightLogger.Level;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import com.upsight.android.persistence.UpsightStorableSerializer;
import com.upsight.android.persistence.UpsightSubscription;
import java.util.EnumSet;
import java.util.Set;
import rx.Observable;

class UpsightContextCompat
  extends UpsightContext
{
  UpsightContextCompat(Context paramContext)
  {
    super(paramContext, null, null, null, null, new NoOpDataStore(null), new NoOpLogger(null));
  }
  
  public UpsightCoreComponent getCoreComponent()
  {
    return null;
  }
  
  public UpsightExtension<?, ?> getUpsightExtension(String paramString)
  {
    return null;
  }
  
  private static class NoOpDataStore
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
  
  private static class NoOpLogger
    implements UpsightLogger
  {
    public void d(String paramString1, String paramString2, Object... paramVarArgs) {}
    
    public void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
    
    public void e(String paramString1, String paramString2, Object... paramVarArgs) {}
    
    public void e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
    
    public void i(String paramString1, String paramString2, Object... paramVarArgs) {}
    
    public void i(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
    
    public void setLogLevel(String paramString, EnumSet<UpsightLogger.Level> paramEnumSet) {}
    
    public void v(String paramString1, String paramString2, Object... paramVarArgs) {}
    
    public void v(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
    
    public void w(String paramString1, String paramString2, Object... paramVarArgs) {}
    
    public void w(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightContextCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */