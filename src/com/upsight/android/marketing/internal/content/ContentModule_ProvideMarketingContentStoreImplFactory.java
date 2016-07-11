package com.upsight.android.marketing.internal.content;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ContentModule_ProvideMarketingContentStoreImplFactory
  implements Factory<MarketingContentStoreImpl>
{
  private final ContentModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!ContentModule_ProvideMarketingContentStoreImplFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContentModule_ProvideMarketingContentStoreImplFactory(ContentModule paramContentModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramContentModule != null);
    module = paramContentModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<MarketingContentStoreImpl> create(ContentModule paramContentModule, Provider<UpsightContext> paramProvider)
  {
    return new ContentModule_ProvideMarketingContentStoreImplFactory(paramContentModule, paramProvider);
  }
  
  public MarketingContentStoreImpl get()
  {
    MarketingContentStoreImpl localMarketingContentStoreImpl = module.provideMarketingContentStoreImpl((UpsightContext)upsightProvider.get());
    if (localMarketingContentStoreImpl == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localMarketingContentStoreImpl;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentModule_ProvideMarketingContentStoreImplFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */