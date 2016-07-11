package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSkipUntil$2
  extends Subscriber<T>
{
  OperatorSkipUntil$2(OperatorSkipUntil paramOperatorSkipUntil, Subscriber paramSubscriber, AtomicBoolean paramAtomicBoolean, SerializedSubscriber paramSerializedSubscriber)
  {
    super(paramSubscriber);
  }
  
  public void onCompleted()
  {
    val$s.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$s.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    if (val$gate.get())
    {
      val$s.onNext(paramT);
      return;
    }
    request(1L);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipUntil.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */