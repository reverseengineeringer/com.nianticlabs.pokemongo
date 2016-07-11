package com.nianticlabs.nia.iap;

import android.os.Bundle;
import java.util.ArrayList;

class GoogleInAppBillingProvider$ProcessPurchasedItemsTask$1
  implements Runnable
{
  GoogleInAppBillingProvider$ProcessPurchasedItemsTask$1(GoogleInAppBillingProvider.ProcessPurchasedItemsTask paramProcessPurchasedItemsTask, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList1 = val$result.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
    ArrayList localArrayList2 = val$result.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
    int i = 0;
    while (i < localArrayList1.size())
    {
      GoogleInAppBillingProvider.access$608(this$1.this$0);
      GoogleInAppBillingProvider.access$700(this$1.this$0, -1, 0, (String)localArrayList1.get(i), (String)localArrayList2.get(i));
      i += 1;
    }
    GoogleInAppBillingProvider.access$800(this$1.this$0);
    GoogleInAppBillingProvider.access$900(this$1.this$0);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.ProcessPurchasedItemsTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */