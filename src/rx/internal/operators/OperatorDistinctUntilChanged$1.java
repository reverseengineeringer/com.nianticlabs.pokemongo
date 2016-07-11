package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Func1;

class OperatorDistinctUntilChanged$1
  extends Subscriber<T>
{
  boolean hasPrevious;
  U previousKey;
  
  OperatorDistinctUntilChanged$1(OperatorDistinctUntilChanged paramOperatorDistinctUntilChanged, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    Object localObject1 = previousKey;
    Object localObject2 = this$0.keySelector.call(paramT);
    previousKey = localObject2;
    if (hasPrevious)
    {
      if ((localObject1 != localObject2) && ((localObject2 == null) || (!localObject2.equals(localObject1))))
      {
        val$child.onNext(paramT);
        return;
      }
      request(1L);
      return;
    }
    hasPrevious = true;
    val$child.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDistinctUntilChanged.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */