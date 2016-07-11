package rx.internal.operators;

import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

class OperatorTimeoutWithSelector$2
  implements OperatorTimeoutBase.TimeoutStub<T>
{
  OperatorTimeoutWithSelector$2(Func1 paramFunc1) {}
  
  public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, final Long paramLong, T paramT, Scheduler.Worker paramWorker)
  {
    try
    {
      paramT = (Observable)val$timeoutSelector.call(paramT);
      paramT.unsafeSubscribe(new Subscriber()
      {
        public void onCompleted()
        {
          paramTimeoutSubscriber.onTimeout(paramLong.longValue());
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          paramTimeoutSubscriber.onError(paramAnonymousThrowable);
        }
        
        public void onNext(V paramAnonymousV)
        {
          paramTimeoutSubscriber.onTimeout(paramLong.longValue());
        }
      });
    }
    catch (Throwable paramLong)
    {
      Exceptions.throwIfFatal(paramLong);
      paramTimeoutSubscriber.onError(paramLong);
    }
    return Subscriptions.unsubscribed();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */