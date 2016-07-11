package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OperatorPublish$InnerProducer<T>
  extends AtomicLong
  implements Producer, Subscription
{
  static final long NOT_REQUESTED = -4611686018427387904L;
  static final long UNSUBSCRIBED = Long.MIN_VALUE;
  private static final long serialVersionUID = -4453897557930727610L;
  final Subscriber<? super T> child;
  final OperatorPublish.PublishSubscriber<T> parent;
  
  public OperatorPublish$InnerProducer(OperatorPublish.PublishSubscriber<T> paramPublishSubscriber, Subscriber<? super T> paramSubscriber)
  {
    parent = paramPublishSubscriber;
    child = paramSubscriber;
    lazySet(-4611686018427387904L);
  }
  
  public boolean isUnsubscribed()
  {
    return get() == Long.MIN_VALUE;
  }
  
  public long produced(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("Cant produce zero or less");
    }
    long l1;
    long l2;
    do
    {
      l1 = get();
      if (l1 == -4611686018427387904L) {
        throw new IllegalStateException("Produced without request");
      }
      if (l1 == Long.MIN_VALUE) {
        return Long.MIN_VALUE;
      }
      l2 = l1 - paramLong;
      if (l2 < 0L) {
        throw new IllegalStateException("More produced (" + paramLong + ") than requested (" + l1 + ")");
      }
    } while (!compareAndSet(l1, l2));
    return l2;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    for (;;)
    {
      long l3 = get();
      if ((l3 == Long.MIN_VALUE) || ((l3 >= 0L) && (paramLong == 0L))) {
        break;
      }
      long l1;
      if (l3 == -4611686018427387904L) {
        l1 = paramLong;
      }
      while (compareAndSet(l3, l1))
      {
        parent.dispatch();
        return;
        long l2 = l3 + paramLong;
        l1 = l2;
        if (l2 < 0L) {
          l1 = Long.MAX_VALUE;
        }
      }
    }
  }
  
  public void unsubscribe()
  {
    if ((get() != Long.MIN_VALUE) && (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE))
    {
      parent.remove(this);
      parent.dispatch();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish.InnerProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */