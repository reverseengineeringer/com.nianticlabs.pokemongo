package com.upsight.android.analytics.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

class GooglePlayHelper$PurchaseData
{
  @JsonProperty("developerPayload")
  String developerPayload;
  @JsonProperty("orderId")
  String orderId;
  @JsonProperty("packageName")
  String packageName;
  @JsonProperty("productId")
  String productId;
  @JsonProperty("purchaseState")
  int purchaseState;
  @JsonProperty("purchaseTime")
  long purchaseTime;
  @JsonProperty("purchaseToken")
  String purchaseToken;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.GooglePlayHelper.PurchaseData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */