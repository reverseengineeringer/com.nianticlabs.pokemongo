package com.google.android.gms.ads.purchase;

import android.content.Intent;

public abstract interface InAppPurchaseResult
{
  public abstract void finishPurchase();
  
  public abstract String getProductId();
  
  public abstract Intent getPurchaseData();
  
  public abstract int getResultCode();
  
  public abstract boolean isVerified();
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */