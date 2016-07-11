package com.upsight.android.marketing.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightMarketingExtension;
import com.upsight.android.UpsightMarketingExtension_MembersInjector;
import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.UpsightMarketingApi;
import com.upsight.android.marketing.UpsightMarketingContentStore;
import com.upsight.android.marketing.internal.billboard.BillboardModule;
import com.upsight.android.marketing.internal.billboard.BillboardModule_ProvideBillboardManagerFactory;
import com.upsight.android.marketing.internal.content.ContentModule;
import com.upsight.android.marketing.internal.content.ContentModule_ProvideDefaultContentMediatorFactory;
import com.upsight.android.marketing.internal.content.ContentModule_ProvideMarketingContentFactoryFactory;
import com.upsight.android.marketing.internal.content.ContentModule_ProvideMarketingContentStoreFactory;
import com.upsight.android.marketing.internal.content.ContentModule_ProvideMarketingContentStoreImplFactory;
import com.upsight.android.marketing.internal.content.ContentModule_ProvideUpsightMarketingContentStoreFactory;
import com.upsight.android.marketing.internal.content.ContentTemplateWebViewClientFactory;
import com.upsight.android.marketing.internal.content.DaggerMarketingComponent_PackageProxy;
import com.upsight.android.marketing.internal.content.DefaultContentMediator;
import com.upsight.android.marketing.internal.content.MarketingContentFactory;
import com.upsight.android.marketing.internal.content.MarketingContentStore;
import com.upsight.android.marketing.internal.content.WebViewModule;
import com.upsight.android.marketing.internal.content.WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.inject.Provider;
import rx.Scheduler;

public final class DaggerMarketingComponent
  implements MarketingComponent
{
  private final DaggerMarketingComponent_PackageProxy com_upsight_android_marketing_internal_content_Proxy = new DaggerMarketingComponent_PackageProxy();
  private Provider<UpsightBillboardManager> provideBillboardManagerProvider;
  private Provider<ContentTemplateWebViewClientFactory> provideContentTemplateWebViewClientFactoryProvider;
  private Provider<DefaultContentMediator> provideDefaultContentMediatorProvider;
  private Provider<Scheduler> provideMainSchedulerProvider;
  private Provider<UpsightMarketingApi> provideMarketingApiProvider;
  private Provider<MarketingContentFactory> provideMarketingContentFactoryProvider;
  private Provider<MarketingContentStore> provideMarketingContentStoreProvider;
  private Provider<UpsightContext> provideUpsightContextProvider;
  private Provider<UpsightMarketingContentStore> provideUpsightMarketingContentStoreProvider;
  private MembersInjector<UpsightMarketingExtension> upsightMarketingExtensionMembersInjector;
  
  static
  {
    if (!DaggerMarketingComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerMarketingComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Builder paramBuilder)
  {
    provideUpsightContextProvider = ScopedProvider.create(BaseMarketingModule_ProvideUpsightContextFactory.create(baseMarketingModule));
    com_upsight_android_marketing_internal_content_Proxy.provideMarketingContentStoreImplProvider = ScopedProvider.create(ContentModule_ProvideMarketingContentStoreImplFactory.create(contentModule, provideUpsightContextProvider));
    provideMarketingContentStoreProvider = ScopedProvider.create(ContentModule_ProvideMarketingContentStoreFactory.create(contentModule, com_upsight_android_marketing_internal_content_Proxy.provideMarketingContentStoreImplProvider));
    provideBillboardManagerProvider = ScopedProvider.create(BillboardModule_ProvideBillboardManagerFactory.create(billboardModule, provideUpsightContextProvider, provideMarketingContentStoreProvider));
    provideUpsightMarketingContentStoreProvider = ScopedProvider.create(ContentModule_ProvideUpsightMarketingContentStoreFactory.create(contentModule, com_upsight_android_marketing_internal_content_Proxy.provideMarketingContentStoreImplProvider));
    provideMarketingApiProvider = ScopedProvider.create(BaseMarketingModule_ProvideMarketingApiFactory.create(baseMarketingModule, provideBillboardManagerProvider, provideUpsightMarketingContentStoreProvider));
    provideMainSchedulerProvider = ScopedProvider.create(BaseMarketingModule_ProvideMainSchedulerFactory.create(baseMarketingModule));
    provideContentTemplateWebViewClientFactoryProvider = ScopedProvider.create(WebViewModule_ProvideContentTemplateWebViewClientFactoryFactory.create(webViewModule, provideUpsightContextProvider));
    provideMarketingContentFactoryProvider = ScopedProvider.create(ContentModule_ProvideMarketingContentFactoryFactory.create(contentModule, provideUpsightContextProvider, provideMainSchedulerProvider, provideMarketingContentStoreProvider, provideContentTemplateWebViewClientFactoryProvider));
    provideDefaultContentMediatorProvider = ScopedProvider.create(ContentModule_ProvideDefaultContentMediatorFactory.create(contentModule));
    upsightMarketingExtensionMembersInjector = UpsightMarketingExtension_MembersInjector.create(MembersInjectors.noOp(), provideMarketingApiProvider, provideMarketingContentFactoryProvider, provideBillboardManagerProvider, provideDefaultContentMediatorProvider);
  }
  
  public void inject(UpsightMarketingExtension paramUpsightMarketingExtension)
  {
    upsightMarketingExtensionMembersInjector.injectMembers(paramUpsightMarketingExtension);
  }
  
  public static final class Builder
  {
    private BaseMarketingModule baseMarketingModule;
    private BillboardModule billboardModule;
    private ContentModule contentModule;
    private MarketingModule marketingModule;
    private WebViewModule webViewModule;
    
    public Builder baseMarketingModule(BaseMarketingModule paramBaseMarketingModule)
    {
      if (paramBaseMarketingModule == null) {
        throw new NullPointerException("baseMarketingModule");
      }
      baseMarketingModule = paramBaseMarketingModule;
      return this;
    }
    
    public Builder billboardModule(BillboardModule paramBillboardModule)
    {
      if (paramBillboardModule == null) {
        throw new NullPointerException("billboardModule");
      }
      billboardModule = paramBillboardModule;
      return this;
    }
    
    public MarketingComponent build()
    {
      if (marketingModule == null) {
        marketingModule = new MarketingModule();
      }
      if (billboardModule == null) {
        billboardModule = new BillboardModule();
      }
      if (contentModule == null) {
        contentModule = new ContentModule();
      }
      if (webViewModule == null) {
        webViewModule = new WebViewModule();
      }
      if (baseMarketingModule == null) {
        throw new IllegalStateException("baseMarketingModule must be set");
      }
      return new DaggerMarketingComponent(this, null);
    }
    
    public Builder contentModule(ContentModule paramContentModule)
    {
      if (paramContentModule == null) {
        throw new NullPointerException("contentModule");
      }
      contentModule = paramContentModule;
      return this;
    }
    
    public Builder marketingModule(MarketingModule paramMarketingModule)
    {
      if (paramMarketingModule == null) {
        throw new NullPointerException("marketingModule");
      }
      marketingModule = paramMarketingModule;
      return this;
    }
    
    public Builder webViewModule(WebViewModule paramWebViewModule)
    {
      if (paramWebViewModule == null) {
        throw new NullPointerException("webViewModule");
      }
      webViewModule = paramWebViewModule;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.DaggerMarketingComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */