package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorSubscribeOn$1$1
  implements Action0
{
  OperatorSubscribeOn$1$1(OperatorSubscribeOn.1 param1, Observable paramObservable) {}
  
  public void call()
  {
    final Thread localThread = Thread.currentThread();
    val$o.unsafeSubscribe(new Subscriber(this$1.val$subscriber)
    {
      public void onCompleted()
      {
        this$1.val$subscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        this$1.val$subscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        this$1.val$subscriber.onNext(paramAnonymousT);
      }
      
      public void setProducer(final Producer paramAnonymousProducer)
      {
        this$1.val$subscriber.setProducer(new Producer()
        {
          public void request(final long paramAnonymous2Long)
          {
            if (Thread.currentThread() == val$t)
            {
              paramAnonymousProducer.request(paramAnonymous2Long);
              return;
            }
            this$1.val$inner.schedule(new Action0()
            {
              public void call()
              {
                val$producer.request(paramAnonymous2Long);
              }
            });
          }
        });
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */