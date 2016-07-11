package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.functions.Func2;

class OperatorMapPair$2
  extends Subscriber<T>
{
  OperatorMapPair$2(OperatorMapPair paramOperatorMapPair, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
  
  public void onNext(final T paramT)
  {
    try
    {
      val$o.onNext(((Observable)this$0.collectionSelector.call(paramT)).map(new Func1()
      {
        public R call(U paramAnonymousU)
        {
          return (R)this$0.resultSelector.call(paramT, paramAnonymousU);
        }
      }));
      return;
    }
    catch (Throwable localThrowable)
    {
      val$o.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, paramT));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMapPair.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */