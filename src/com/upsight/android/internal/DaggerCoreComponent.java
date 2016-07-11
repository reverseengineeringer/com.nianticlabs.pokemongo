package com.upsight.android.internal;

import android.content.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.UpsightContext;
import com.upsight.android.internal.logger.LogWriter;
import com.upsight.android.internal.logger.LoggerModule;
import com.upsight.android.internal.logger.LoggerModule_ProvideUpsightLoggerFactory;
import com.upsight.android.internal.persistence.PersistenceModule;
import com.upsight.android.internal.persistence.PersistenceModule_ProvideBackgroundDataStoreFactory;
import com.upsight.android.internal.persistence.PersistenceModule_ProvideDataStoreFactory;
import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import com.upsight.android.internal.persistence.storable.StorableInfoCache;
import com.upsight.android.internal.persistence.storable.StorableModule;
import com.upsight.android.internal.persistence.storable.StorableModule_ProvideStorableInfoCacheFactory;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import dagger.internal.ScopedProvider;
import javax.inject.Provider;
import rx.Scheduler;

public final class DaggerCoreComponent
  implements CoreComponent
{
  private Provider<Context> provideApplicationContextProvider;
  private Provider<String> provideApplicationTokenProvider;
  private Provider<UpsightDataStore> provideBackgroundDataStoreProvider;
  private Provider<Bus> provideBusProvider;
  private Provider<UpsightDataStore> provideDataStoreProvider;
  private Provider<LogWriter> provideLogWriterProvider;
  private Provider<ObjectMapper> provideObjectMapperProvider;
  private Provider<Scheduler> provideObserveOnSchedulerProvider;
  private Provider<String> providePublicKeyProvider;
  private Provider<String> provideSdkPluginProvider;
  private Provider<StorableInfoCache> provideStorableInfoCacheProvider;
  private Provider<Scheduler> provideSubscribeOnSchedulerProvider;
  private Provider<StorableIdFactory> provideTypeIdGeneratorProvider;
  private Provider<UpsightContext> provideUpsightContextProvider;
  private Provider<UpsightLogger> provideUpsightLoggerProvider;
  
  static
  {
    if (!DaggerCoreComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerCoreComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Builder paramBuilder)
  {
    provideApplicationContextProvider = ScopedProvider.create(ContextModule_ProvideApplicationContextFactory.create(contextModule));
    provideObjectMapperProvider = ScopedProvider.create(ObjectMapperModule_ProvideObjectMapperFactory.create(objectMapperModule));
    provideStorableInfoCacheProvider = ScopedProvider.create(StorableModule_ProvideStorableInfoCacheFactory.create(storableModule, provideObjectMapperProvider));
    provideTypeIdGeneratorProvider = ScopedProvider.create(ContextModule_ProvideTypeIdGeneratorFactory.create(contextModule));
    provideSubscribeOnSchedulerProvider = ScopedProvider.create(SchedulersModule_ProvideSubscribeOnSchedulerFactory.create(schedulersModule));
    provideObserveOnSchedulerProvider = ScopedProvider.create(SchedulersModule_ProvideObserveOnSchedulerFactory.create(schedulersModule));
    provideBusProvider = ScopedProvider.create(ContextModule_ProvideBusFactory.create(contextModule));
    provideDataStoreProvider = ScopedProvider.create(PersistenceModule_ProvideDataStoreFactory.create(persistenceModule, provideApplicationContextProvider, provideStorableInfoCacheProvider, provideTypeIdGeneratorProvider, provideSubscribeOnSchedulerProvider, provideObserveOnSchedulerProvider, provideBusProvider));
    provideLogWriterProvider = ScopedProvider.create(ContextModule_ProvideLogWriterFactory.create(contextModule));
    provideUpsightLoggerProvider = ScopedProvider.create(LoggerModule_ProvideUpsightLoggerFactory.create(loggerModule, provideDataStoreProvider, provideLogWriterProvider));
    provideSdkPluginProvider = ScopedProvider.create(PropertiesModule_ProvideSdkPluginFactory.create(propertiesModule, provideApplicationContextProvider, provideUpsightLoggerProvider));
    provideApplicationTokenProvider = ScopedProvider.create(PropertiesModule_ProvideApplicationTokenFactory.create(propertiesModule, provideApplicationContextProvider, provideUpsightLoggerProvider));
    providePublicKeyProvider = ScopedProvider.create(PropertiesModule_ProvidePublicKeyFactory.create(propertiesModule, provideApplicationContextProvider, provideUpsightLoggerProvider));
    provideUpsightContextProvider = ScopedProvider.create(UpsightContextModule_ProvideUpsightContextFactory.create(upsightContextModule, provideApplicationContextProvider, provideSdkPluginProvider, provideApplicationTokenProvider, providePublicKeyProvider, provideDataStoreProvider, provideUpsightLoggerProvider));
    provideBackgroundDataStoreProvider = ScopedProvider.create(PersistenceModule_ProvideBackgroundDataStoreFactory.create(persistenceModule, provideApplicationContextProvider, provideSubscribeOnSchedulerProvider, provideTypeIdGeneratorProvider, provideStorableInfoCacheProvider, provideBusProvider));
  }
  
  public Context applicationContext()
  {
    return (Context)provideApplicationContextProvider.get();
  }
  
  public UpsightDataStore backgroundDataStore()
  {
    return (UpsightDataStore)provideBackgroundDataStoreProvider.get();
  }
  
  public Bus bus()
  {
    return (Bus)provideBusProvider.get();
  }
  
  public ObjectMapper objectMapper()
  {
    return (ObjectMapper)provideObjectMapperProvider.get();
  }
  
  public Scheduler observeOnScheduler()
  {
    return (Scheduler)provideObserveOnSchedulerProvider.get();
  }
  
  public Scheduler subscribeOnScheduler()
  {
    return (Scheduler)provideSubscribeOnSchedulerProvider.get();
  }
  
  public UpsightContext upsightContext()
  {
    return (UpsightContext)provideUpsightContextProvider.get();
  }
  
  public static final class Builder
  {
    private ContextModule contextModule;
    private CoreModule coreModule;
    private LoggerModule loggerModule;
    private ObjectMapperModule objectMapperModule;
    private PersistenceModule persistenceModule;
    private PropertiesModule propertiesModule;
    private SchedulersModule schedulersModule;
    private StorableModule storableModule;
    private UpsightContextModule upsightContextModule;
    
    public CoreComponent build()
    {
      if (coreModule == null) {
        coreModule = new CoreModule();
      }
      if (upsightContextModule == null) {
        upsightContextModule = new UpsightContextModule();
      }
      if (contextModule == null) {
        throw new IllegalStateException("contextModule must be set");
      }
      if (propertiesModule == null) {
        propertiesModule = new PropertiesModule();
      }
      if (objectMapperModule == null) {
        objectMapperModule = new ObjectMapperModule();
      }
      if (schedulersModule == null) {
        schedulersModule = new SchedulersModule();
      }
      if (storableModule == null) {
        storableModule = new StorableModule();
      }
      if (persistenceModule == null) {
        persistenceModule = new PersistenceModule();
      }
      if (loggerModule == null) {
        loggerModule = new LoggerModule();
      }
      return new DaggerCoreComponent(this, null);
    }
    
    public Builder contextModule(ContextModule paramContextModule)
    {
      if (paramContextModule == null) {
        throw new NullPointerException("contextModule");
      }
      contextModule = paramContextModule;
      return this;
    }
    
    public Builder coreModule(CoreModule paramCoreModule)
    {
      if (paramCoreModule == null) {
        throw new NullPointerException("coreModule");
      }
      coreModule = paramCoreModule;
      return this;
    }
    
    public Builder loggerModule(LoggerModule paramLoggerModule)
    {
      if (paramLoggerModule == null) {
        throw new NullPointerException("loggerModule");
      }
      loggerModule = paramLoggerModule;
      return this;
    }
    
    public Builder objectMapperModule(ObjectMapperModule paramObjectMapperModule)
    {
      if (paramObjectMapperModule == null) {
        throw new NullPointerException("objectMapperModule");
      }
      objectMapperModule = paramObjectMapperModule;
      return this;
    }
    
    public Builder persistenceModule(PersistenceModule paramPersistenceModule)
    {
      if (paramPersistenceModule == null) {
        throw new NullPointerException("persistenceModule");
      }
      persistenceModule = paramPersistenceModule;
      return this;
    }
    
    public Builder propertiesModule(PropertiesModule paramPropertiesModule)
    {
      if (paramPropertiesModule == null) {
        throw new NullPointerException("propertiesModule");
      }
      propertiesModule = paramPropertiesModule;
      return this;
    }
    
    public Builder schedulersModule(SchedulersModule paramSchedulersModule)
    {
      if (paramSchedulersModule == null) {
        throw new NullPointerException("schedulersModule");
      }
      schedulersModule = paramSchedulersModule;
      return this;
    }
    
    public Builder storableModule(StorableModule paramStorableModule)
    {
      if (paramStorableModule == null) {
        throw new NullPointerException("storableModule");
      }
      storableModule = paramStorableModule;
      return this;
    }
    
    public Builder upsightContextModule(UpsightContextModule paramUpsightContextModule)
    {
      if (paramUpsightContextModule == null) {
        throw new NullPointerException("upsightContextModule");
      }
      upsightContextModule = paramUpsightContextModule;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.DaggerCoreComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */