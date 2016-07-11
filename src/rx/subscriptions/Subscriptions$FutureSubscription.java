package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;

final class Subscriptions$FutureSubscription
  implements Subscription
{
  final Future<?> f;
  
  public Subscriptions$FutureSubscription(Future<?> paramFuture)
  {
    f = paramFuture;
  }
  
  public boolean isUnsubscribed()
  {
    return f.isCancelled();
  }
  
  public void unsubscribe()
  {
    f.cancel(true);
  }
}

/* Location:
 * Qualified Name:     rx.subscriptions.Subscriptions.FutureSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */