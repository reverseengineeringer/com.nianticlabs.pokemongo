package com.nianticlabs.nia.iap;

class NianticBillingManager$4
  implements Runnable
{
  NianticBillingManager$4(NianticBillingManager paramNianticBillingManager, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    NianticBillingManager.access$100(this$0).onProcessedGoogleBillingTransaction(val$success, val$transactionToken);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.NianticBillingManager.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */