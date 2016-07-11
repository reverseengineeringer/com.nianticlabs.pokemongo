package rx.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

final class ScheduledAction$Remover
  extends AtomicBoolean
  implements Subscription
{
  private static final long serialVersionUID = 247232374289553518L;
  final CompositeSubscription parent;
  final ScheduledAction s;
  
  public ScheduledAction$Remover(ScheduledAction paramScheduledAction, CompositeSubscription paramCompositeSubscription)
  {
    s = paramScheduledAction;
    parent = paramCompositeSubscription;
  }
  
  public boolean isUnsubscribed()
  {
    return s.isUnsubscribed();
  }
  
  public void unsubscribe()
  {
    if (compareAndSet(false, true)) {
      parent.remove(s);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.schedulers.ScheduledAction.Remover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */