package com.upsight.android.internal;

import com.upsight.android.internal.logger.LoggerModule;
import com.upsight.android.internal.persistence.PersistenceModule;
import com.upsight.android.internal.persistence.storable.StorableModule;

public final class DaggerCoreComponent$Builder
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

/* Location:
 * Qualified Name:     com.upsight.android.internal.DaggerCoreComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */