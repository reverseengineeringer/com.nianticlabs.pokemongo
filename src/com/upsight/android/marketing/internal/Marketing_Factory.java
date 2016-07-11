package com.upsight.android.marketing.internal;

import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.UpsightMarketingContentStore;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class Marketing_Factory
  implements Factory<Marketing>
{
  private final Provider<UpsightBillboardManager> billboardManagerProvider;
  private final Provider<UpsightMarketingContentStore> marketingContentStoreProvider;
  
  static
  {
    if (!Marketing_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Marketing_Factory(Provider<UpsightBillboardManager> paramProvider, Provider<UpsightMarketingContentStore> paramProvider1)
  {
    assert (paramProvider != null);
    billboardManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    marketingContentStoreProvider = paramProvider1;
  }
  
  public static Factory<Marketing> create(Provider<UpsightBillboardManager> paramProvider, Provider<UpsightMarketingContentStore> paramProvider1)
  {
    return new Marketing_Factory(paramProvider, paramProvider1);
  }
  
  public Marketing get()
  {
    return new Marketing((UpsightBillboardManager)billboardManagerProvider.get(), (UpsightMarketingContentStore)marketingContentStoreProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.Marketing_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */