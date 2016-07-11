package com.upsight.android.marketing.internal;

import com.upsight.android.marketing.internal.billboard.BillboardModule;
import com.upsight.android.marketing.internal.content.ContentModule;
import com.upsight.android.marketing.internal.content.WebViewModule;

public final class DaggerMarketingComponent$Builder
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

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.DaggerMarketingComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */