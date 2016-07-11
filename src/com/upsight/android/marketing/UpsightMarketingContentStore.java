package com.upsight.android.marketing;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightMarketingExtension;
import com.upsight.android.logger.UpsightLogger;

public abstract class UpsightMarketingContentStore
{
  public static boolean isContentReady(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightMarketingExtension localUpsightMarketingExtension = (UpsightMarketingExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.marketing");
    if (localUpsightMarketingExtension != null) {
      return localUpsightMarketingExtension.getApi().isContentReady(paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.marketing must be registered in your Android Manifest", new Object[0]);
    return false;
  }
  
  public abstract boolean isContentReady(String paramString);
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightMarketingContentStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */