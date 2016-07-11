package rx.subscriptions;

import rx.Subscription;

final class SerialSubscription$State
{
  final boolean isUnsubscribed;
  final Subscription subscription;
  
  SerialSubscription$State(boolean paramBoolean, Subscription paramSubscription)
  {
    isUnsubscribed = paramBoolean;
    subscription = paramSubscription;
  }
  
  State set(Subscription paramSubscription)
  {
    return new State(isUnsubscribed, paramSubscription);
  }
  
  State unsubscribe()
  {
    return new State(true, subscription);
  }
}

/* Location:
 * Qualified Name:     rx.subscriptions.SerialSubscription.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */