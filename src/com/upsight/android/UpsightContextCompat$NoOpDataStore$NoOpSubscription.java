package com.upsight.android;

import com.upsight.android.persistence.UpsightSubscription;

class UpsightContextCompat$NoOpDataStore$NoOpSubscription
  implements UpsightSubscription
{
  public boolean isSubscribed()
  {
    return false;
  }
  
  public void unsubscribe() {}
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightContextCompat.NoOpDataStore.NoOpSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */