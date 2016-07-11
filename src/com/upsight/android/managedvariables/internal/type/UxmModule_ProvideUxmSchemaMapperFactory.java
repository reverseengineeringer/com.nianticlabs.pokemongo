package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UxmModule_ProvideUxmSchemaMapperFactory
  implements Factory<ObjectMapper>
{
  private final UxmModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!UxmModule_ProvideUxmSchemaMapperFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UxmModule_ProvideUxmSchemaMapperFactory(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramUxmModule != null);
    module = paramUxmModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<ObjectMapper> create(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider)
  {
    return new UxmModule_ProvideUxmSchemaMapperFactory(paramUxmModule, paramProvider);
  }
  
  public ObjectMapper get()
  {
    ObjectMapper localObjectMapper = module.provideUxmSchemaMapper((UpsightContext)upsightProvider.get());
    if (localObjectMapper == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localObjectMapper;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmSchemaMapperFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */