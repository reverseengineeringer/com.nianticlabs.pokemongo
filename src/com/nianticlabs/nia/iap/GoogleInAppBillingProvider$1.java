package com.nianticlabs.nia.iap;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.nianticlabs.nia.contextservice.ContextService;
import java.util.Map;

class GoogleInAppBillingProvider$1
  implements ServiceConnection
{
  GoogleInAppBillingProvider$1(GoogleInAppBillingProvider paramGoogleInAppBillingProvider) {}
  
  public void onServiceConnected(ComponentName paramComponentName, final IBinder paramIBinder)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        if (GoogleInAppBillingProvider.access$1000(this$0) == null)
        {
          GoogleInAppBillingProvider.access$800(this$0);
          return;
        }
        GoogleInAppBillingProvider.access$002(this$0, IInAppBillingService.Stub.asInterface(paramIBinder));
        for (;;)
        {
          try
          {
            int i = GoogleInAppBillingProvider.access$000(this$0).isBillingSupported(3, GoogleInAppBillingProvider.access$100(this$0), "inapp");
            GoogleInAppBillingProvider localGoogleInAppBillingProvider = this$0;
            if (i != 0) {
              continue;
            }
            bool = true;
            GoogleInAppBillingProvider.access$1102(localGoogleInAppBillingProvider, bool);
          }
          catch (RemoteException localRemoteException)
          {
            boolean bool;
            GoogleInAppBillingProvider.access$1102(this$0, false);
            continue;
            GoogleInAppBillingProvider.access$800(this$0);
          }
          if (GoogleInAppBillingProvider.access$200(this$0).size() <= 0) {
            continue;
          }
          new GoogleInAppBillingProvider.ProcessPurchasedItemsTask(this$0).execute(new Void[0]);
          return;
          bool = false;
        }
      }
    });
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ContextService.runOnServiceHandler(new Runnable()
    {
      public void run()
      {
        GoogleInAppBillingProvider.access$002(this$0, null);
        GoogleInAppBillingProvider.access$800(this$0);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */