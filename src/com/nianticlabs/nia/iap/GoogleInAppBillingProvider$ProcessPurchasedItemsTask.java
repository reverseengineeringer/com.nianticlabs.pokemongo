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
    if (billingService == null) {
      return null;
    }
    Object localObject1 = null;
    paramVarArgs = null;
    localObject6 = null;
    localObject4 = localObject1;
    localObject5 = paramVarArgs;
    label98:
    label129:
    do
    {
      do
      {
        do
        {
          do
          {
            try
            {
              localObject8 = billingService.getPurchases(3, GoogleInAppBillingProvider.access$100(this$0), "inapp", (String)localObject6);
              localObject4 = localObject1;
              localObject5 = paramVarArgs;
              i = GoogleInAppBillingProvider.access$500((Bundle)localObject8);
              localObject4 = localObject1;
              localObject5 = paramVarArgs;
              localObject3 = ((Bundle)localObject8).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
              localObject4 = localObject1;
              localObject5 = paramVarArgs;
              localObject2 = ((Bundle)localObject8).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
              if (i != 5) {
                break label129;
              }
              localObject7 = paramVarArgs;
              localObject6 = localObject1;
            }
            catch (RemoteException paramVarArgs)
            {
              for (;;)
              {
                Object localObject8;
                int i;
                Object localObject3;
                Object localObject2;
                localObject6 = localObject4;
                Object localObject7 = localObject5;
              }
            }
            if (localObject6 == null) {
              break;
            }
            paramVarArgs = new Bundle();
            paramVarArgs.putStringArrayList("INAPP_PURCHASE_DATA_LIST", (ArrayList)localObject6);
            paramVarArgs.putStringArrayList("INAPP_DATA_SIGNATURE_LIST", (ArrayList)localObject7);
            return paramVarArgs;
            localObject6 = localObject1;
            localObject7 = paramVarArgs;
          } while (i != 0);
          localObject6 = localObject1;
          localObject7 = paramVarArgs;
          localObject4 = localObject1;
          localObject5 = paramVarArgs;
        } while (!((Bundle)localObject8).containsKey("INAPP_PURCHASE_DATA_LIST"));
        localObject6 = localObject1;
        localObject7 = paramVarArgs;
        localObject4 = localObject1;
        localObject5 = paramVarArgs;
      } while (!((Bundle)localObject8).containsKey("INAPP_DATA_SIGNATURE_LIST"));
      localObject6 = localObject1;
      localObject7 = paramVarArgs;
      localObject4 = localObject1;
      localObject5 = paramVarArgs;
    } while (((ArrayList)localObject3).size() != ((ArrayList)localObject2).size());
    if (localObject1 == null) {}
    for (;;)
    {
      localObject4 = localObject3;
      localObject5 = localObject2;
      localObject8 = ((Bundle)localObject8).getString("INAPP_CONTINUATION_TOKEN");
      localObject6 = localObject3;
      localObject7 = localObject2;
      if (localObject8 == null) {
        break label98;
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
      break label98;
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