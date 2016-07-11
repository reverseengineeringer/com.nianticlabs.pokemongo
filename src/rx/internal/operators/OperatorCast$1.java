package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

class OperatorCast$1
  extends Subscriber<T>
{
  OperatorCast$1(OperatorCast paramOperatorCast, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$o.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      val$o.onNext(OperatorCast.access$000(this$0).cast(paramT));
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorCast.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */