package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UxmModule_ProvideUxmBlockProviderFactory
  implements Factory<UxmBlockProvider>
{
  private final UxmModule module;
  private final Provider<UpsightContext> upsightProvider;
  private final Provider<UxmSchema> uxmSchemaProvider;
  private final Provider<String> uxmSchemaRawStringProvider;
  
  static
  {
    if (!UxmModule_ProvideUxmBlockProviderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UxmModule_ProvideUxmBlockProviderFactory(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<String> paramProvider1, Provider<UxmSchema> paramProvider2)
  {
    assert (paramUxmModule != null);
    module = paramUxmModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    uxmSchemaRawStringProvider = paramProvider1;
    assert (paramProvider2 != null);
    uxmSchemaProvider = paramProvider2;
  }
  
  public static Factory<UxmBlockProvider> create(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<String> paramProvider1, Provider<UxmSchema> paramProvider2)
  {
    return new UxmModule_ProvideUxmBlockProviderFactory(paramUxmModule, paramProvider, paramProvider1, paramProvider2);
  }
  
  public UxmBlockProvider get()
  {
    UxmBlockProvider localUxmBlockProvider = module.provideUxmBlockProvider((UpsightContext)upsightProvider.get(), (String)uxmSchemaRawStringProvider.get(), (UxmSchema)uxmSchemaProvider.get());
    if (localUxmBlockProvider == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUxmBlockProvider;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmBlockProviderFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */