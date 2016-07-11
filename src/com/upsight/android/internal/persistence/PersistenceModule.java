package com.upsight.android.internal.persistence;

import android.content.Context;
import com.squareup.otto.Bus;
import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import com.upsight.android.internal.persistence.storable.StorableInfoCache;
import com.upsight.android.persistence.UpsightDataStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.schedulers.Schedulers;

@Module
public final class PersistenceModule
{
  public static final String DATA_STORE_BACKGROUND = "background";
  
  @Provides
  @Named("background")
  @Singleton
  public UpsightDataStore provideBackgroundDataStore(Context paramContext, @Named("execution") Scheduler paramScheduler, StorableIdFactory paramStorableIdFactory, StorableInfoCache paramStorableInfoCache, Bus paramBus)
  {
    return new DataStore(paramContext, paramStorableInfoCache, paramStorableIdFactory, paramScheduler, Schedulers.immediate(), paramBus);
  }
  
  @Provides
  @Singleton
  UpsightDataStore provideDataStore(Context paramContext, StorableInfoCache paramStorableInfoCache, StorableIdFactory paramStorableIdFactory, @Named("execution") Scheduler paramScheduler1, @Named("callback") Scheduler paramScheduler2, Bus paramBus)
  {
    return new DataStore(paramContext, paramStorableInfoCache, paramStorableIdFactory, paramScheduler1, paramScheduler2, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.PersistenceModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */