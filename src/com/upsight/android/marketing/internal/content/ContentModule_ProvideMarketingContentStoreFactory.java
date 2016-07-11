package com.upsight.android.marketing.internal.content;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ContentModule_ProvideMarketingContentStoreFactory
  implements Factory<MarketingContentStore>
{
  private final Provider<MarketingContentStoreImpl> implProvider;
  private final ContentModule module;
  
  static
  {
    if (!ContentModule_ProvideMarketingContentStoreFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContentModule_ProvideMarketingContentStoreFactory(ContentModule paramContentModule, Provider<MarketingContentStoreImpl> paramProvider)
  {
    assert (paramContentModule != null);
    module = paramContentModule;
    assert (paramProvider != null);
    implProvider = paramProvider;
  }
  
  public static Factory<MarketingContentStore> create(ContentModule paramContentModule, Provider<MarketingContentStoreImpl> paramProvider)
  {
    return new ContentModule_ProvideMarketingContentStoreFactory(paramContentModule, paramProvider);
  }
  
  public MarketingContentStore get()
  {
    MarketingContentStore localMarketingContentStore = module.provideMarketingContentStore((MarketingContentStoreImpl)implProvider.get());
    if (localMarketingContentStore == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localMarketingContentStore;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentModule_ProvideMarketingContentStoreFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */