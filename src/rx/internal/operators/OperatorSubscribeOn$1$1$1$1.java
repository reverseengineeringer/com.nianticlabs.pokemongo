package rx.internal.operators;

import rx.Producer;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class OperatorSubscribeOn$1$1$1$1
  implements Producer
{
  OperatorSubscribeOn$1$1$1$1(OperatorSubscribeOn.1.1.1 param1, Producer paramProducer) {}
  
  public void request(final long paramLong)
  {
    if (Thread.currentThread() == this$3.val$t)
    {
      val$producer.request(paramLong);
      return;
    }
    this$3.this$2.this$1.val$inner.schedule(new Action0()
    {
      public void call()
      {
        val$producer.request(paramLong);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1.1.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */