package rx.internal.operators;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Producer;
import rx.Subscriber;

final class TakeLastQueueProducer<T>
  implements Producer
{
  private static final AtomicLongFieldUpdater<TakeLastQueueProducer> REQUESTED_UPDATER = AtomicLongFieldUpdater.newUpdater(TakeLastQueueProducer.class, "requested");
  private final Deque<Object> deque;
  private volatile boolean emittingStarted = false;
  private final NotificationLite<T> notification;
  private volatile long requested = 0L;
  private final Subscriber<? super T> subscriber;
  
  public TakeLastQueueProducer(NotificationLite<T> paramNotificationLite, Deque<Object> paramDeque, Subscriber<? super T> paramSubscriber)
  {
    notification = paramNotificationLite;
    deque = paramDeque;
    subscriber = paramSubscriber;
  }
  
  void emit(long paramLong)
  {
    if (requested == Long.MAX_VALUE)
    {
      if (paramLong == 0L) {}
      try
      {
        Iterator localIterator = deque.iterator();
        if (localIterator.hasNext())
        {
          localObject3 = localIterator.next();
          bool = subscriber.isUnsubscribed();
          if (!bool) {}
        }
        while (paramLong != 0L)
        {
          Object localObject3;
          boolean bool;
          return;
          notification.accept(subscriber, localObject3);
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        subscriber.onError(localThrowable);
        return;
        return;
      }
      finally
      {
        deque.clear();
      }
    }
    label205:
    long l;
    do
    {
      paramLong = requested;
      int i = 0;
      for (;;)
      {
        paramLong -= 1L;
        if (paramLong < 0L) {
          break label205;
        }
        Object localObject2 = deque.poll();
        if (localObject2 == null) {
          break label205;
        }
        if ((subscriber.isUnsubscribed()) || (notification.accept(subscriber, localObject2))) {
          break;
        }
        i += 1;
      }
      do
      {
        paramLong = requested;
        l = paramLong - i;
        if (paramLong == Long.MAX_VALUE) {
          break;
        }
      } while (!REQUESTED_UPDATER.compareAndSet(this, paramLong, l));
    } while (l != 0L);
  }
  
  public void request(long paramLong)
  {
    if (requested == Long.MAX_VALUE) {}
    for (;;)
    {
      return;
      if (paramLong == Long.MAX_VALUE) {}
      for (paramLong = REQUESTED_UPDATER.getAndSet(this, Long.MAX_VALUE); emittingStarted; paramLong = BackpressureUtils.getAndAddRequest(REQUESTED_UPDATER, this, paramLong))
      {
        emit(paramLong);
        return;
      }
    }
  }
  
  void startEmitting()
  {
    if (!emittingStarted)
    {
      emittingStarted = true;
      emit(0L);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.TakeLastQueueProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */