package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;

class Scheduler$Worker$1
  implements Action0
{
  long count = 0L;
  
  Scheduler$Worker$1(Scheduler.Worker paramWorker, MultipleAssignmentSubscription paramMultipleAssignmentSubscription, Action0 paramAction0, long paramLong1, long paramLong2) {}
  
  public void call()
  {
    if (!val$mas.isUnsubscribed())
    {
      val$action.call();
      long l1 = val$startInNanos;
      long l2 = count + 1L;
      count = l2;
      long l3 = val$periodInNanos;
      val$mas.set(this$0.schedule(this, l1 + l2 * l3 - TimeUnit.MILLISECONDS.toNanos(this$0.now()), TimeUnit.NANOSECONDS));
    }
  }
}

/* Location:
 * Qualified Name:     rx.Scheduler.Worker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */