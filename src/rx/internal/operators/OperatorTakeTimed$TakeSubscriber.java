package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

final class OperatorTakeTimed$TakeSubscriber<T>
  extends Subscriber<T>
  implements Action0
{
  final Subscriber<? super T> child;
  
  public OperatorTakeTimed$TakeSubscriber(Subscriber<? super T> paramSubscriber)
  {
    super(paramSubscriber);
    child = paramSubscriber;
  }
  
  public void call()
  {
    onCompleted();
  }
  
  public void onCompleted()
  {
    child.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    child.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeTimed.TakeSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */