package rx.internal.operators;

import rx.Subscriber;

class OperatorSerialize$1
  extends Subscriber<T>
{
  OperatorSerialize$1(OperatorSerialize paramOperatorSerialize, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
  
  public void onNext(T paramT)
  {
    val$s.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSerialize.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */