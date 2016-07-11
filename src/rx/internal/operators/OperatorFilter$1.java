package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

class OperatorFilter$1
  extends Subscriber<T>
{
  OperatorFilter$1(OperatorFilter paramOperatorFilter, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      if (((Boolean)OperatorFilter.access$000(this$0).call(paramT)).booleanValue())
      {
        val$child.onNext(paramT);
        return;
      }
      request(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      val$child.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorFilter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */