package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OnSubscribeRedo$4
  implements Action0
{
  OnSubscribeRedo$4(OnSubscribeRedo paramOnSubscribeRedo, Observable paramObservable, Subscriber paramSubscriber, AtomicLong paramAtomicLong, Scheduler.Worker paramWorker, Action0 paramAction0, AtomicBoolean paramAtomicBoolean) {}
  
  public void call()
  {
    val$restarts.unsafeSubscribe(new Subscriber(val$child)
    {
      public void onCompleted()
      {
        val$child.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        val$child.onError(paramAnonymousThrowable);
      }
      
      public void onNext(Object paramAnonymousObject)
      {
        if (!val$child.isUnsubscribed())
        {
          if (val$consumerCapacity.get() > 0L) {
            val$worker.schedule(val$subscribeToSource);
          }
        }
        else {
          return;
        }
        val$resumeBoundary.compareAndSet(false, true);
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        paramAnonymousProducer.request(Long.MAX_VALUE);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */