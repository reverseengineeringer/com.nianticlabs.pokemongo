package rx.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

final class CachedThreadScheduler$EventLoopWorker
  extends Scheduler.Worker
{
  static final AtomicIntegerFieldUpdater<EventLoopWorker> ONCE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(EventLoopWorker.class, "once");
  private final CompositeSubscription innerSubscription = new CompositeSubscription();
  volatile int once;
  private final CachedThreadScheduler.ThreadWorker threadWorker;
  
  CachedThreadScheduler$EventLoopWorker(CachedThreadScheduler.ThreadWorker paramThreadWorker)
  {
    threadWorker = paramThreadWorker;
  }
  
  public boolean isUnsubscribed()
  {
    return innerSubscription.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    return schedule(paramAction0, 0L, null);
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (innerSubscription.isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    paramAction0 = threadWorker.scheduleActual(paramAction0, paramLong, paramTimeUnit);
    innerSubscription.add(paramAction0);
    paramAction0.addParent(innerSubscription);
    return paramAction0;
  }
  
  public void unsubscribe()
  {
    if (ONCE_UPDATER.compareAndSet(this, 0, 1)) {
      CachedThreadScheduler.CachedWorkerPool.access$200().release(threadWorker);
    }
    innerSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.EventLoopWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */