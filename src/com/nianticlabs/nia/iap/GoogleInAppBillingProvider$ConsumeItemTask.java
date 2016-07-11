package com.nianticlabs.nia.iap;

import android.os.AsyncTask;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;

class GoogleInAppBillingProvider$ConsumeItemTask
  extends AsyncTask<Void, Void, Integer>
{
  private final IInAppBillingService billingService;
  private final String purchaseToken;
  
  public GoogleInAppBillingProvider$ConsumeItemTask(GoogleInAppBillingProvider paramGoogleInAppBillingProvider, String paramString)
  {
    purchaseToken = paramString;
    billingService = GoogleInAppBillingProvider.access$000(paramGoogleInAppBillingProvider);
  }
  
  protected Integer doInBackground(Void... paramVarArgs)
  {
    if (billingService == null) {
      return null;
    }
    try
    {
      int i = billingService.consumePurchase(3, GoogleInAppBillingProvider.access$100(this$0), purchaseToken);
      return Integer.valueOf(i);
    }
    catch (RemoteException paramVarArgs) {}
    return null;
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() != 0))
    {
      GoogleInAppBillingProvider.access$400(this$0, PurchaseResult.FAILURE);
      return;
    }
    GoogleInAppBillingProvider.access$400(this$0, PurchaseResult.SUCCESS);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.ConsumeItemTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */