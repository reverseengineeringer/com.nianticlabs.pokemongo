package com.upsight.android.marketing.internal;

import dagger.internal.Factory;
import rx.Scheduler;

public final class BaseMarketingModule_ProvideMainSchedulerFactory
  implements Factory<Scheduler>
{
  private final BaseMarketingModule module;
  
  static
  {
    if (!BaseMarketingModule_ProvideMainSchedulerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseMarketingModule_ProvideMainSchedulerFactory(BaseMarketingModule paramBaseMarketingModule)
  {
    assert (paramBaseMarketingModule != null);
    module = paramBaseMarketingModule;
  }
  
  public static Factory<Scheduler> create(BaseMarketingModule paramBaseMarketingModule)
  {
    return new BaseMarketingModule_ProvideMainSchedulerFactory(paramBaseMarketingModule);
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
 * Qualified Name:     com.upsight.android.marketing.internal.BaseMarketingModule_ProvideMainSchedulerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */