package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorDelay$1$2
  implements Action0
{
  OperatorDelay$1$2(OperatorDelay.1 param1, Throwable paramThrowable) {}
  
  public void call()
  {
    if (!this$1.done)
    {
      this$1.done = true;
      this$1.val$child.onError(val$e);
      this$1.val$worker.unsubscribe();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDelay.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */