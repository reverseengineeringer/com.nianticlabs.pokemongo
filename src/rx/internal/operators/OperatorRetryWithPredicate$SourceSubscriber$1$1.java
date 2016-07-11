package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;

class OperatorRetryWithPredicate$SourceSubscriber$1$1
  extends Subscriber<T>
{
  boolean done;
  
  OperatorRetryWithPredicate$SourceSubscriber$1$1(OperatorRetryWithPredicate.SourceSubscriber.1 param1, Action0 paramAction0) {}
  
  public void onCompleted()
  {
    if (!done)
    {
      done = true;
      this$1.this$0.child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!done)
    {
      done = true;
      if ((((Boolean)this$1.this$0.predicate.call(Integer.valueOf(this$1.this$0.attempts), paramThrowable)).booleanValue()) && (!this$1.this$0.inner.isUnsubscribed())) {
        this$1.this$0.inner.schedule(val$_self);
      }
    }
    else
    {
      return;
    }
    this$1.this$0.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!done) {
      this$1.this$0.child.onNext(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */