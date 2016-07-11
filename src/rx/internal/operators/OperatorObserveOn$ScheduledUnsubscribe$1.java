package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.functions.Action0;

class OperatorObserveOn$ScheduledUnsubscribe$1
  implements Action0
{
  OperatorObserveOn$ScheduledUnsubscribe$1(OperatorObserveOn.ScheduledUnsubscribe paramScheduledUnsubscribe) {}
  
  public void call()
  {
    this$0.worker.unsubscribe();
    this$0.unsubscribed = true;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ScheduledUnsubscribe.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */