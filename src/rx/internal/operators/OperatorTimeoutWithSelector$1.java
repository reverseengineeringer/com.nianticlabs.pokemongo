package rx.internal.operators;

import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.subscriptions.Subscriptions;

class OperatorTimeoutWithSelector$1
  implements OperatorTimeoutBase.FirstTimeoutStub<T>
{
  OperatorTimeoutWithSelector$1(Func0 paramFunc0) {}
  
  public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, final Long paramLong, Scheduler.Worker paramWorker)
  {
    if (val$firstTimeoutSelector != null) {
      try
      {
        paramWorker = (Observable)val$firstTimeoutSelector.call();
        paramWorker.unsafeSubscribe(new Subscriber()
        {
          public void onCompleted()
          {
            paramTimeoutSubscriber.onTimeout(paramLong.longValue());
          }
          
          public void onError(Throwable paramAnonymousThrowable)
          {
            paramTimeoutSubscriber.onError(paramAnonymousThrowable);
          }
          
          public void onNext(U paramAnonymousU)
          {
            paramTimeoutSubscriber.onTimeout(paramLong.longValue());
          }
        });
      }
      catch (Throwable paramLong)
      {
        Exceptions.throwIfFatal(paramLong);
        paramTimeoutSubscriber.onError(paramLong);
        return Subscriptions.unsubscribed();
      }
    }
    return Subscriptions.unsubscribed();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */