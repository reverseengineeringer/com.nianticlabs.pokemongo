package rx.internal.operators;

import rx.Subscriber;

class OperatorIgnoreElements$1
  extends Subscriber<T>
{
  OperatorIgnoreElements$1(OperatorIgnoreElements paramOperatorIgnoreElements, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorIgnoreElements.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */