package com.upsight.android.internal.persistence;

import android.content.Context;
import com.squareup.otto.Bus;
import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import com.upsight.android.internal.persistence.storable.StorableInfoCache;
import com.upsight.android.persistence.UpsightDataStore;
import dagger.internal.Factory;
import javax.inject.Provider;
import rx.Scheduler;

public final class PersistenceModule_ProvideDataStoreFactory
  implements Factory<UpsightDataStore>
{
  private final Provider<Bus> busProvider;
  private final Provider<Context> contextProvider;
  private final Provider<StorableIdFactory> idFactoryProvider;
  private final Provider<StorableInfoCache> infoCacheProvider;
  private final PersistenceModule module;
  private final Provider<Scheduler> observeOnSchedulerProvider;
  private final Provider<Scheduler> subscribeOnSchedulerProvider;
  
  static
  {
    if (!PersistenceModule_ProvideDataStoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PersistenceModule_ProvideDataStoreFactory(PersistenceModule paramPersistenceModule, Provider<Context> paramProvider, Provider<StorableInfoCache> paramProvider1, Provider<StorableIdFactory> paramProvider2, Provider<Scheduler> paramProvider3, Provider<Scheduler> paramProvider4, Provider<Bus> paramProvider5)
  {
    assert (paramPersistenceModule != null);
    module = paramPersistenceModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    infoCacheProvider = paramProvider1;
    assert (paramProvider2 != null);
    idFactoryProvider = paramProvider2;
    assert (paramProvider3 != null);
    subscribeOnSchedulerProvider = paramProvider3;
    assert (paramProvider4 != null);
    observeOnSchedulerProvider = paramProvider4;
    assert (paramProvider5 != null);
    busProvider = paramProvider5;
  }
  
  public static Factory<UpsightDataStore> create(PersistenceModule paramPersistenceModule, Provider<Context> paramProvider, Provider<StorableInfoCache> paramProvider1, Provider<StorableIdFactory> paramProvider2, Provider<Scheduler> paramProvider3, Provider<Scheduler> paramProvider4, Provider<Bus> paramProvider5)
  {
    return new PersistenceModule_ProvideDataStoreFactory(paramPersistenceModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
  
  public UpsightDataStore get()
  {
    UpsightDataStore localUpsightDataStore = module.provideDataStore((Context)contextProvider.get(), (StorableInfoCache)infoCacheProvider.get(), (StorableIdFactory)idFactoryProvider.get(), (Scheduler)subscribeOnSchedulerProvider.get(), (Scheduler)observeOnSchedulerProvider.get(), (Bus)busProvider.get());
    if (localUpsightDataStore == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightDataStore;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.PersistenceModule_ProvideDataStoreFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */