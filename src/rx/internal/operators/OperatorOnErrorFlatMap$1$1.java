package rx.internal.operators;

import rx.Subscriber;

class OperatorOnErrorFlatMap$1$1
  extends Subscriber<T>
{
  OperatorOnErrorFlatMap$1$1(OperatorOnErrorFlatMap.1 param1) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    this$1.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this$1.val$child.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorFlatMap.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */