package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.BackpressureUtils;

public final class QueuedProducer<T>
  extends AtomicLong
  implements Producer, Observer<T>
{
  static final Object NULL_SENTINEL = new Object();
  private static final long serialVersionUID = 7277121710709137047L;
  final Subscriber<? super T> child;
  volatile boolean done;
  Throwable error;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber) {}
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    child = paramSubscriber;
    queue = paramQueue;
    wip = new AtomicInteger();
  }
  
  private boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (child.isUnsubscribed()) {
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable = error;
      if (localThrowable != null)
      {
        queue.clear();
        child.onError(localThrowable);
        return true;
      }
      if (paramBoolean2)
      {
        child.onCompleted();
        return true;
      }
    }
    return false;
  }
  
  private void drain()
  {
    Subscriber localSubscriber;
    Queue localQueue;
    if (wip.getAndIncrement() == 0)
    {
      localSubscriber = child;
      localQueue = queue;
      if (!checkTerminated(done, localQueue.isEmpty())) {}
    }
    else
    {
      label40:
      return;
    }
    wip.lazySet(1);
    long l2 = get();
    for (long l1 = 0L;; l1 += 1L)
    {
      boolean bool2;
      Object localObject;
      if (l2 != 0L)
      {
        bool2 = done;
        localObject = localQueue.poll();
        if (localObject != null) {
          break label136;
        }
      }
      label136:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (checkTerminated(bool2, bool1)) {
          break label140;
        }
        if (localObject != null) {
          break label142;
        }
        if ((l1 != 0L) && (get() != Long.MAX_VALUE)) {
          addAndGet(-l1);
        }
        if (wip.decrementAndGet() != 0) {
          break;
        }
        return;
      }
      label140:
      break label40;
      try
      {
        label142:
        if (localObject == NULL_SENTINEL) {
          localSubscriber.onNext(null);
        } else {
          localSubscriber.onNext(localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwIfFatal(localThrowable);
        if (localObject == NULL_SENTINEL) {}
      }
      for (;;)
      {
        localSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, localObject));
        return;
        localObject = null;
      }
      l2 -= 1L;
    }
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
  
  public void onCompleted()
  {
    done = true;
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    error = paramThrowable;
    done = true;
    drain();
  }
  
  public void onNext(T paramT)
  {
    if (!offer(paramT)) {
      onError(new MissingBackpressureException());
    }
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
 * Qualified Name:     rx.internal.producers.QueuedProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */