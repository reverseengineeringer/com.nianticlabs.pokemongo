package rx.internal.util;

import rx.Subscription;
import rx.functions.Func1;

final class SubscriptionIndexedRingBuffer$1
  implements Func1<Subscription, Boolean>
{
  public Boolean call(Subscription paramSubscription)
  {
    paramSubscription.unsubscribe();
    return Boolean.TRUE;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.SubscriptionIndexedRingBuffer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */