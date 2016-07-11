package com.upsight.android.internal.persistence.storable;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class StorableModule_ProvideStorableInfoCacheFactory
  implements Factory<StorableInfoCache>
{
  private final StorableModule module;
  private final Provider<ObjectMapper> objectMapperProvider;
  
  static
  {
    if (!StorableModule_ProvideStorableInfoCacheFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public StorableModule_ProvideStorableInfoCacheFactory(StorableModule paramStorableModule, Provider<ObjectMapper> paramProvider)
  {
    assert (paramStorableModule != null);
    module = paramStorableModule;
    assert (paramProvider != null);
    objectMapperProvider = paramProvider;
  }
  
  public static Factory<StorableInfoCache> create(StorableModule paramStorableModule, Provider<ObjectMapper> paramProvider)
  {
    return new StorableModule_ProvideStorableInfoCacheFactory(paramStorableModule, paramProvider);
  }
  
  public StorableInfoCache get()
  {
    StorableInfoCache localStorableInfoCache = module.provideStorableInfoCache((ObjectMapper)objectMapperProvider.get());
    if (localStorableInfoCache == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localStorableInfoCache;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableModule_ProvideStorableInfoCacheFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */