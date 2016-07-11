package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorSubscribeOn$1
  extends Subscriber<Observable<T>>
{
  OperatorSubscribeOn$1(OperatorSubscribeOn paramOperatorSubscribeOn, Subscriber paramSubscriber1, Subscriber paramSubscriber2, Scheduler.Worker paramWorker)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(final Observable<T> paramObservable)
  {
    val$inner.schedule(new Action0()
    {
      public void call()
      {
        final Thread localThread = Thread.currentThread();
        paramObservable.unsafeSubscribe(new Subscriber(val$subscriber)
        {
          public void onCompleted()
          {
            val$subscriber.onCompleted();
          }
          
          public void onError(Throwable paramAnonymous2Throwable)
          {
            val$subscriber.onError(paramAnonymous2Throwable);
          }
          
          public void onNext(T paramAnonymous2T)
          {
            val$subscriber.onNext(paramAnonymous2T);
          }
          
          public void setProducer(final Producer paramAnonymous2Producer)
          {
            val$subscriber.setProducer(new Producer()
            {
              public void request(final long paramAnonymous3Long)
              {
                if (Thread.currentThread() == val$t)
                {
                  paramAnonymous2Producer.request(paramAnonymous3Long);
                  return;
                }
                val$inner.schedule(new Action0()
                {
                  public void call()
                  {
                    val$producer.request(paramAnonymous3Long);
                  }
                });
              }
            });
          }
        });
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */