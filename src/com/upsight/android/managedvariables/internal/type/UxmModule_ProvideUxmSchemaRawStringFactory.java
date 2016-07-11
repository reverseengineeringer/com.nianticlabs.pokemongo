package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UxmModule_ProvideUxmSchemaRawStringFactory
  implements Factory<String>
{
  private final UxmModule module;
  private final Provider<UpsightContext> upsightProvider;
  private final Provider<Integer> uxmSchemaResProvider;
  
  static
  {
    if (!UxmModule_ProvideUxmSchemaRawStringFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UxmModule_ProvideUxmSchemaRawStringFactory(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<Integer> paramProvider1)
  {
    assert (paramUxmModule != null);
    module = paramUxmModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    uxmSchemaResProvider = paramProvider1;
  }
  
  public static Factory<String> create(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<Integer> paramProvider1)
  {
    return new UxmModule_ProvideUxmSchemaRawStringFactory(paramUxmModule, paramProvider, paramProvider1);
  }
  
  public String get()
  {
    String str = module.provideUxmSchemaRawString((UpsightContext)upsightProvider.get(), (Integer)uxmSchemaResProvider.get());
    if (str == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule_ProvideUxmSchemaRawStringFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */