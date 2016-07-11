package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.SynchronizedQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

final class OperatorObserveOn$ObserveOnSubscriber<T>
  extends Subscriber<T>
{
  static final AtomicLongFieldUpdater<ObserveOnSubscriber> COUNTER_UPDATER = AtomicLongFieldUpdater.newUpdater(ObserveOnSubscriber.class, "counter");
  static final AtomicLongFieldUpdater<ObserveOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ObserveOnSubscriber.class, "requested");
  final Action0 action = new Action0()
  {
    public void call()
    {
      pollQueue();
    }
  };
  final Subscriber<? super T> child;
  volatile long counter;
  volatile Throwable error;
  volatile boolean finished = false;
  final NotificationLite<T> on = NotificationLite.instance();
  final Queue<Object> queue;
  final Scheduler.Worker recursiveScheduler;
  volatile long requested = 0L;
  final OperatorObserveOn.ScheduledUnsubscribe scheduledUnsubscribe;
  
  public OperatorObserveOn$ObserveOnSubscriber(Scheduler paramScheduler, Subscriber<? super T> paramSubscriber)
  {
    child = paramSubscriber;
    recursiveScheduler = paramScheduler.createWorker();
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (queue = new SpscArrayQueue(RxRingBuffer.SIZE);; queue = new SynchronizedQueue(RxRingBuffer.SIZE))
    {
      scheduledUnsubscribe = new OperatorObserveOn.ScheduledUnsubscribe(recursiveScheduler);
      return;
    }
  }
  
  void init()
  {
    child.add(scheduledUnsubscribe);
    child.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        BackpressureUtils.getAndAddRequest(OperatorObserveOn.ObserveOnSubscriber.REQUESTED, OperatorObserveOn.ObserveOnSubscriber.this, paramAnonymousLong);
        schedule();
      }
    });
    child.add(recursiveScheduler);
    child.add(this);
  }
  
  public void onCompleted()
  {
    if ((isUnsubscribed()) || (finished)) {
      return;
    }
    finished = true;
    schedule();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if ((isUnsubscribed()) || (finished)) {
      return;
    }
    error = paramThrowable;
    unsubscribe();
    finished = true;
    schedule();
  }
  
  public void onNext(T paramT)
  {
    if (isUnsubscribed()) {
      return;
    }
    if (!queue.offer(on.next(paramT)))
    {
      onError(new MissingBackpressureException());
      return;
    }
    schedule();
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  void pollQueue()
  {
    int i = 0;
    counter = 1L;
    long l1 = 0L;
    long l2 = requested;
    int j = i;
    label17:
    if (child.isUnsubscribed()) {}
    do
    {
      return;
      Object localObject;
      if (finished)
      {
        localObject = error;
        if (localObject != null)
        {
          queue.clear();
          child.onError((Throwable)localObject);
          return;
        }
        if (queue.isEmpty())
        {
          child.onCompleted();
          return;
        }
      }
      if (l2 > 0L)
      {
        localObject = queue.poll();
        if (localObject != null)
        {
          child.onNext(on.getValue(localObject));
          l2 -= 1L;
          j += 1;
          l1 += 1L;
          break label17;
        }
      }
      if ((l1 > 0L) && (requested != Long.MAX_VALUE)) {
        REQUESTED.addAndGet(this, -l1);
      }
      i = j;
      if (COUNTER_UPDATER.decrementAndGet(this) > 0L) {
        break;
      }
    } while (j <= 0);
    request(j);
  }
  
  protected void schedule()
  {
    if (COUNTER_UPDATER.getAndIncrement(this) == 0L) {
      recursiveScheduler.schedule(action);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */