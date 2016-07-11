package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

final class OperatorMerge$MergeProducer<T>
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = -1214379189873595503L;
  final OperatorMerge.MergeSubscriber<T> subscriber;
  
  public OperatorMerge$MergeProducer(OperatorMerge.MergeSubscriber<T> paramMergeSubscriber)
  {
    subscriber = paramMergeSubscriber;
  }
  
  public long produced(int paramInt)
  {
    return addAndGet(-paramInt);
  }
  
  public void request(long paramLong)
  {
    if (paramLong > 0L) {
      if (get() != Long.MAX_VALUE) {}
    }
    while (paramLong >= 0L)
    {
      return;
      BackpressureUtils.getAndAddRequest(this, paramLong);
      subscriber.emit();
      return;
    }
    throw new IllegalArgumentException("n >= 0 required");
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMerge.MergeProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */