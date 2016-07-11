package rx.internal.operators;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorUnsubscribeOn$2
  implements Action0
{
  OperatorUnsubscribeOn$2(OperatorUnsubscribeOn paramOperatorUnsubscribeOn, Subscriber paramSubscriber) {}
  
  public void call()
  {
    final Scheduler.Worker localWorker = OperatorUnsubscribeOn.access$000(this$0).createWorker();
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        val$parent.unsubscribe();
        localWorker.unsubscribe();
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */