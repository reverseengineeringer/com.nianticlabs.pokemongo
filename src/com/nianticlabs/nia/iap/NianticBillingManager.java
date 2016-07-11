package com.nianticlabs.nia.iap;

import android.content.Context;
import com.nianticlabs.nia.contextservice.ContextService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class NianticBillingManager
  extends ContextService
  implements InAppBillingProvider.Delegate
{
  private InAppBillingProvider inAppBillingProvider;
  private boolean initializing;
  
  public NianticBillingManager(Context paramContext, long paramLong)
  {
    super(paramContext, paramLong);
    inAppBillingProvider = new GoogleInAppBillingProvider(paramContext);
  }
  
  private native void nativeInitializeCallback();
  
  private native void nativeOnConnectionStateChanged(boolean paramBoolean);
  
  private native void nativeProcessReceipt(String paramString1, String paramString2, String paramString3, int paramInt);
  
  private native void nativePurchasableItemsResult(PurchasableItemDetails[] paramArrayOfPurchasableItemDetails);
  
  private native void nativePurchaseResult(int paramInt);
  
  private native void nativeRecordPurchase(boolean paramBoolean, String paramString1, int paramInt, float paramFloat, String paramString2, String paramString3);
  
  public void ProcessReceipt(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    synchronized (callbackLock)
    {
      nativeProcessReceipt(paramString1, paramString2, paramString3, paramInt);
      return;
    }
  }
  
  public void getPurchasableItems(String[] paramArrayOfString)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        inAppBillingProvider.getPurchasableItems(val$items);
      }
    });
  }
  
  public void initialize()
  {
    initializing = true;
    inAppBillingProvider.setDelegate(this);
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        NianticBillingManager.this.nativeInitializeCallback();
      }
    });
  }
  
  public boolean isBillingAvailable()
  {
    return inAppBillingProvider.isBillingAvailable();
  }
  
  public boolean isTransactionInProgress()
  {
    return inAppBillingProvider.isTransactionInProgress();
  }
  
  public void onConnectionStateChanged(final boolean paramBoolean)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        synchronized (callbackLock)
        {
          NianticBillingManager.this.nativeOnConnectionStateChanged(paramBoolean);
          return;
        }
      }
    });
  }
  
  public void onPause()
  {
    inAppBillingProvider.onPause();
  }
  
  public void onResume()
  {
    inAppBillingProvider.onResume();
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void purchasableItemsResult(Collection<PurchasableItemDetails> arg1)
  {
    PurchasableItemDetails[] arrayOfPurchasableItemDetails = new PurchasableItemDetails[???.size()];
    int i = 0;
    ??? = ???.iterator();
    while (???.hasNext())
    {
      arrayOfPurchasableItemDetails[i] = ((PurchasableItemDetails)???.next());
      i += 1;
    }
    synchronized (callbackLock)
    {
      nativePurchasableItemsResult(arrayOfPurchasableItemDetails);
      return;
    }
  }
  
  public void purchaseResult(PurchaseResult paramPurchaseResult)
  {
    synchronized (callbackLock)
    {
      nativePurchaseResult(paramPurchaseResult.ordinal());
      return;
    }
  }
  
  public void purchaseVendorItem(final String paramString1, final String paramString2)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        inAppBillingProvider.purchaseItem(paramString1, paramString2);
      }
    });
  }
  
  public void redeemReceiptResult(final boolean paramBoolean, final String paramString)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        inAppBillingProvider.onProcessedGoogleBillingTransaction(paramBoolean, paramString);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.NianticBillingManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */