package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;
import rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback;

final class OperatorOnBackpressureBuffer$BufferSubscriber<T>
  extends Subscriber<T>
  implements BackpressureDrainManager.BackpressureQueueCallback
{
  private final Long baseCapacity;
  private final AtomicLong capacity;
  private final Subscriber<? super T> child;
  private final BackpressureDrainManager manager;
  private final NotificationLite<T> on = NotificationLite.instance();
  private final Action0 onOverflow;
  private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue();
  private final AtomicBoolean saturated = new AtomicBoolean(false);
  
  public OperatorOnBackpressureBuffer$BufferSubscriber(Subscriber<? super T> paramSubscriber, Long paramLong, Action0 paramAction0)
  {
    child = paramSubscriber;
    baseCapacity = paramLong;
    if (paramLong != null) {}
    for (paramSubscriber = new AtomicLong(paramLong.longValue());; paramSubscriber = null)
    {
      capacity = paramSubscriber;
      onOverflow = paramAction0;
      manager = new BackpressureDrainManager(this);
      return;
    }
  }
  
  private boolean assertCapacity()
  {
    if (capacity == null) {
      return true;
    }
    long l;
    do
    {
      l = capacity.get();
      if (l <= 0L)
      {
        if (saturated.compareAndSet(false, true))
        {
          unsubscribe();
          child.onError(new MissingBackpressureException("Overflowed buffer of " + baseCapacity));
          if (onOverflow != null) {
            onOverflow.call();
          }
        }
        return false;
      }
    } while (!capacity.compareAndSet(l, l - 1L));
    return true;
  }
  
  public boolean accept(Object paramObject)
  {
    return on.accept(child, paramObject);
  }
  
  public void complete(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      child.onError(paramThrowable);
      return;
    }
    child.onCompleted();
  }
  
  protected Producer manager()
  {
    return manager;
  }
  
  public void onCompleted()
  {
    if (!saturated.get()) {
      manager.terminateAndDrain();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!saturated.get()) {
      manager.terminateAndDrain(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if (!assertCapacity()) {
      return;
    }
    queue.offer(on.next(paramT));
    manager.drain();
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
  
  public Object peek()
  {
    return queue.peek();
  }
  
  public Object poll()
  {
    Object localObject = queue.poll();
    if ((capacity != null) && (localObject != null)) {
      capacity.incrementAndGet();
    }
    return localObject;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBuffer.BufferSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */