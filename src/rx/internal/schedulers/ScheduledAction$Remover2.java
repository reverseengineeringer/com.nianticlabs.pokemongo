package rx.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.internal.util.SubscriptionList;

final class ScheduledAction$Remover2
  extends AtomicBoolean
  implements Subscription
{
  private static final long serialVersionUID = 247232374289553518L;
  final SubscriptionList parent;
  final ScheduledAction s;
  
  public ScheduledAction$Remover2(ScheduledAction paramScheduledAction, SubscriptionList paramSubscriptionList)
  {
    s = paramScheduledAction;
    parent = paramSubscriptionList;
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
 * Qualified Name:     rx.internal.schedulers.ScheduledAction.Remover2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */