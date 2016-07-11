package com.upsight.android.marketing.internal.billboard;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightMarketingExtension;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.marketing.UpsightBillboard;
import com.upsight.android.marketing.UpsightBillboard.Handler;
import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.internal.content.MarketingContent;

public class Billboard
  extends UpsightBillboard
{
  private UpsightBillboardManager mBillboardManager;
  private MarketingContent mContent = null;
  protected final UpsightBillboard.Handler mHandler;
  protected final String mScope;
  
  public Billboard(String paramString, UpsightBillboard.Handler paramHandler)
  {
    mScope = paramString;
    mHandler = paramHandler;
  }
  
  public final void destroy()
  {
    UpsightBillboardManager localUpsightBillboardManager = mBillboardManager;
    if (localUpsightBillboardManager != null)
    {
      localUpsightBillboardManager.unregisterBillboard(this);
      mBillboardManager = null;
    }
  }
  
  UpsightBillboard.Handler getHandler()
  {
    return mHandler;
  }
  
  MarketingContent getMarketingContent()
  {
    return mContent;
  }
  
  String getScope()
  {
    return mScope;
  }
  
  void setMarketingContent(MarketingContent paramMarketingContent)
  {
    mContent = paramMarketingContent;
  }
  
  public final UpsightBillboard setUp(UpsightContext paramUpsightContext)
    throws IllegalStateException
  {
    Object localObject = null;
    UpsightMarketingExtension localUpsightMarketingExtension = (UpsightMarketingExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.marketing");
    if (localUpsightMarketingExtension != null) {}
    for (paramUpsightContext = localUpsightMarketingExtension.getApi(); paramUpsightContext != null; paramUpsightContext = (UpsightContext)localObject)
    {
      mBillboardManager = paramUpsightContext;
      if (mBillboardManager.registerBillboard(this)) {
        break;
      }
      paramUpsightContext = UpsightBillboard.class.getSimpleName();
      throw new IllegalStateException("An active " + paramUpsightContext + " with the same scope already exists. A billboard remains active until either a content view is attached, or " + paramUpsightContext + "#destroy() is called.");
      paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.marketing must be registered in your Android Manifest", new Object[0]);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.billboard.Billboard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */