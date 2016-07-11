package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

class OperatorWithLatestFrom$1
  extends Subscriber<T>
{
  OperatorWithLatestFrom$1(OperatorWithLatestFrom paramOperatorWithLatestFrom, Subscriber paramSubscriber, boolean paramBoolean, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber, paramBoolean);
  }
  
  public void onCompleted()
  {
    val$s.onCompleted();
    val$s.unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$s.onError(paramThrowable);
    val$s.unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    Object localObject = val$current.get();
    if (localObject != OperatorWithLatestFrom.EMPTY) {}
    try
    {
      paramT = this$0.resultSelector.call(paramT, localObject);
      val$s.onNext(paramT);
      return;
    }
    catch (Throwable paramT)
    {
      onError(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWithLatestFrom.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */