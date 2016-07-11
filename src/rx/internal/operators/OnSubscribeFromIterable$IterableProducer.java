package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Producer;
import rx.Subscriber;

final class OnSubscribeFromIterable$IterableProducer<T>
  implements Producer
{
  private static final AtomicLongFieldUpdater<IterableProducer> REQUESTED_UPDATER = AtomicLongFieldUpdater.newUpdater(IterableProducer.class, "requested");
  private final Iterator<? extends T> it;
  private final Subscriber<? super T> o;
  private volatile long requested = 0L;
  
  private OnSubscribeFromIterable$IterableProducer(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator)
  {
    o = paramSubscriber;
    it = paramIterator;
  }
  
  public void request(long paramLong)
  {
    if (requested == Long.MAX_VALUE) {}
    label75:
    label93:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramLong != Long.MAX_VALUE) || (!REQUESTED_UPDATER.compareAndSet(this, 0L, Long.MAX_VALUE))) {
            break label93;
          }
          while (!o.isUnsubscribed())
          {
            if (!it.hasNext()) {
              break label75;
            }
            o.onNext(it.next());
          }
        }
      } while (o.isUnsubscribed());
      o.onCompleted();
      return;
    } while ((paramLong <= 0L) || (BackpressureUtils.getAndAddRequest(REQUESTED_UPDATER, this, paramLong) != 0L));
    long l;
    label170:
    label188:
    do
    {
      l = requested;
      paramLong = l;
      while (!o.isUnsubscribed())
      {
        if (!it.hasNext()) {
          break label170;
        }
        paramLong -= 1L;
        if (paramLong < 0L) {
          break label188;
        }
        o.onNext(it.next());
      }
      break;
      if (o.isUnsubscribed()) {
        break;
      }
      o.onCompleted();
      return;
    } while (REQUESTED_UPDATER.addAndGet(this, -l) != 0L);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeFromIterable.IterableProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */