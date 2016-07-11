package com.upsight.android.marketing.internal;

import com.upsight.android.marketing.internal.billboard.BillboardModule;
import com.upsight.android.marketing.internal.content.ContentModule;
import com.upsight.android.marketing.internal.content.WebViewModule;
import dagger.Module;

@Module(includes={BillboardModule.class, ContentModule.class, WebViewModule.class, BaseMarketingModule.class})
public class MarketingModule {}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.MarketingModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */