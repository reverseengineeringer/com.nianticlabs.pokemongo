package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.subscriptions.SerialSubscription;

class OperatorRetryWithPredicate$SourceSubscriber$1
  implements Action0
{
  OperatorRetryWithPredicate$SourceSubscriber$1(OperatorRetryWithPredicate.SourceSubscriber paramSourceSubscriber, Observable paramObservable) {}
  
  public void call()
  {
    OperatorRetryWithPredicate.SourceSubscriber.ATTEMPTS_UPDATER.incrementAndGet(this$0);
    Subscriber local1 = new Subscriber()
    {
      boolean done;
      
      public void onCompleted()
      {
        if (!done)
        {
          done = true;
          this$0.child.onCompleted();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (!done)
        {
          done = true;
          if ((((Boolean)this$0.predicate.call(Integer.valueOf(this$0.attempts), paramAnonymousThrowable)).booleanValue()) && (!this$0.inner.isUnsubscribed())) {
            this$0.inner.schedule(jdField_this);
          }
        }
        else
        {
          return;
        }
        this$0.child.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (!done) {
          this$0.child.onNext(paramAnonymousT);
        }
      }
    };
    this$0.serialSubscription.set(local1);
    val$o.unsafeSubscribe(local1);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */