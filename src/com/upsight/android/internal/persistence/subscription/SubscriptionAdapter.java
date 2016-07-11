package com.upsight.android.internal.persistence.subscription;

import com.upsight.android.persistence.UpsightSubscription;
import rx.Subscription;

class SubscriptionAdapter
  implements UpsightSubscription
{
  private final Subscription mRxSubscription;
  
  SubscriptionAdapter(Subscription paramSubscription)
  {
    mRxSubscription = paramSubscription;
  }
  
  public boolean isSubscribed()
  {
    return !mRxSubscription.isUnsubscribed();
  }
  
  public void unsubscribe()
  {
    mRxSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.SubscriptionAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */