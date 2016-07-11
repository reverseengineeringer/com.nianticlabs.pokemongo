package com.upsight.android.internal;

import dagger.internal.Factory;
import rx.Scheduler;

public final class SchedulersModule_ProvideSubscribeOnSchedulerFactory
  implements Factory<Scheduler>
{
  private final SchedulersModule module;
  
  static
  {
    if (!SchedulersModule_ProvideSubscribeOnSchedulerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SchedulersModule_ProvideSubscribeOnSchedulerFactory(SchedulersModule paramSchedulersModule)
  {
    assert (paramSchedulersModule != null);
    module = paramSchedulersModule;
  }
  
  public static Factory<Scheduler> create(SchedulersModule paramSchedulersModule)
  {
    return new SchedulersModule_ProvideSubscribeOnSchedulerFactory(paramSchedulersModule);
  }
  
  public Scheduler get()
  {
    Scheduler localScheduler = module.provideSubscribeOnScheduler();
    if (localScheduler == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localScheduler;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.SchedulersModule_ProvideSubscribeOnSchedulerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */