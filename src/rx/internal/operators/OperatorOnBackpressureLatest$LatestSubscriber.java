package rx.internal.operators;

import rx.Subscriber;

final class OperatorOnBackpressureLatest$LatestSubscriber<T>
  extends Subscriber<T>
{
  private final OperatorOnBackpressureLatest.LatestEmitter<T> producer;
  
  private OperatorOnBackpressureLatest$LatestSubscriber(OperatorOnBackpressureLatest.LatestEmitter<T> paramLatestEmitter)
  {
    producer = paramLatestEmitter;
  }
  
  public void onCompleted()
  {
    producer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    producer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    producer.onNext(paramT);
  }
  
  public void onStart()
  {
    request(0L);
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureLatest.LatestSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */