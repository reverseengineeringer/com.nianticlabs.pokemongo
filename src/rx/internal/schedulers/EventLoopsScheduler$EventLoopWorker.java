package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

class EventLoopsScheduler$EventLoopWorker
  extends Scheduler.Worker
{
  private final SubscriptionList both = new SubscriptionList(new Subscription[] { serial, timed });
  private final EventLoopsScheduler.PoolWorker poolWorker;
  private final SubscriptionList serial = new SubscriptionList();
  private final CompositeSubscription timed = new CompositeSubscription();
  
  EventLoopsScheduler$EventLoopWorker(EventLoopsScheduler.PoolWorker paramPoolWorker)
  {
    poolWorker = paramPoolWorker;
  }
  
  public boolean isUnsubscribed()
  {
    return both.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    if (isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    return poolWorker.scheduleActual(paramAction0, 0L, null, serial);
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    return poolWorker.scheduleActual(paramAction0, paramLong, paramTimeUnit, timed);
  }
  
  public void unsubscribe()
  {
    both.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */