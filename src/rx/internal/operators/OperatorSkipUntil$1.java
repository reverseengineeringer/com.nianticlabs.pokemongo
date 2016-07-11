package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSkipUntil$1
  extends Subscriber<U>
{
  OperatorSkipUntil$1(OperatorSkipUntil paramOperatorSkipUntil, AtomicBoolean paramAtomicBoolean, SerializedSubscriber paramSerializedSubscriber) {}
  
  public void onCompleted()
  {
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$s.onError(paramThrowable);
    val$s.unsubscribe();
  }
  
  public void onNext(U paramU)
  {
    val$gate.set(true);
    unsubscribe();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipUntil.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */