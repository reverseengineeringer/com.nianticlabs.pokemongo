package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;
import rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback;

public class OperatorOnBackpressureBuffer<T>
  implements Observable.Operator<T, T>
{
  private final Long capacity;
  private final Action0 onOverflow;
  
  private OperatorOnBackpressureBuffer()
  {
    capacity = null;
    onOverflow = null;
  }
  
  public OperatorOnBackpressureBuffer(long paramLong)
  {
    this(paramLong, null);
  }
  
  public OperatorOnBackpressureBuffer(long paramLong, Action0 paramAction0)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("Buffer capacity must be > 0");
    }
    capacity = Long.valueOf(paramLong);
    onOverflow = paramAction0;
  }
  
  public static <T> OperatorOnBackpressureBuffer<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    BufferSubscriber localBufferSubscriber = new BufferSubscriber(paramSubscriber, capacity, onOverflow);
    paramSubscriber.add(localBufferSubscriber);
    paramSubscriber.setProducer(localBufferSubscriber.manager());
    return localBufferSubscriber;
  }
  
  private static final class BufferSubscriber<T>
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
    
    public BufferSubscriber(Subscriber<? super T> paramSubscriber, Long paramLong, Action0 paramAction0)
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
  
  private static class Holder
  {
    static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer(null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */