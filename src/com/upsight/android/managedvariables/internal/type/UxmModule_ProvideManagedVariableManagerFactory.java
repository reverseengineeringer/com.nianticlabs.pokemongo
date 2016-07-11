package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;
import rx.Scheduler;

public final class UxmModule_ProvideManagedVariableManagerFactory
  implements Factory<ManagedVariableManager>
{
  private final UxmModule module;
  private final Provider<Scheduler> schedulerProvider;
  private final Provider<UpsightContext> upsightProvider;
  private final Provider<UxmSchema> uxmSchemaProvider;
  
  static
  {
    if (!UxmModule_ProvideManagedVariableManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UxmModule_ProvideManagedVariableManagerFactory(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<Scheduler> paramProvider1, Provider<UxmSchema> paramProvider2)
  {
    assert (paramUxmModule != null);
    module = paramUxmModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    schedulerProvider = paramProvider1;
    assert (paramProvider2 != null);
    uxmSchemaProvider = paramProvider2;
  }
  
  public static Factory<ManagedVariableManager> create(UxmModule paramUxmModule, Provider<UpsightContext> paramProvider, Provider<Scheduler> paramProvider1, Provider<UxmSchema> paramProvider2)
  {
    return new UxmModule_ProvideManagedVariableManagerFactory(paramUxmModule, paramProvider, paramProvider1, paramProvider2);
  }
  
  public ManagedVariableManager get()
  {
    ManagedVariableManager localManagedVariableManager = module.provideManagedVariableManager((UpsightContext)upsightProvider.get(), (Scheduler)schedulerProvider.get(), (UxmSchema)uxmSchemaProvider.get());
    if (localManagedVariableManager == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localManagedVariableManager;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule_ProvideManagedVariableManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */