package rx.internal.operators;

import rx.Subscriber;

class OperatorTakeUntil$1
  extends Subscriber<T>
{
  OperatorTakeUntil$1(OperatorTakeUntil paramOperatorTakeUntil, Subscriber paramSubscriber1, boolean paramBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1, paramBoolean);
  }
  
  public void onCompleted()
  {
    try
    {
      val$serial.onCompleted();
      return;
    }
    finally
    {
      val$serial.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      val$serial.onError(paramThrowable);
      return;
    }
    finally
    {
      val$serial.unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    val$serial.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */