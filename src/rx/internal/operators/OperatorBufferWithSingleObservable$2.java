package rx.internal.operators;

import rx.Subscriber;

class OperatorBufferWithSingleObservable$2
  extends Subscriber<TClosing>
{
  OperatorBufferWithSingleObservable$2(OperatorBufferWithSingleObservable paramOperatorBufferWithSingleObservable, OperatorBufferWithSingleObservable.BufferingSubscriber paramBufferingSubscriber) {}
  
  public void onCompleted()
  {
    val$bsub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$bsub.onError(paramThrowable);
  }
  
  public void onNext(TClosing paramTClosing)
  {
    val$bsub.emit();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */