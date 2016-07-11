package com.upsight.android.marketing.internal.billboard;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.internal.content.MarketingContentStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class BillboardModule
{
  @Provides
  @Singleton
  UpsightBillboardManager provideBillboardManager(UpsightContext paramUpsightContext, MarketingContentStore paramMarketingContentStore)
  {
    UpsightCoreComponent localUpsightCoreComponent = paramUpsightContext.getCoreComponent();
    return new BillboardManagerImpl(paramUpsightContext.getDataStore(), paramMarketingContentStore, localUpsightCoreComponent.bus());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.billboard.BillboardModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */