package com.upsight.android.managedvariables.internal;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;

public final class BaseManagedVariablesModule_ProvideUpsightContextFactory
  implements Factory<UpsightContext>
{
  private final BaseManagedVariablesModule module;
  
  static
  {
    if (!BaseManagedVariablesModule_ProvideUpsightContextFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseManagedVariablesModule_ProvideUpsightContextFactory(BaseManagedVariablesModule paramBaseManagedVariablesModule)
  {
    assert (paramBaseManagedVariablesModule != null);
    module = paramBaseManagedVariablesModule;
  }
  
  public static Factory<UpsightContext> create(BaseManagedVariablesModule paramBaseManagedVariablesModule)
  {
    return new BaseManagedVariablesModule_ProvideUpsightContextFactory(paramBaseManagedVariablesModule);
  }
  
  public UpsightContext get()
  {
    UpsightContext localUpsightContext = module.provideUpsightContext();
    if (localUpsightContext == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightContext;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.BaseManagedVariablesModule_ProvideUpsightContextFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */