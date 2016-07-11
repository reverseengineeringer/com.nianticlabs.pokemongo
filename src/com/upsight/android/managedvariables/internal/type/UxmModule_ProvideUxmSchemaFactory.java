package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UxmModule_ProvideUxmSchemaFactory
  implements Factory<UxmSchema>
{
  private final UxmModule module;
  private final Provider<UpsightContext> upsightProvider;
  private final Provider<ObjectMapper> uxmSchemaMapperProvider;
  private final Provider<String> uxmSchemaStringProvider;
  
  static
  {
    if (!UxmModule_ProvideUxmSchemaFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UxmModule_ProvideUxmSchemaFactory(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<ObjectMapper> paramProvider1, Provider<String> paramProvider2)
  {
    assert (paramUxmModule != null);
    module = paramUxmModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    uxmSchemaMapperProvider = paramProvider1;
    assert (paramProvider2 != null);
    uxmSchemaStringProvider = paramProvider2;
  }
  
  public static Factory<UxmSchema> create(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<ObjectMapper> paramProvider1, Provider<String> paramProvider2)
  {
    return new UxmModule_ProvideUxmSchemaFactory(paramUxmModule, paramProvider, paramProvider1, paramProvider2);
  }
  
  public UxmSchema get()
  {
    UxmSchema localUxmSchema = module.provideUxmSchema((UpsightContext)upsightProvider.get(), (ObjectMapper)uxmSchemaMapperProvider.get(), (String)uxmSchemaStringProvider.get());
    if (localUxmSchema == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUxmSchema;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmSchemaFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */