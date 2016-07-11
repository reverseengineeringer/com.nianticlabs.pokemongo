package com.upsight.android.analytics.internal;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;

public final class BaseAnalyticsModule_ProvideUpsightContextFactory
  implements Factory<UpsightContext>
{
  private final BaseAnalyticsModule module;
  
  static
  {
    if (!BaseAnalyticsModule_ProvideUpsightContextFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseAnalyticsModule_ProvideUpsightContextFactory(BaseAnalyticsModule paramBaseAnalyticsModule)
  {
    assert (paramBaseAnalyticsModule != null);
    module = paramBaseAnalyticsModule;
  }
  
  public static Factory<UpsightContext> create(BaseAnalyticsModule paramBaseAnalyticsModule)
  {
    return new BaseAnalyticsModule_ProvideUpsightContextFactory(paramBaseAnalyticsModule);
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
 * Qualified Name:     com.upsight.android.analytics.internal.BaseAnalyticsModule_ProvideUpsightContextFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */