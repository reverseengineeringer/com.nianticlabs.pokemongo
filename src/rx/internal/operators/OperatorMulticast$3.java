package rx.internal.operators;

import rx.Subscriber;

class OperatorMulticast$3
  extends Subscriber<R>
{
  OperatorMulticast$3(OperatorMulticast paramOperatorMulticast, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$s.onError(paramThrowable);
  }
  
  public void onNext(R paramR)
  {
    val$s.onNext(paramR);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMulticast.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */