package rx.internal.operators;

import rx.Subscriber;

class OperatorWindowWithStartEndObservable$1
  extends Subscriber<U>
{
  OperatorWindowWithStartEndObservable$1(OperatorWindowWithStartEndObservable paramOperatorWindowWithStartEndObservable, OperatorWindowWithStartEndObservable.SourceSubscriber paramSourceSubscriber) {}
  
  public void onCompleted()
  {
    val$sub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$sub.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    val$sub.beginWindow(paramU);
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */