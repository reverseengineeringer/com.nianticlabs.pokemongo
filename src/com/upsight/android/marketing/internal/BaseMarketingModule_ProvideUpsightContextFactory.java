package com.upsight.android.marketing.internal;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;

public final class BaseMarketingModule_ProvideUpsightContextFactory
  implements Factory<UpsightContext>
{
  private final BaseMarketingModule module;
  
  static
  {
    if (!BaseMarketingModule_ProvideUpsightContextFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BaseMarketingModule_ProvideUpsightContextFactory(BaseMarketingModule paramBaseMarketingModule)
  {
    assert (paramBaseMarketingModule != null);
    module = paramBaseMarketingModule;
  }
  
  public static Factory<UpsightContext> create(BaseMarketingModule paramBaseMarketingModule)
  {
    return new BaseMarketingModule_ProvideUpsightContextFactory(paramBaseMarketingModule);
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
 * Qualified Name:     com.upsight.android.marketing.internal.BaseMarketingModule_ProvideUpsightContextFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */