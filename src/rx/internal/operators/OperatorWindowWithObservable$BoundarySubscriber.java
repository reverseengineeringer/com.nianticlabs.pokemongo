package rx.internal.operators;

import rx.Subscriber;

final class OperatorWindowWithObservable$BoundarySubscriber<T, U>
  extends Subscriber<U>
{
  final OperatorWindowWithObservable.SourceSubscriber<T> sub;
  
  public OperatorWindowWithObservable$BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservable.SourceSubscriber<T> paramSourceSubscriber)
  {
    sub = paramSourceSubscriber;
  }
  
  public void onCompleted()
  {
    sub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    sub.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    sub.replaceWindow();
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithObservable.BoundarySubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */