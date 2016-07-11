package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightException;
import com.upsight.android.internal.persistence.subscription.Subscriptions;
import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.managedvariables.type.UpsightManagedFloat;
import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.managedvariables.type.UpsightManagedString;
import com.upsight.android.managedvariables.type.UpsightManagedVariable.Listener;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightSubscription;
import com.upsight.android.persistence.annotation.Created;
import com.upsight.android.persistence.annotation.Removed;
import com.upsight.android.persistence.annotation.Updated;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.BlockingObservable;

public class ManagedVariableManager
{
  private static final Map<Class<? extends ManagedVariable>, Class<? extends ManagedVariableModel>> sModelMap = new HashMap() {};
  private final Map<String, ManagedVariable> mCache = new HashMap();
  private Scheduler mCallbackScheduler;
  private UpsightDataStore mDataStore;
  private UxmSchema mUxmSchema;
  
  ManagedVariableManager(Scheduler paramScheduler, UpsightDataStore paramUpsightDataStore, UxmSchema paramUxmSchema)
  {
    mCallbackScheduler = paramScheduler;
    mDataStore = paramUpsightDataStore;
    mUxmSchema = paramUxmSchema;
    paramUpsightDataStore.subscribe(this);
  }
  
  private <T extends ManagedVariable> Observable<? extends ManagedVariableModel> fetchDataStoreObservable(final Class<T> paramClass, final String paramString)
  {
    mDataStore.fetchObservable((Class)sModelMap.get(paramClass)).filter(new Func1()
    {
      public Boolean call(ManagedVariableModel paramAnonymousManagedVariableModel)
      {
        return Boolean.valueOf(mUxmSchema.get(paramClass, paramString).tag.equals(paramAnonymousManagedVariableModel.getTag()));
      }
    }).defaultIfEmpty(null);
  }
  
  private <T extends ManagedVariable> T fromModel(Class<T> paramClass, String paramString, ManagedVariableModel paramManagedVariableModel)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    String str = null;
    Object localObject1 = null;
    Object localObject4 = null;
    UxmSchema.BaseSchema localBaseSchema = mUxmSchema.get(paramClass, paramString);
    if (localBaseSchema == null) {
      return null;
    }
    if (UpsightManagedString.class.equals(paramClass))
    {
      str = (String)defaultValue;
      paramClass = (Class<T>)localObject1;
      if (paramManagedVariableModel != null) {
        paramClass = paramManagedVariableModel.getValue();
      }
      localObject1 = new ManagedString(paramString, str, (String)paramClass);
    }
    for (;;)
    {
      return (T)localObject1;
      if (UpsightManagedBoolean.class.equals(paramClass))
      {
        localObject1 = (Boolean)defaultValue;
        paramClass = (Class<T>)localObject2;
        if (paramManagedVariableModel != null) {
          paramClass = paramManagedVariableModel.getValue();
        }
        localObject1 = new ManagedBoolean(paramString, (Boolean)localObject1, (Boolean)paramClass);
      }
      else if (UpsightManagedInt.class.equals(paramClass))
      {
        localObject1 = (Integer)defaultValue;
        paramClass = (Class<T>)localObject3;
        if (paramManagedVariableModel != null) {
          paramClass = paramManagedVariableModel.getValue();
        }
        localObject1 = new ManagedInt(paramString, (Integer)localObject1, (Integer)paramClass);
      }
      else
      {
        localObject1 = localObject4;
        if (UpsightManagedFloat.class.equals(paramClass))
        {
          localObject1 = (Float)defaultValue;
          paramClass = str;
          if (paramManagedVariableModel != null) {
            paramClass = paramManagedVariableModel.getValue();
          }
          localObject1 = new ManagedFloat(paramString, (Float)localObject1, (Float)paramClass);
        }
      }
    }
  }
  
  private <T extends ManagedVariable> void resetValue(Class<T> paramClass, String paramString)
  {
    synchronized (mCache)
    {
      paramString = (ManagedVariable)mCache.get(paramString);
      if ((paramString != null) && (paramClass.isInstance(paramString))) {
        paramString.set(null);
      }
      return;
    }
  }
  
  private <T extends ManagedVariable> void updateValue(Class<T> paramClass, String paramString, Object paramObject)
  {
    synchronized (mCache)
    {
      paramString = (ManagedVariable)mCache.get(paramString);
      if ((paramString != null) && (paramClass.isInstance(paramString))) {
        paramString.set(paramObject);
      }
      return;
    }
  }
  
  public <T extends ManagedVariable> T fetch(Class<T> paramClass, String paramString)
  {
    synchronized (mCache)
    {
      ManagedVariable localManagedVariable = (ManagedVariable)mCache.get(paramString);
      if (localManagedVariable != null) {
        paramClass = localManagedVariable;
      }
      do
      {
        return paramClass;
        localManagedVariable = fromModel(paramClass, paramString, (ManagedVariableModel)fetchDataStoreObservable(paramClass, paramString).toBlocking().first());
        paramClass = localManagedVariable;
      } while (localManagedVariable == null);
      mCache.put(paramString, localManagedVariable);
      paramClass = localManagedVariable;
    }
  }
  
  public <T extends ManagedVariable> UpsightSubscription fetch(final Class<T> paramClass, final String paramString, final UpsightManagedVariable.Listener<T> paramListener)
  {
    synchronized (mCache)
    {
      ManagedVariable localManagedVariable = (ManagedVariable)mCache.get(paramString);
      if (localManagedVariable != null)
      {
        paramClass = Subscriptions.from(Observable.just(localManagedVariable).observeOn(mCallbackScheduler).subscribe(new Action1()
        {
          public void call(T paramAnonymousT)
          {
            paramListener.onSuccess(paramAnonymousT);
          }
        }));
        return paramClass;
      }
      paramClass = Subscriptions.from(fetchDataStoreObservable(paramClass, paramString).subscribe(new Action1()new Action1
      {
        public void call(ManagedVariableModel paramAnonymousManagedVariableModel)
        {
          for (;;)
          {
            synchronized (mCache)
            {
              ManagedVariable localManagedVariable = (ManagedVariable)mCache.get(paramString);
              if (localManagedVariable != null)
              {
                paramListener.onSuccess(localManagedVariable);
                return;
              }
              paramAnonymousManagedVariableModel = ManagedVariableManager.this.fromModel(paramClass, paramString, paramAnonymousManagedVariableModel);
              if (paramAnonymousManagedVariableModel != null)
              {
                mCache.put(paramString, paramAnonymousManagedVariableModel);
                paramListener.onSuccess(paramAnonymousManagedVariableModel);
              }
            }
            paramListener.onFailure(new UpsightException("Invalid managed variable tag", new Object[0]));
          }
        }
      }, new Action1()
      {
        public void call(Throwable paramAnonymousThrowable)
        {
          paramListener.onFailure(new UpsightException(paramAnonymousThrowable));
        }
      }));
    }
  }
  
  @Removed
  public void handleManagedVariableRemoval(ManagedBoolean.Model paramModel)
  {
    resetValue(UpsightManagedBoolean.class, paramModel.getTag());
  }
  
  @Removed
  public void handleManagedVariableRemoval(ManagedFloat.Model paramModel)
  {
    resetValue(UpsightManagedFloat.class, paramModel.getTag());
  }
  
  @Removed
  public void handleManagedVariableRemoval(ManagedInt.Model paramModel)
  {
    resetValue(UpsightManagedInt.class, paramModel.getTag());
  }
  
  @Removed
  public void handleManagedVariableRemoval(ManagedString.Model paramModel)
  {
    resetValue(UpsightManagedString.class, paramModel.getTag());
  }
  
  @Created
  @Updated
  public void handleManagedVariableUpdate(ManagedBoolean.Model paramModel)
  {
    updateValue(UpsightManagedBoolean.class, paramModel.getTag(), paramModel.getValue());
  }
  
  @Created
  @Updated
  public void handleManagedVariableUpdate(ManagedFloat.Model paramModel)
  {
    updateValue(UpsightManagedFloat.class, paramModel.getTag(), paramModel.getValue());
  }
  
  @Created
  @Updated
  public void handleManagedVariableUpdate(ManagedInt.Model paramModel)
  {
    updateValue(UpsightManagedInt.class, paramModel.getTag(), paramModel.getValue());
  }
  
  @Created
  @Updated
  public void handleManagedVariableUpdate(ManagedString.Model paramModel)
  {
    updateValue(UpsightManagedString.class, paramModel.getTag(), paramModel.getValue());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */