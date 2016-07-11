package com.upsight.android.analytics.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConfigObjectMapperModule_ProvideConfigMapperFactory
  implements Factory<ObjectMapper>
{
  private final ConfigObjectMapperModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!ConfigObjectMapperModule_ProvideConfigMapperFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConfigObjectMapperModule_ProvideConfigMapperFactory(ConfigObjectMapperModule paramConfigObjectMapperModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramConfigObjectMapperModule != null);
    module = paramConfigObjectMapperModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<ObjectMapper> create(ConfigObjectMapperModule paramConfigObjectMapperModule, Provider<UpsightContext> paramProvider)
  {
    return new ConfigObjectMapperModule_ProvideConfigMapperFactory(paramConfigObjectMapperModule, paramProvider);
  }
  
  public ObjectMapper get()
  {
    ObjectMapper localObjectMapper = module.provideConfigMapper((UpsightContext)upsightProvider.get());
    if (localObjectMapper == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localObjectMapper;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.ConfigObjectMapperModule_ProvideConfigMapperFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */