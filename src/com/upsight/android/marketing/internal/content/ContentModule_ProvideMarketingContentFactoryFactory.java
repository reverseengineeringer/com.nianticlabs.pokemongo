package com.upsight.android.marketing.internal.content;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;
import rx.Scheduler;

public final class ContentModule_ProvideMarketingContentFactoryFactory
  implements Factory<MarketingContentFactory>
{
  private final Provider<MarketingContentStore> contentStoreProvider;
  private final Provider<ContentTemplateWebViewClientFactory> contentTemplateWebViewClientFactoryProvider;
  private final ContentModule module;
  private final Provider<Scheduler> schedulerProvider;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!ContentModule_ProvideMarketingContentFactoryFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContentModule_ProvideMarketingContentFactoryFactory(ContentModule paramContentModule, Provider<UpsightContext> paramProvider, Provider<Scheduler> paramProvider1, Provider<MarketingContentStore> paramProvider2, Provider<ContentTemplateWebViewClientFactory> paramProvider3)
  {
    assert (paramContentModule != null);
    module = paramContentModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    schedulerProvider = paramProvider1;
    assert (paramProvider2 != null);
    contentStoreProvider = paramProvider2;
    assert (paramProvider3 != null);
    contentTemplateWebViewClientFactoryProvider = paramProvider3;
  }
  
  public static Factory<MarketingContentFactory> create(ContentModule paramContentModule, Provider<UpsightContext> paramProvider, Provider<Scheduler> paramProvider1, Provider<MarketingContentStore> paramProvider2, Provider<ContentTemplateWebViewClientFactory> paramProvider3)
  {
    return new ContentModule_ProvideMarketingContentFactoryFactory(paramContentModule, paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public MarketingContentFactory get()
  {
    MarketingContentFactory localMarketingContentFactory = module.provideMarketingContentFactory((UpsightContext)upsightProvider.get(), (Scheduler)schedulerProvider.get(), (MarketingContentStore)contentStoreProvider.get(), (ContentTemplateWebViewClientFactory)contentTemplateWebViewClientFactoryProvider.get());
    if (localMarketingContentFactory == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localMarketingContentFactory;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentModule_ProvideMarketingContentFactoryFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */