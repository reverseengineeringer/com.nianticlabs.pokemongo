package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

class OperatorMap$1
  extends Subscriber<T>
{
  OperatorMap$1(OperatorMap paramOperatorMap, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
      val$o.onNext(OperatorMap.access$000(this$0).call(paramT));
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */