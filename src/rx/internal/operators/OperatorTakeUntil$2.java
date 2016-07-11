package rx.internal.operators;

import rx.Subscriber;

class OperatorTakeUntil$2
  extends Subscriber<E>
{
  OperatorTakeUntil$2(OperatorTakeUntil paramOperatorTakeUntil, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    val$main.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$main.onError(paramThrowable);
  }
  
  public void onNext(E paramE)
  {
    onCompleted();
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */