package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.BackpressureUtils;

public final class QueuedValueProducer<T>
  extends AtomicLong
  implements Producer
{
  static final Object NULL_SENTINEL = new Object();
  private static final long serialVersionUID = 7277121710709137047L;
  final Subscriber<? super T> child;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber) {}
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    child = paramSubscriber;
    queue = paramQueue;
    wip = new AtomicInteger();
  }
  
  private void drain()
  {
    Subscriber localSubscriber;
    Queue localQueue;
    if (wip.getAndIncrement() == 0)
    {
      localSubscriber = child;
      localQueue = queue;
    }
    label46:
    label143:
    do
    {
      if (localSubscriber.isUnsubscribed()) {}
      long l1;
      Object localObject;
      for (;;)
      {
        return;
        wip.lazySet(1);
        long l2 = get();
        l1 = 0L;
        if (l2 == 0L) {
          break label143;
        }
        localObject = localQueue.poll();
        if (localObject == null) {
          break label143;
        }
        try
        {
          if (localObject == NULL_SENTINEL) {
            localSubscriber.onNext(null);
          }
          while (!localSubscriber.isUnsubscribed())
          {
            l2 -= 1L;
            l1 += 1L;
            break label46;
            localSubscriber.onNext(localObject);
          }
          localSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, localObject));
        }
        catch (Throwable localThrowable)
        {
          Exceptions.throwIfFatal(localThrowable);
          if (localObject == NULL_SENTINEL) {}
        }
      }
      for (;;)
      {
        return;
        localObject = null;
      }
      if ((l1 != 0L) && (get() != Long.MAX_VALUE)) {
        addAndGet(-l1);
      }
    } while (wip.decrementAndGet() != 0);
  }
  
  public boolean offer(T paramT)
  {
    if (paramT == null)
    {
      if (queue.offer(NULL_SENTINEL)) {}
    }
    else {
      while (!queue.offer(paramT)) {
        return false;
      }
    }
    drain();
    return true;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if (paramLong > 0L)
    {
      BackpressureUtils.getAndAddRequest(this, paramLong);
      drain();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.producers.QueuedValueProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */