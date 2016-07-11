package com.upsight.android.analytics.internal;

import com.upsight.android.internal.util.Opt;
import dagger.internal.Factory;

public final class BaseAnalyticsModule_ProvideUncaughtExceptionHandlerFactory
  implements Factory<Opt<Thread.UncaughtExceptionHandler>>
{
  private final BaseAnalyticsModule module;
  
  static
  {
    if (!BaseAnalyticsModule_ProvideUncaughtExceptionHandlerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseAnalyticsModule_ProvideUncaughtExceptionHandlerFactory(BaseAnalyticsModule paramBaseAnalyticsModule)
  {
    assert (paramBaseAnalyticsModule != null);
    module = paramBaseAnalyticsModule;
  }
  
  public static Factory<Opt<Thread.UncaughtExceptionHandler>> create(BaseAnalyticsModule paramBaseAnalyticsModule)
  {
    return new BaseAnalyticsModule_ProvideUncaughtExceptionHandlerFactory(paramBaseAnalyticsModule);
  }
  
  public Opt<Thread.UncaughtExceptionHandler> get()
  {
    Opt localOpt = module.provideUncaughtExceptionHandler();
    if (localOpt == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localOpt;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.BaseAnalyticsModule_ProvideUncaughtExceptionHandlerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */