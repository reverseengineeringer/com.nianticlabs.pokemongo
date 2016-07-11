package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorUnsubscribeOn$2$1
  implements Action0
{
  OperatorUnsubscribeOn$2$1(OperatorUnsubscribeOn.2 param2, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    this$1.val$parent.unsubscribe();
    val$inner.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */