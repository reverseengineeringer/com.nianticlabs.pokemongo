package com.nianticlabs.nia.iap;

import java.util.Collection;

public abstract interface InAppBillingProvider$Delegate
{
  public abstract void ProcessReceipt(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void onConnectionStateChanged(boolean paramBoolean);
  
  public abstract void purchasableItemsResult(Collection<PurchasableItemDetails> paramCollection);
  
  public abstract void purchaseResult(PurchaseResult paramPurchaseResult);
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.InAppBillingProvider.Delegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */