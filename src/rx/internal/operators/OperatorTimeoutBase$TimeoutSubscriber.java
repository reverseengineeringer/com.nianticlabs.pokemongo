package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

final class OperatorTimeoutBase$TimeoutSubscriber<T>
  extends Subscriber<T>
{
  static final AtomicLongFieldUpdater<TimeoutSubscriber> ACTUAL_UPDATER = AtomicLongFieldUpdater.newUpdater(TimeoutSubscriber.class, "actual");
  static final AtomicIntegerFieldUpdater<TimeoutSubscriber> TERMINATED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(TimeoutSubscriber.class, "terminated");
  volatile long actual;
  private final Object gate = new Object();
  private final Scheduler.Worker inner;
  private final Observable<? extends T> other;
  private final SerialSubscription serial;
  private final SerializedSubscriber<T> serializedSubscriber;
  volatile int terminated;
  private final OperatorTimeoutBase.TimeoutStub<T> timeoutStub;
  
  private OperatorTimeoutBase$TimeoutSubscriber(SerializedSubscriber<T> paramSerializedSubscriber, OperatorTimeoutBase.TimeoutStub<T> paramTimeoutStub, SerialSubscription paramSerialSubscription, Observable<? extends T> paramObservable, Scheduler.Worker paramWorker)
  {
    super(paramSerializedSubscriber);
    serializedSubscriber = paramSerializedSubscriber;
    timeoutStub = paramTimeoutStub;
    serial = paramSerialSubscription;
    other = paramObservable;
    inner = paramWorker;
  }
  
  public void onCompleted()
  {
    int i = 0;
    synchronized (gate)
    {
      if (TERMINATED_UPDATER.getAndSet(this, 1) == 0) {
        i = 1;
      }
      if (i != 0)
      {
        serial.unsubscribe();
        serializedSubscriber.onCompleted();
      }
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    int i = 0;
    synchronized (gate)
    {
      if (TERMINATED_UPDATER.getAndSet(this, 1) == 0) {
        i = 1;
      }
      if (i != 0)
      {
        serial.unsubscribe();
        serializedSubscriber.onError(paramThrowable);
      }
      return;
    }
  }
  
  public void onNext(T paramT)
  {
    int i = 0;
    synchronized (gate)
    {
      if (terminated == 0)
      {
        ACTUAL_UPDATER.incrementAndGet(this);
        i = 1;
      }
      if (i != 0)
      {
        serializedSubscriber.onNext(paramT);
        serial.set((Subscription)timeoutStub.call(this, Long.valueOf(actual), paramT, inner));
      }
      return;
    }
  }
  
  public void onTimeout(long paramLong)
  {
    int j = 0;
    Object localObject1 = gate;
    int i = j;
    try
    {
      if (paramLong == actual)
      {
        i = j;
        if (TERMINATED_UPDATER.getAndSet(this, 1) == 0) {
          i = 1;
        }
      }
      if (i != 0)
      {
        if (other == null) {
          serializedSubscriber.onError(new TimeoutException());
        }
      }
      else {
        return;
      }
    }
    finally {}
    other.unsafeSubscribe(serializedSubscriber);
    serial.set(serializedSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */