package com.nianticlabs.nia.iap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.nianticlabs.nia.contextservice.ContextService;
import java.util.ArrayList;
import java.util.Collection;

class GoogleInAppBillingProvider$ProcessPurchasedItemsTask
  extends AsyncTask<Void, Void, Bundle>
{
  private final IInAppBillingService billingService;
  
  public GoogleInAppBillingProvider$ProcessPurchasedItemsTask(GoogleInAppBillingProvider paramGoogleInAppBillingProvider)
  {
    billingService = GoogleInAppBillingProvider.access$000(paramGoogleInAppBillingProvider);
  }
  
  protected Bundle doInBackground(Void... paramVarArgs)
  {
    Object localObject1 = null;
    paramVarArgs = null;
    Object localObject6 = null;
    for (;;)
    {
      Object localObject4 = localObject1;
      Object localObject5 = paramVarArgs;
      try
      {
        Object localObject8 = billingService.getPurchases(3, GoogleInAppBillingProvider.access$100(this$0), "inapp", (String)localObject6);
        localObject4 = localObject1;
        localObject5 = paramVarArgs;
        int i = GoogleInAppBillingProvider.access$500((Bundle)localObject8);
        localObject4 = localObject1;
        localObject5 = paramVarArgs;
        Object localObject3 = ((Bundle)localObject8).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        localObject4 = localObject1;
        localObject5 = paramVarArgs;
        Object localObject2 = ((Bundle)localObject8).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        Object localObject7;
        if (i == 5)
        {
          localObject6 = localObject1;
          localObject7 = paramVarArgs;
        }
        else
        {
          localObject6 = localObject1;
          localObject7 = paramVarArgs;
          if (i == 0)
          {
            localObject4 = localObject1;
            localObject5 = paramVarArgs;
            localObject6 = localObject1;
            localObject7 = paramVarArgs;
            if (((Bundle)localObject8).containsKey("INAPP_PURCHASE_DATA_LIST"))
            {
              localObject4 = localObject1;
              localObject5 = paramVarArgs;
              localObject6 = localObject1;
              localObject7 = paramVarArgs;
              if (((Bundle)localObject8).containsKey("INAPP_DATA_SIGNATURE_LIST"))
              {
                localObject4 = localObject1;
                localObject5 = paramVarArgs;
                localObject6 = localObject1;
                localObject7 = paramVarArgs;
                if (((ArrayList)localObject3).size() == ((ArrayList)localObject2).size())
                {
                  if (localObject1 == null) {}
                  for (;;)
                  {
                    localObject4 = localObject3;
                    localObject5 = localObject2;
                    localObject8 = ((Bundle)localObject8).getString("INAPP_CONTINUATION_TOKEN");
                    localObject6 = localObject3;
                    localObject7 = localObject2;
                    if (localObject8 == null) {
                      break label315;
                    }
                    localObject1 = localObject3;
                    paramVarArgs = (Void[])localObject2;
                    localObject6 = localObject8;
                    localObject4 = localObject3;
                    localObject5 = localObject2;
                    if (((String)localObject8).length() != 0) {
                      break;
                    }
                    localObject6 = localObject3;
                    localObject7 = localObject2;
                    break label315;
                    localObject4 = localObject1;
                    localObject5 = paramVarArgs;
                    ((ArrayList)localObject1).addAll((Collection)localObject3);
                    localObject4 = localObject1;
                    localObject5 = paramVarArgs;
                    paramVarArgs.addAll((Collection)localObject2);
                    localObject3 = localObject1;
                    localObject2 = paramVarArgs;
                  }
                }
              }
            }
          }
        }
        label315:
        return null;
      }
      catch (RemoteException paramVarArgs)
      {
        localObject6 = localObject4;
        localObject7 = localObject5;
        while (localObject6 != null)
        {
          paramVarArgs = new Bundle();
          paramVarArgs.putStringArrayList("INAPP_PURCHASE_DATA_LIST", (ArrayList)localObject6);
          paramVarArgs.putStringArrayList("INAPP_DATA_SIGNATURE_LIST", (ArrayList)localObject7);
          return paramVarArgs;
        }
      }
    }
  }
  
  protected void onPostExecute(final Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      ContextService.runOnServiceHandler(new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList1 = paramBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
          ArrayList localArrayList2 = paramBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
          int i = 0;
          while (i < localArrayList1.size())
          {
            GoogleInAppBillingProvider.access$608(this$0);
            GoogleInAppBillingProvider.access$700(this$0, -1, 0, (String)localArrayList1.get(i), (String)localArrayList2.get(i));
            i += 1;
          }
          GoogleInAppBillingProvider.access$800(this$0);
          GoogleInAppBillingProvider.access$900(this$0);
        }
      });
      return;
    }
    GoogleInAppBillingProvider.access$800(this$0);
    GoogleInAppBillingProvider.access$900(this$0);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.ProcessPurchasedItemsTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */