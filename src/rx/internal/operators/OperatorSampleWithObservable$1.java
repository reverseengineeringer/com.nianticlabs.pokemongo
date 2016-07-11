package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

class OperatorSampleWithObservable$1
  extends Subscriber<U>
{
  OperatorSampleWithObservable$1(OperatorSampleWithObservable paramOperatorSampleWithObservable, Subscriber paramSubscriber, AtomicReference paramAtomicReference, SerializedSubscriber paramSerializedSubscriber)
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
  
  public void onNext(U paramU)
  {
    paramU = val$value.getAndSet(OperatorSampleWithObservable.EMPTY_TOKEN);
    if (paramU != OperatorSampleWithObservable.EMPTY_TOKEN) {
      val$s.onNext(paramU);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSampleWithObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */