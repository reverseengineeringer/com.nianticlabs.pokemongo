package rx.internal.operators;

import rx.Subscriber;

final class OperatorDoOnRequest$ParentSubscriber<T>
  extends Subscriber<T>
{
  private final Subscriber<? super T> child;
  
  private OperatorDoOnRequest$ParentSubscriber(Subscriber<? super T> paramSubscriber)
  {
    child = paramSubscriber;
  }
  
  private void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  public void onCompleted()
  {
    child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    child.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDoOnRequest.ParentSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */