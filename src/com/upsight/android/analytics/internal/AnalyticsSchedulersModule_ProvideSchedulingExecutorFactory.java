package com.upsight.android.analytics.internal;

import dagger.internal.Factory;
import rx.Scheduler;

public final class AnalyticsSchedulersModule_ProvideSchedulingExecutorFactory
  implements Factory<Scheduler>
{
  private final AnalyticsSchedulersModule module;
  
  static
  {
    if (!AnalyticsSchedulersModule_ProvideSchedulingExecutorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AnalyticsSchedulersModule_ProvideSchedulingExecutorFactory(AnalyticsSchedulersModule paramAnalyticsSchedulersModule)
  {
    assert (paramAnalyticsSchedulersModule != null);
    module = paramAnalyticsSchedulersModule;
  }
  
  public static Factory<Scheduler> create(AnalyticsSchedulersModule paramAnalyticsSchedulersModule)
  {
    return new AnalyticsSchedulersModule_ProvideSchedulingExecutorFactory(paramAnalyticsSchedulersModule);
  }
  
  public Scheduler get()
  {
    Scheduler localScheduler = module.provideSchedulingExecutor();
    if (localScheduler == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localScheduler;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsSchedulersModule_ProvideSchedulingExecutorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */