package com.nianticlabs.nia.iap;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class GoogleInAppPurchaseData
{
  private static final String TAG = "GoogleInAppPurchaseData";
  private String developerPayload;
  private String orderId;
  private String packageName;
  private String productId;
  private String purchaseState;
  private long purchaseTime;
  
  static GoogleInAppPurchaseData fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      GoogleInAppPurchaseData localGoogleInAppPurchaseData = new GoogleInAppPurchaseData();
      orderId = paramString.getString("orderId");
      packageName = paramString.getString("packageName");
      productId = paramString.getString("productId");
      purchaseTime = paramString.getLong("purchaseTime");
      purchaseState = paramString.getString("purchaseState");
      developerPayload = paramString.getString("developerPayload");
      return localGoogleInAppPurchaseData;
    }
    catch (JSONException paramString)
    {
      Log.e("GoogleInAppPurchaseData", "Failed to parse GoogleInAppPurchaseData: %s", paramString);
    }
    return null;
  }
  
  String getDeveloperPayload()
  {
    return developerPayload;
  }
  
  String getOrderId()
  {
    return orderId;
  }
  
  String getPackageName()
  {
    return packageName;
  }
  
  String getProductId()
  {
    return productId;
  }
  
  String getPurchaseState()
  {
    return purchaseState;
  }
  
  long getPurchaseTime()
  {
    return purchaseTime;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppPurchaseData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */