package com.upsight.android.marketing.internal.billboard;

import com.upsight.android.UpsightContext;
import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.internal.content.MarketingContentStore;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BillboardModule_ProvideBillboardManagerFactory
  implements Factory<UpsightBillboardManager>
{
  private final Provider<MarketingContentStore> contentStoreProvider;
  private final BillboardModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!BillboardModule_ProvideBillboardManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public BillboardModule_ProvideBillboardManagerFactory(BillboardModule paramBillboardModule, Provider<UpsightContext> paramProvider, Provider<MarketingContentStore> paramProvider1)
  {
    assert (paramBillboardModule != null);
    module = paramBillboardModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    contentStoreProvider = paramProvider1;
  }
  
  public static Factory<UpsightBillboardManager> create(BillboardModule paramBillboardModule, Provider<UpsightContext> paramProvider, Provider<MarketingContentStore> paramProvider1)
  {
    return new BillboardModule_ProvideBillboardManagerFactory(paramBillboardModule, paramProvider, paramProvider1);
  }
  
  public UpsightBillboardManager get()
  {
    UpsightBillboardManager localUpsightBillboardManager = module.provideBillboardManager((UpsightContext)upsightProvider.get(), (MarketingContentStore)contentStoreProvider.get());
    if (localUpsightBillboardManager == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightBillboardManager;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.billboard.BillboardModule_ProvideBillboardManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */