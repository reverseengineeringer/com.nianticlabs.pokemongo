package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

final class OperatorObserveOn$ScheduledUnsubscribe
  implements Subscription
{
  static final AtomicIntegerFieldUpdater<ScheduledUnsubscribe> ONCE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ScheduledUnsubscribe.class, "once");
  volatile int once;
  volatile boolean unsubscribed = false;
  final Scheduler.Worker worker;
  
  public OperatorObserveOn$ScheduledUnsubscribe(Scheduler.Worker paramWorker)
  {
    worker = paramWorker;
  }
  
  public boolean isUnsubscribed()
  {
    return unsubscribed;
  }
  
  public void unsubscribe()
  {
    if (ONCE_UPDATER.getAndSet(this, 1) == 0) {
      worker.schedule(new Action0()
      {
        public void call()
        {
          worker.unsubscribe();
          unsubscribed = true;
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ScheduledUnsubscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */