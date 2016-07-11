package com.upsight.android.marketing;

import org.json.JSONObject;

public abstract interface UpsightReward
{
  public abstract String getProduct();
  
  public abstract int getQuantity();
  
  public abstract JSONObject getSignatureData();
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightReward
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */