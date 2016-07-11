package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

final class OperatorTakeUntilPredicate$ParentSubscriber
  extends Subscriber<T>
{
  private final Subscriber<? super T> child;
  private boolean done = false;
  
  private OperatorTakeUntilPredicate$ParentSubscriber(Subscriber<? super T> paramSubscriber)
  {
    Subscriber localSubscriber;
    child = localSubscriber;
  }
  
  void downstreamRequest(long paramLong)
  {
    request(paramLong);
  }
  
  public void onCompleted()
  {
    if (!done) {
      child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!done) {
      child.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    child.onNext(paramT);
    try
    {
      boolean bool = ((Boolean)OperatorTakeUntilPredicate.access$000(this$0).call(paramT)).booleanValue();
      if (bool)
      {
        done = true;
        child.onCompleted();
        unsubscribe();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      done = true;
      Exceptions.throwIfFatal(localThrowable);
      child.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
      unsubscribe();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate.ParentSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */