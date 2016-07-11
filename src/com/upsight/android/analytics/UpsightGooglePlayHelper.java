package com.upsight.android.analytics;

import android.content.Intent;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.logger.UpsightLogger;

public abstract class UpsightGooglePlayHelper
{
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  public static final String PURCHASE_INAPP_DATA_SIGNATURE = "INAPP_DATA_SIGNATURE";
  public static final String PURCHASE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  public static final String PURCHASE_RESPONSE_CODE = "RESPONSE_CODE";
  public static final int PURCHASE_STATE_CANCELED = 1;
  public static final int PURCHASE_STATE_PURCHASED = 0;
  public static final int PURCHASE_STATE_REFUNDED = 2;
  
  public static void trackPurchase(UpsightContext paramUpsightContext, int paramInt, String paramString1, double paramDouble1, double paramDouble2, String paramString2, Intent paramIntent, UpsightPublisherData paramUpsightPublisherData)
    throws UpsightException
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().trackPurchase(paramInt, paramString1, paramDouble1, paramDouble2, paramString2, paramIntent, paramUpsightPublisherData);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public abstract void trackPurchase(int paramInt, String paramString1, double paramDouble1, double paramDouble2, String paramString2, Intent paramIntent, UpsightPublisherData paramUpsightPublisherData)
    throws UpsightException;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.UpsightGooglePlayHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */