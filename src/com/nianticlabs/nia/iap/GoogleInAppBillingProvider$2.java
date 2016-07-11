package com.nianticlabs.nia.iap;

import android.content.Context;
import android.content.Intent;

class GoogleInAppBillingProvider$2
  implements Runnable
{
  GoogleInAppBillingProvider$2(GoogleInAppBillingProvider paramGoogleInAppBillingProvider) {}
  
  public void run()
  {
    Intent localIntent = new Intent(GoogleInAppBillingProvider.access$1200(this$0), PurchaseActivity.class);
    GoogleInAppBillingProvider.access$1200(this$0).startActivity(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */