package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorWithLatestFrom$2
  extends Subscriber<U>
{
  OperatorWithLatestFrom$2(OperatorWithLatestFrom paramOperatorWithLatestFrom, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber) {}
  
  public void onCompleted()
  {
    if (val$current.get() == OperatorWithLatestFrom.EMPTY)
    {
      val$s.onCompleted();
      val$s.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$s.onError(paramThrowable);
    val$s.unsubscribe();
  }
  
  public void onNext(U paramU)
  {
    val$current.set(paramU);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWithLatestFrom.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */