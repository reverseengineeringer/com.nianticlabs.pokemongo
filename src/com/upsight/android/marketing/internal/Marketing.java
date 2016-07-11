package com.upsight.android.marketing.internal;

import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.UpsightContentMediator;
import com.upsight.android.marketing.UpsightMarketingApi;
import com.upsight.android.marketing.UpsightMarketingContentStore;
import com.upsight.android.marketing.internal.billboard.Billboard;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class Marketing
  implements UpsightMarketingApi
{
  private UpsightBillboardManager mBillboardManager;
  private UpsightMarketingContentStore mMarketingContentStore;
  
  @Inject
  public Marketing(UpsightBillboardManager paramUpsightBillboardManager, UpsightMarketingContentStore paramUpsightMarketingContentStore)
  {
    mBillboardManager = paramUpsightBillboardManager;
    mMarketingContentStore = paramUpsightMarketingContentStore;
  }
  
  public boolean isContentReady(String paramString)
  {
    return mMarketingContentStore.isContentReady(paramString);
  }
  
  public boolean registerBillboard(Billboard paramBillboard)
  {
    return mBillboardManager.registerBillboard(paramBillboard);
  }
  
  public boolean registerContentMediator(UpsightContentMediator paramUpsightContentMediator)
  {
    return mBillboardManager.registerContentMediator(paramUpsightContentMediator);
  }
  
  public boolean unregisterBillboard(Billboard paramBillboard)
  {
    return mBillboardManager.unregisterBillboard(paramBillboard);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.Marketing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */