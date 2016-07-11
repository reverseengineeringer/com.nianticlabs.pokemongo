package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;

final class OnSubscribeCombineLatest$MultiSourceRequestableSubscriber<T, R>
  extends Subscriber<T>
{
  final AtomicLong emitted = new AtomicLong();
  boolean hasValue = false;
  final int index;
  final OnSubscribeCombineLatest.MultiSourceProducer<T, R> producer;
  
  public OnSubscribeCombineLatest$MultiSourceRequestableSubscriber(int paramInt1, int paramInt2, Subscriber<? super R> paramSubscriber, OnSubscribeCombineLatest.MultiSourceProducer<T, R> paramMultiSourceProducer)
  {
    super(paramSubscriber);
    index = paramInt1;
    producer = paramMultiSourceProducer;
    request(paramInt2);
  }
  
  public void onCompleted()
  {
    producer.onCompleted(index, hasValue);
  }
  
  public void onError(Throwable paramThrowable)
  {
    producer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    hasValue = true;
    emitted.incrementAndGet();
    if (!producer.onNext(index, paramT)) {
      request(1L);
    }
  }
  
  public void requestUpTo(long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = emitted.get();
      l2 = Math.min(l1, paramLong);
    } while (!emitted.compareAndSet(l1, l1 - l2));
    request(l2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest.MultiSourceRequestableSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */