package com.nianticlabs.nia.iap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class GoogleInAppBillingProvider$GetSkuDetailsTask
  extends AsyncTask<Void, Void, Bundle>
{
  private final IInAppBillingService billingService;
  private final Bundle requestBundle;
  
  public GoogleInAppBillingProvider$GetSkuDetailsTask(ArrayList<String> paramArrayList)
  {
    billingService = GoogleInAppBillingProvider.access$000(paramArrayList);
    requestBundle = new Bundle();
    ArrayList localArrayList;
    requestBundle.putStringArrayList("ITEM_ID_LIST", localArrayList);
  }
  
  protected Bundle doInBackground(Void... paramVarArgs)
  {
    if (billingService == null) {
      return null;
    }
    try
    {
      paramVarArgs = billingService.getSkuDetails(3, GoogleInAppBillingProvider.access$100(this$0), "inapp", requestBundle);
      return paramVarArgs;
    }
    catch (RemoteException paramVarArgs) {}
    return null;
  }
  
  protected void onPostExecute(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    GoogleInAppBillingProvider.access$200(this$0).clear();
    if ((paramBundle != null) && (paramBundle.containsKey("DETAILS_LIST")))
    {
      paramBundle = paramBundle.getStringArrayList("DETAILS_LIST").iterator();
      while (paramBundle.hasNext())
      {
        GetSkuDetailsResponseItem localGetSkuDetailsResponseItem = GetSkuDetailsResponseItem.fromJson((String)paramBundle.next());
        if (localGetSkuDetailsResponseItem != null)
        {
          PurchasableItemDetails localPurchasableItemDetails = GetSkuDetailsResponseItem.toPurchasableItemDetails(localGetSkuDetailsResponseItem);
          localArrayList.add(localPurchasableItemDetails);
          GoogleInAppBillingProvider.access$200(this$0).put(localPurchasableItemDetails.getItemId(), localGetSkuDetailsResponseItem);
        }
      }
    }
    GoogleInAppBillingProvider.access$300(this$0, localArrayList);
    new GoogleInAppBillingProvider.ProcessPurchasedItemsTask(this$0).execute(new Void[0]);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.GetSkuDetailsTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */