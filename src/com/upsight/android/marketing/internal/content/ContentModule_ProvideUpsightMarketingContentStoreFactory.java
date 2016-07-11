package com.upsight.android.marketing.internal.content;

import com.upsight.android.marketing.UpsightMarketingContentStore;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ContentModule_ProvideUpsightMarketingContentStoreFactory
  implements Factory<UpsightMarketingContentStore>
{
  private final Provider<MarketingContentStoreImpl> implProvider;
  private final ContentModule module;
  
  static
  {
    if (!ContentModule_ProvideUpsightMarketingContentStoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContentModule_ProvideUpsightMarketingContentStoreFactory(ContentModule paramContentModule, Provider<MarketingContentStoreImpl> paramProvider)
  {
    assert (paramContentModule != null);
    module = paramContentModule;
    assert (paramProvider != null);
    implProvider = paramProvider;
  }
  
  public static Factory<UpsightMarketingContentStore> create(ContentModule paramContentModule, Provider<MarketingContentStoreImpl> paramProvider)
  {
    return new ContentModule_ProvideUpsightMarketingContentStoreFactory(paramContentModule, paramProvider);
  }
  
  public UpsightMarketingContentStore get()
  {
    UpsightMarketingContentStore localUpsightMarketingContentStore = module.provideUpsightMarketingContentStore((MarketingContentStoreImpl)implProvider.get());
    if (localUpsightMarketingContentStore == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightMarketingContentStore;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentModule_ProvideUpsightMarketingContentStoreFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */