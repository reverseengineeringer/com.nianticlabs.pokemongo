package com.upsight.android.internal.persistence;

import android.content.Context;
import com.squareup.otto.Bus;
import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import com.upsight.android.internal.persistence.storable.StorableInfoCache;
import com.upsight.android.persistence.UpsightDataStore;
import dagger.internal.Factory;
import javax.inject.Provider;
import rx.Scheduler;

public final class PersistenceModule_ProvideBackgroundDataStoreFactory
  implements Factory<UpsightDataStore>
{
  private final Provider<Bus> busProvider;
  private final Provider<Context> contextProvider;
  private final Provider<StorableIdFactory> idFactoryProvider;
  private final Provider<StorableInfoCache> infoCacheProvider;
  private final PersistenceModule module;
  private final Provider<Scheduler> subscribeOnSchedulerProvider;
  
  static
  {
    if (!PersistenceModule_ProvideBackgroundDataStoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PersistenceModule_ProvideBackgroundDataStoreFactory(PersistenceModule paramPersistenceModule, Provider<Context> paramProvider, Provider<Scheduler> paramProvider1, Provider<StorableIdFactory> paramProvider2, Provider<StorableInfoCache> paramProvider3, Provider<Bus> paramProvider4)
  {
    assert (paramPersistenceModule != null);
    module = paramPersistenceModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    subscribeOnSchedulerProvider = paramProvider1;
    assert (paramProvider2 != null);
    idFactoryProvider = paramProvider2;
    assert (paramProvider3 != null);
    infoCacheProvider = paramProvider3;
    assert (paramProvider4 != null);
    busProvider = paramProvider4;
  }
  
  public static Factory<UpsightDataStore> create(PersistenceModule paramPersistenceModule, Provider<Context> paramProvider, Provider<Scheduler> paramProvider1, Provider<StorableIdFactory> paramProvider2, Provider<StorableInfoCache> paramProvider3, Provider<Bus> paramProvider4)
  {
    return new PersistenceModule_ProvideBackgroundDataStoreFactory(paramPersistenceModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
  
  public UpsightDataStore get()
  {
    UpsightDataStore localUpsightDataStore = module.provideBackgroundDataStore((Context)contextProvider.get(), (Scheduler)subscribeOnSchedulerProvider.get(), (StorableIdFactory)idFactoryProvider.get(), (StorableInfoCache)infoCacheProvider.get(), (Bus)busProvider.get());
    if (localUpsightDataStore == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightDataStore;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.PersistenceModule_ProvideBackgroundDataStoreFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */