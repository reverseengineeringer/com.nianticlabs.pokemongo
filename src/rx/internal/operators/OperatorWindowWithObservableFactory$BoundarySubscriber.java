package rx.internal.operators;

import rx.Subscriber;

final class OperatorWindowWithObservableFactory$BoundarySubscriber<T, U>
  extends Subscriber<U>
{
  boolean done;
  final OperatorWindowWithObservableFactory.SourceSubscriber<T, U> sub;
  
  public OperatorWindowWithObservableFactory$BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservableFactory.SourceSubscriber<T, U> paramSourceSubscriber)
  {
    sub = paramSourceSubscriber;
  }
  
  public void onCompleted()
  {
    if (!done)
    {
      done = true;
      sub.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    sub.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    if (!done)
    {
      done = true;
      sub.replaceWindow();
    }
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservableFactory.BoundarySubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */