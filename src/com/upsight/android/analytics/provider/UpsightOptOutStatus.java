package com.upsight.android.analytics.provider;

import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.logger.UpsightLogger;

public abstract class UpsightOptOutStatus
{
  public static boolean get(UpsightContext paramUpsightContext)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null) {
      return localUpsightAnalyticsExtension.getApi().getOptOutStatus();
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return false;
  }
  
  public static void set(UpsightContext paramUpsightContext, boolean paramBoolean)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().setOptOutStatus(paramBoolean);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public abstract boolean get();
  
  public abstract void set(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.provider.UpsightOptOutStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */