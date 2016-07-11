package com.upsight.android.managedvariables.internal;

import dagger.internal.Factory;
import rx.Scheduler;

public final class BaseManagedVariablesModule_ProvideMainSchedulerFactory
  implements Factory<Scheduler>
{
  private final BaseManagedVariablesModule module;
  
  static
  {
    if (!BaseManagedVariablesModule_ProvideMainSchedulerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseManagedVariablesModule_ProvideMainSchedulerFactory(BaseManagedVariablesModule paramBaseManagedVariablesModule)
  {
    assert (paramBaseManagedVariablesModule != null);
    module = paramBaseManagedVariablesModule;
  }
  
  public static Factory<Scheduler> create(BaseManagedVariablesModule paramBaseManagedVariablesModule)
  {
    return new BaseManagedVariablesModule_ProvideMainSchedulerFactory(paramBaseManagedVariablesModule);
  }
  
  public Scheduler get()
  {
    Scheduler localScheduler = module.provideMainScheduler();
    if (localScheduler == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localScheduler;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.BaseManagedVariablesModule_ProvideMainSchedulerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */