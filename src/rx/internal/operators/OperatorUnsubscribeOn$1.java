package rx.internal.operators;

import rx.Subscriber;

class OperatorUnsubscribeOn$1
  extends Subscriber<T>
{
  OperatorUnsubscribeOn$1(OperatorUnsubscribeOn paramOperatorUnsubscribeOn, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$subscriber.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */