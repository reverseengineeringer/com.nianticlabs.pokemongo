package com.upsight.android.marketing.internal.content;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory
  implements Factory<ContentTemplateWebViewClientFactory>
{
  private final WebViewModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory(WebViewModule paramWebViewModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramWebViewModule != null);
    module = paramWebViewModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<ContentTemplateWebViewClientFactory> create(WebViewModule paramWebViewModule, Provider<UpsightContext> paramProvider)
  {
    return new WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory(paramWebViewModule, paramProvider);
  }
  
  public ContentTemplateWebViewClientFactory get()
  {
    ContentTemplateWebViewClientFactory localContentTemplateWebViewClientFactory = module.provideContentTemplateWebViewClientFactory((UpsightContext)upsightProvider.get());
    if (localContentTemplateWebViewClientFactory == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localContentTemplateWebViewClientFactory;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */