package rx;

import rx.annotations.Experimental;
import rx.internal.util.SubscriptionList;

@Experimental
public abstract class SingleSubscriber<T>
  implements Subscription
{
  private final SubscriptionList cs = new SubscriptionList();
  
  public final void add(Subscription paramSubscription)
  {
    cs.add(paramSubscription);
  }
  
  public final boolean isUnsubscribed()
  {
    return cs.isUnsubscribed();
  }
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onSuccess(T paramT);
  
  public final void unsubscribe()
  {
    cs.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.SingleSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */