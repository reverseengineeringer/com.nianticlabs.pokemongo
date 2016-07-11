package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

class OperatorFinally$1
  extends Subscriber<T>
{
  OperatorFinally$1(OperatorFinally paramOperatorFinally, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    try
    {
      val$child.onCompleted();
      return;
    }
    finally
    {
      this$0.action.call();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      val$child.onError(paramThrowable);
      return;
    }
    finally
    {
      this$0.action.call();
    }
  }
  
  public void onNext(T paramT)
  {
    val$child.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorFinally.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */