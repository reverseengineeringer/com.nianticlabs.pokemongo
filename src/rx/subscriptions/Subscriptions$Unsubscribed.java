package rx.subscriptions;

import rx.Subscription;

final class Subscriptions$Unsubscribed
  implements Subscription
{
  public boolean isUnsubscribed()
  {
    return true;
  }
  
  public void unsubscribe() {}
}

/* Location:
 * Qualified Name:     rx.subscriptions.Subscriptions.Unsubscribed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */