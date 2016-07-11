package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSampleWithObservable$2
  extends Subscriber<T>
{
  OperatorSampleWithObservable$2(OperatorSampleWithObservable paramOperatorSampleWithObservable, Subscriber paramSubscriber, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber)
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
    val$value.set(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSampleWithObservable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */