package com.nianticlabs.nia.iap;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.nianticlabs.nia.contextservice.ContextService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoogleInAppBillingProvider
  implements InAppBillingProvider
{
  private static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  private static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
  private static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  private static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
  private static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
  private static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
  private static final int BILLING_RESPONSE_RESULT_NOT_FOUND = 1000;
  private static final int BILLING_RESPONSE_RESULT_OK = 0;
  private static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  private static final int BILLING_SERVICE_VERSION = 3;
  static final boolean ENABLE_VERBOSE_LOGS = false;
  private static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  private static final String ITEM_TYPE_INAPP = "inapp";
  private static final String PACKAGE_NAME_BASE = "com.niantic";
  private static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
  private static final String RESPONSE_CODE = "RESPONSE_CODE";
  private static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  private static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  private static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  private static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
  private static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
  private static final String UNKNOWN_CURRENCY_STRING = "UNKNOWN";
  private static WeakReference<GoogleInAppBillingProvider> instance = null;
  private static final Logger log = new Logger(GoogleInAppBillingProvider.class);
  private IInAppBillingService billingService = null;
  private boolean clientConnected = false;
  private boolean connectionInProgress = false;
  private final Context context;
  private Map<String, GetSkuDetailsResponseItem> currentPurchasableItems;
  private InAppBillingProvider.Delegate delegate;
  private String itemBeingPurchased = null;
  private final String packageName;
  private PendingIntent pendingIntent;
  private boolean purchaseSupported = false;
  private ServiceConnection serviceConnection = null;
  private int transactionsInProgress = 0;
  
  public GoogleInAppBillingProvider(Context paramContext)
  {
    String str = paramContext.getPackageName();
    if (!str.startsWith("com.niantic")) {}
    for (packageName = "ERROR";; packageName = str)
    {
      context = paramContext;
      currentPurchasableItems = new HashMap();
      instance = new WeakReference(this);
      connectToBillingService();
      return;
    }
  }
  
  private void connectToBillingService()
  {
    if (connectionInProgress) {
      return;
    }
    if (billingService != null)
    {
      finalizeConnectionResult();
      return;
    }
    connectionInProgress = true;
    serviceConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, final IBinder paramAnonymousIBinder)
      {
        ContextService.runOnServiceHandler(new Runnable()
        {
          public void run()
          {
            if (serviceConnection == null)
            {
              GoogleInAppBillingProvider.this.finalizeConnectionResult();
              return;
            }
            GoogleInAppBillingProvider.access$002(GoogleInAppBillingProvider.this, IInAppBillingService.Stub.asInterface(paramAnonymousIBinder));
            for (;;)
            {
              try
              {
                int i = billingService.isBillingSupported(3, packageName, "inapp");
                GoogleInAppBillingProvider localGoogleInAppBillingProvider = GoogleInAppBillingProvider.this;
                if (i != 0) {
                  continue;
                }
                bool = true;
                GoogleInAppBillingProvider.access$1102(localGoogleInAppBillingProvider, bool);
              }
              catch (RemoteException localRemoteException)
              {
                boolean bool;
                GoogleInAppBillingProvider.access$1102(GoogleInAppBillingProvider.this, false);
                continue;
                GoogleInAppBillingProvider.this.finalizeConnectionResult();
              }
              if (currentPurchasableItems.size() <= 0) {
                continue;
              }
              new GoogleInAppBillingProvider.ProcessPurchasedItemsTask(GoogleInAppBillingProvider.this).execute(new Void[0]);
              return;
              bool = false;
            }
          }
        });
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        ContextService.runOnServiceHandler(new Runnable()
        {
          public void run()
          {
            GoogleInAppBillingProvider.access$002(GoogleInAppBillingProvider.this, null);
            GoogleInAppBillingProvider.this.finalizeConnectionResult();
          }
        });
      }
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    if (context.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()) {
      finalizeConnectionResult();
    }
    context.bindService(localIntent, serviceConnection, 1);
  }
  
  private void finalizeConnectionResult()
  {
    boolean bool = false;
    connectionInProgress = false;
    if (delegate != null)
    {
      InAppBillingProvider.Delegate localDelegate = delegate;
      if (billingService != null) {
        bool = true;
      }
      localDelegate.onConnectionStateChanged(bool);
    }
  }
  
  private void finalizePurchaseResult(PurchaseResult paramPurchaseResult)
  {
    transactionsInProgress -= 1;
    maybeDisconnectBillingService();
    if (delegate != null) {
      delegate.purchaseResult(paramPurchaseResult);
    }
  }
  
  public static WeakReference<GoogleInAppBillingProvider> getInstance()
  {
    return instance;
  }
  
  private static int getResponseCodeFromBundle(Bundle paramBundle)
  {
    return getResponseCodeFromObject(paramBundle.get("RESPONSE_CODE"));
  }
  
  private static int getResponseCodeFromIntent(Intent paramIntent)
  {
    return getResponseCodeFromObject(paramIntent.getExtras().get("RESPONSE_CODE"));
  }
  
  private static int getResponseCodeFromObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof Long)) {
      return (int)((Long)paramObject).longValue();
    }
    return 6;
  }
  
  private boolean handlePurchaseErrorResult(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    case 2: 
    case 5: 
    case 6: 
    default: 
      finalizePurchaseResult(PurchaseResult.FAILURE);
    }
    for (;;)
    {
      bool = true;
      return bool;
      finalizePurchaseResult(PurchaseResult.USER_CANCELLED);
      continue;
      finalizePurchaseResult(PurchaseResult.BILLING_UNAVAILABLE);
      continue;
      finalizePurchaseResult(PurchaseResult.SKU_NOT_AVAILABLE);
      continue;
      new ProcessPurchasedItemsTask().execute(new Void[0]);
      finalizePurchaseResult(PurchaseResult.FAILURE);
    }
  }
  
  private void launchPurchaseActivity(PendingIntent paramPendingIntent)
  {
    pendingIntent = paramPendingIntent;
    ContextService.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent(context, PurchaseActivity.class);
        context.startActivity(localIntent);
      }
    });
  }
  
  private void maybeDisconnectBillingService()
  {
    if ((transactionsInProgress > 0) || (connectionInProgress) || (clientConnected)) {
      return;
    }
    if (serviceConnection != null) {
      context.unbindService(serviceConnection);
    }
    serviceConnection = null;
    billingService = null;
    transactionsInProgress = 0;
  }
  
  private void notifyPurchasableItemsResult(Collection<PurchasableItemDetails> paramCollection)
  {
    if (delegate != null) {
      delegate.purchasableItemsResult(paramCollection);
    }
  }
  
  private void processPurchaseResult(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject5 = itemBeingPurchased;
    itemBeingPurchased = null;
    if (billingService == null) {}
    while ((paramInt2 != 1000) && (handlePurchaseErrorResult(paramInt2))) {
      return;
    }
    if (paramInt1 == 0)
    {
      finalizePurchaseResult(PurchaseResult.USER_CANCELLED);
      return;
    }
    if (paramInt1 != -1)
    {
      finalizePurchaseResult(PurchaseResult.FAILURE);
      return;
    }
    if ((paramInt2 == 1000) || (paramString1 == null) || (paramString2 == null))
    {
      finalizePurchaseResult(PurchaseResult.FAILURE);
      return;
    }
    Object localObject3 = "UNKNOWN";
    Object localObject4 = null;
    paramInt2 = 0;
    Object localObject2 = localObject3;
    paramInt1 = paramInt2;
    Object localObject1 = localObject4;
    if (localObject5 != null)
    {
      localObject5 = (GetSkuDetailsResponseItem)currentPurchasableItems.get(localObject5);
      localObject2 = localObject3;
      paramInt1 = paramInt2;
      localObject1 = localObject4;
      if (localObject5 != null)
      {
        localObject1 = ((GetSkuDetailsResponseItem)localObject5).getProductId();
        localObject2 = ((GetSkuDetailsResponseItem)localObject5).getCurrencyCode();
        paramInt1 = ((GetSkuDetailsResponseItem)localObject5).getPriceE6();
      }
    }
    if (localObject1 == null)
    {
      localObject3 = GoogleInAppPurchaseData.fromJson(paramString1);
      if (localObject3 != null) {
        localObject1 = ((GoogleInAppPurchaseData)localObject3).getProductId();
      }
      if (localObject1 != null) {}
    }
    delegate.ProcessReceipt(paramString1, paramString2, (String)localObject2, paramInt1);
  }
  
  public void forwardedOnActivityResult(final int paramInt, final Intent paramIntent)
  {
    final int i;
    final String str1;
    if (paramIntent != null)
    {
      i = getResponseCodeFromIntent(paramIntent);
      String str2 = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
      str1 = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
      paramIntent = str2;
    }
    for (;;)
    {
      ContextService.runOnServiceHandler(new Runnable()
      {
        public void run()
        {
          GoogleInAppBillingProvider.this.processPurchaseResult(paramInt, i, paramIntent, str1);
        }
      });
      return;
      i = 1000;
      paramIntent = null;
      str1 = null;
    }
  }
  
  public void getPurchasableItems(ArrayList<String> paramArrayList)
  {
    if (!isBillingAvailable())
    {
      notifyPurchasableItemsResult(Collections.emptyList());
      return;
    }
    new GetSkuDetailsTask(paramArrayList).execute(new Void[0]);
  }
  
  public boolean isBillingAvailable()
  {
    return (billingService != null) && (purchaseSupported);
  }
  
  public boolean isTransactionInProgress()
  {
    return transactionsInProgress > 0;
  }
  
  public void onPause()
  {
    clientConnected = false;
    maybeDisconnectBillingService();
  }
  
  public void onProcessedGoogleBillingTransaction(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      finalizePurchaseResult(PurchaseResult.FAILURE);
      return;
    }
    if (billingService == null)
    {
      finalizePurchaseResult(PurchaseResult.FAILURE);
      return;
    }
    if (paramString == null)
    {
      finalizePurchaseResult(PurchaseResult.FAILURE);
      return;
    }
    new ConsumeItemTask(paramString).execute(new Void[0]);
  }
  
  public void onResume()
  {
    clientConnected = true;
    connectToBillingService();
  }
  
  public void purchaseItem(String paramString1, String paramString2)
  {
    transactionsInProgress += 1;
    if (!isBillingAvailable()) {
      finalizePurchaseResult(PurchaseResult.BILLING_UNAVAILABLE);
    }
    PendingIntent localPendingIntent;
    for (;;)
    {
      return;
      if (!currentPurchasableItems.keySet().contains(paramString1))
      {
        finalizePurchaseResult(PurchaseResult.SKU_NOT_AVAILABLE);
        return;
      }
      try
      {
        paramString2 = billingService.getBuyIntent(3, packageName, paramString1, "inapp", paramString2);
        localPendingIntent = (PendingIntent)paramString2.getParcelable("BUY_INTENT");
        if (!handlePurchaseErrorResult(getResponseCodeFromBundle(paramString2))) {
          if (localPendingIntent == null)
          {
            finalizePurchaseResult(PurchaseResult.FAILURE);
            return;
          }
        }
      }
      catch (RemoteException paramString1)
      {
        finalizePurchaseResult(PurchaseResult.FAILURE);
        return;
      }
    }
    if (transactionsInProgress == 1) {}
    for (itemBeingPurchased = paramString1;; itemBeingPurchased = null)
    {
      launchPurchaseActivity(localPendingIntent);
      return;
    }
  }
  
  public void setDelegate(InAppBillingProvider.Delegate paramDelegate)
  {
    delegate = paramDelegate;
  }
  
  public void startBuyIntent(Activity paramActivity)
  {
    try
    {
      paramActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 10009, new Intent(), 0, 0, 0);
      return;
    }
    catch (IntentSender.SendIntentException paramActivity)
    {
      itemBeingPurchased = null;
      pendingIntent = null;
      finalizePurchaseResult(PurchaseResult.FAILURE);
    }
  }
  
  private class ConsumeItemTask
    extends AsyncTask<Void, Void, Integer>
  {
    private final IInAppBillingService billingService;
    private final String purchaseToken;
    
    public ConsumeItemTask(String paramString)
    {
      purchaseToken = paramString;
      billingService = billingService;
    }
    
    protected Integer doInBackground(Void... paramVarArgs)
    {
      if (billingService == null) {
        return null;
      }
      try
      {
        int i = billingService.consumePurchase(3, packageName, purchaseToken);
        return Integer.valueOf(i);
      }
      catch (RemoteException paramVarArgs) {}
      return null;
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      if ((paramInteger == null) || (paramInteger.intValue() != 0))
      {
        GoogleInAppBillingProvider.this.finalizePurchaseResult(PurchaseResult.FAILURE);
        return;
      }
      GoogleInAppBillingProvider.this.finalizePurchaseResult(PurchaseResult.SUCCESS);
    }
  }
  
  private class GetSkuDetailsTask
    extends AsyncTask<Void, Void, Bundle>
  {
    private final IInAppBillingService billingService = billingService;
    private final Bundle requestBundle = new Bundle();
    
    public GetSkuDetailsTask()
    {
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
        paramVarArgs = billingService.getSkuDetails(3, packageName, "inapp", requestBundle);
        return paramVarArgs;
      }
      catch (RemoteException paramVarArgs) {}
      return null;
    }
    
    protected void onPostExecute(Bundle paramBundle)
    {
      ArrayList localArrayList = new ArrayList();
      currentPurchasableItems.clear();
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
            currentPurchasableItems.put(localPurchasableItemDetails.getItemId(), localGetSkuDetailsResponseItem);
          }
        }
      }
      GoogleInAppBillingProvider.this.notifyPurchasableItemsResult(localArrayList);
      new GoogleInAppBillingProvider.ProcessPurchasedItemsTask(GoogleInAppBillingProvider.this).execute(new Void[0]);
    }
  }
  
  static class Logger
  {
    private final String tag;
    
    public Logger(Class paramClass)
    {
      tag = paramClass.toString();
    }
    
    void assertOnServiceThread(String paramString)
    {
      if (!ContextService.onServiceThread()) {
        severe(tag + ": Must be on the service thread: " + paramString, new Object[0]);
      }
    }
    
    void dev(String paramString, Object... paramVarArgs) {}
    
    void error(String paramString, Object... paramVarArgs) {}
    
    void severe(String paramString, Object... paramVarArgs) {}
    
    void warning(String paramString, Object... paramVarArgs) {}
  }
  
  private class ProcessPurchasedItemsTask
    extends AsyncTask<Void, Void, Bundle>
  {
    private final IInAppBillingService billingService = billingService;
    
    public ProcessPurchasedItemsTask() {}
    
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
          Object localObject8 = billingService.getPurchases(3, packageName, "inapp", (String)localObject6);
          localObject4 = localObject1;
          localObject5 = paramVarArgs;
          int i = GoogleInAppBillingProvider.getResponseCodeFromBundle((Bundle)localObject8);
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
              GoogleInAppBillingProvider.access$608(GoogleInAppBillingProvider.this);
              GoogleInAppBillingProvider.this.processPurchaseResult(-1, 0, (String)localArrayList1.get(i), (String)localArrayList2.get(i));
              i += 1;
            }
            GoogleInAppBillingProvider.this.finalizeConnectionResult();
            GoogleInAppBillingProvider.this.maybeDisconnectBillingService();
          }
        });
        return;
      }
      GoogleInAppBillingProvider.this.finalizeConnectionResult();
      GoogleInAppBillingProvider.this.maybeDisconnectBillingService();
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */