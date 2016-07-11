package com.google.android.gms.ads.purchase;

public abstract interface PlayStorePurchaseListener
{
  public abstract boolean isValidPurchase(String paramString);
  
  public abstract void onInAppPurchaseFinished(InAppPurchaseResult paramInAppPurchaseResult);
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.purchase.PlayStorePurchaseListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */