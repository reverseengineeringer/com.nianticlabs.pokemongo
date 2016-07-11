package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorDelay$1
  extends Subscriber<T>
{
  boolean done;
  
  OperatorDelay$1(OperatorDelay paramOperatorDelay, Subscriber paramSubscriber1, Scheduler.Worker paramWorker, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$worker.schedule(new Action0()
    {
      public void call()
      {
        if (!done)
        {
          done = true;
          val$child.onCompleted();
        }
      }
    }, this$0.delay, this$0.unit);
  }
  
  public void onError(final Throwable paramThrowable)
  {
    val$worker.schedule(new Action0()
    {
      public void call()
      {
        if (!done)
        {
          done = true;
          val$child.onError(paramThrowable);
          val$worker.unsubscribe();
        }
      }
    });
  }
  
  public void onNext(final T paramT)
  {
    val$worker.schedule(new Action0()
    {
      public void call()
      {
        if (!done) {
          val$child.onNext(paramT);
        }
      }
    }, this$0.delay, this$0.unit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDelay.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */