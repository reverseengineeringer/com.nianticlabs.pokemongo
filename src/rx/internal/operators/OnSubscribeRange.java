package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeRange
  implements Observable.OnSubscribe<Integer>
{
  private final int end;
  private final int start;
  
  public OnSubscribeRange(int paramInt1, int paramInt2)
  {
    start = paramInt1;
    end = paramInt2;
  }
  
  public void call(Subscriber<? super Integer> paramSubscriber)
  {
    paramSubscriber.setProducer(new RangeProducer(paramSubscriber, start, end, null));
  }
  
  private static final class RangeProducer
    implements Producer
  {
    private static final AtomicLongFieldUpdater<RangeProducer> REQUESTED_UPDATER = AtomicLongFieldUpdater.newUpdater(RangeProducer.class, "requested");
    private final int end;
    private long index;
    private final Subscriber<? super Integer> o;
    private volatile long requested;
    
    private RangeProducer(Subscriber<? super Integer> paramSubscriber, int paramInt1, int paramInt2)
    {
      o = paramSubscriber;
      index = paramInt1;
      end = paramInt2;
    }
    
    public void request(long paramLong)
    {
      if (requested == Long.MAX_VALUE) {}
      label78:
      do
      {
        do
        {
          return;
          if ((paramLong != Long.MAX_VALUE) || (!REQUESTED_UPDATER.compareAndSet(this, 0L, Long.MAX_VALUE))) {
            break;
          }
          for (paramLong = index;; paramLong += 1L)
          {
            if (paramLong > end) {
              break label78;
            }
            if (o.isUnsubscribed()) {
              break;
            }
            o.onNext(Integer.valueOf((int)paramLong));
          }
        } while (o.isUnsubscribed());
        o.onCompleted();
        return;
      } while ((paramLong <= 0L) || (BackpressureUtils.getAndAddRequest(REQUESTED_UPDATER, this, paramLong) != 0L));
      long l1;
      label203:
      do
      {
        long l2 = requested;
        paramLong = index;
        long l3 = end - paramLong + 1L;
        l1 = Math.min(l3, l2);
        if (l3 <= l2) {}
        for (int i = 1;; i = 0)
        {
          l2 = l1 + paramLong;
          for (;;)
          {
            if (paramLong >= l2) {
              break label203;
            }
            if (o.isUnsubscribed()) {
              break;
            }
            o.onNext(Integer.valueOf((int)paramLong));
            paramLong += 1L;
          }
        }
        index = l2;
        if (i != 0)
        {
          o.onCompleted();
          return;
        }
      } while (REQUESTED_UPDATER.addAndGet(this, -l1) != 0L);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */