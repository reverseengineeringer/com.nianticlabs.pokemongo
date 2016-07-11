package rx.internal.operators;

import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorSubscribeOn$1$1$1
  extends Subscriber<T>
{
  OperatorSubscribeOn$1$1$1(OperatorSubscribeOn.1.1 param1, Subscriber paramSubscriber, Thread paramThread)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    this$2.this$1.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$2.this$1.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this$2.this$1.val$subscriber.onNext(paramT);
  }
  
  public void setProducer(final Producer paramProducer)
  {
    this$2.this$1.val$subscriber.setProducer(new Producer()
    {
      public void request(final long paramAnonymousLong)
      {
        if (Thread.currentThread() == val$t)
        {
          paramProducer.request(paramAnonymousLong);
          return;
        }
        this$2.this$1.val$inner.schedule(new Action0()
        {
          public void call()
          {
            val$producer.request(paramAnonymousLong);
          }
        });
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */