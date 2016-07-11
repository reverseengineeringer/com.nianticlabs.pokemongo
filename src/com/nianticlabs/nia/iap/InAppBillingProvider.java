package com.nianticlabs.nia.iap;

import java.util.ArrayList;
import java.util.Collection;

public abstract interface InAppBillingProvider
{
  public abstract void getPurchasableItems(ArrayList<String> paramArrayList);
  
  public abstract boolean isBillingAvailable();
  
  public abstract boolean isTransactionInProgress();
  
  public abstract void onPause();
  
  public abstract void onProcessedGoogleBillingTransaction(boolean paramBoolean, String paramString);
  
  public abstract void onResume();
  
  public abstract void purchaseItem(String paramString1, String paramString2);
  
  public abstract void setDelegate(Delegate paramDelegate);
  
  public static abstract interface Delegate
  {
    public abstract void ProcessReceipt(String paramString1, String paramString2, String paramString3, int paramInt);
    
    public abstract void onConnectionStateChanged(boolean paramBoolean);
    
    public abstract void purchasableItemsResult(Collection<PurchasableItemDetails> paramCollection);
    
    public abstract void purchaseResult(PurchaseResult paramPurchaseResult);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.InAppBillingProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */