package rx.observables;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;

final class AbstractOnSubscribe$SubscriptionCompleter<T, S>
  extends AtomicBoolean
  implements Subscription
{
  private static final long serialVersionUID = 7993888274897325004L;
  private final AbstractOnSubscribe.SubscriptionState<T, S> state;
  
  private AbstractOnSubscribe$SubscriptionCompleter(AbstractOnSubscribe.SubscriptionState<T, S> paramSubscriptionState)
  {
    state = paramSubscriptionState;
  }
  
  public boolean isUnsubscribed()
  {
    return get();
  }
  
  public void unsubscribe()
  {
    if (compareAndSet(false, true)) {
      state.free();
    }
  }
}

/* Location:
 * Qualified Name:     rx.observables.AbstractOnSubscribe.SubscriptionCompleter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */