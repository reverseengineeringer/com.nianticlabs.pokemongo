package rx.internal.operators;

import rx.Subscriber;

class OperatorBufferWithStartEndObservable$1
  extends Subscriber<TOpening>
{
  OperatorBufferWithStartEndObservable$1(OperatorBufferWithStartEndObservable paramOperatorBufferWithStartEndObservable, OperatorBufferWithStartEndObservable.BufferingSubscriber paramBufferingSubscriber) {}
  
  public void onCompleted()
  {
    val$bsub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$bsub.onError(paramThrowable);
  }
  
  public void onNext(TOpening paramTOpening)
  {
    val$bsub.startBuffer(paramTOpening);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */