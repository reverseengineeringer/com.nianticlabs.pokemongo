package rx.subscriptions;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Subscription;

final class RefCountSubscription$InnerSubscription
  implements Subscription
{
  static final AtomicIntegerFieldUpdater<InnerSubscription> INNER_DONE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(InnerSubscription.class, "innerDone");
  volatile int innerDone;
  final RefCountSubscription parent;
  
  public RefCountSubscription$InnerSubscription(RefCountSubscription paramRefCountSubscription)
  {
    parent = paramRefCountSubscription;
  }
  
  public boolean isUnsubscribed()
  {
    return innerDone != 0;
  }
  
  public void unsubscribe()
  {
    if (INNER_DONE_UPDATER.compareAndSet(this, 0, 1)) {
      parent.unsubscribeAChild();
    }
  }
}

/* Location:
 * Qualified Name:     rx.subscriptions.RefCountSubscription.InnerSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */