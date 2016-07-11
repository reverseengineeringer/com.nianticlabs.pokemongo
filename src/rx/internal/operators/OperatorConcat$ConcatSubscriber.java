package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

final class OperatorConcat$ConcatSubscriber<T>
  extends Subscriber<Observable<? extends T>>
{
  private static final AtomicLongFieldUpdater<ConcatSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(ConcatSubscriber.class, "requested");
  static final AtomicIntegerFieldUpdater<ConcatSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(ConcatSubscriber.class, "wip");
  private final ProducerArbiter arbiter;
  private final Subscriber<T> child;
  private final SerialSubscription current;
  volatile OperatorConcat.ConcatInnerSubscriber<T> currentSubscriber;
  final NotificationLite<Observable<? extends T>> nl = NotificationLite.instance();
  final ConcurrentLinkedQueue<Object> queue;
  private volatile long requested;
  volatile int wip;
  
  public OperatorConcat$ConcatSubscriber(Subscriber<T> paramSubscriber, SerialSubscription paramSerialSubscription)
  {
    super(paramSubscriber);
    child = paramSubscriber;
    current = paramSerialSubscription;
    arbiter = new ProducerArbiter();
    queue = new ConcurrentLinkedQueue();
    add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        queue.clear();
      }
    }));
  }
  
  private void decrementRequested()
  {
    REQUESTED.decrementAndGet(this);
  }
  
  private void requestFromChild(long paramLong)
  {
    if (paramLong <= 0L) {}
    long l;
    do
    {
      return;
      l = BackpressureUtils.getAndAddRequest(REQUESTED, this, paramLong);
      arbiter.request(paramLong);
    } while ((l != 0L) || (currentSubscriber != null) || (wip <= 0));
    subscribeNext();
  }
  
  void completeInner()
  {
    currentSubscriber = null;
    if (WIP.decrementAndGet(this) > 0) {
      subscribeNext();
    }
    request(1L);
  }
  
  public void onCompleted()
  {
    queue.add(nl.completed());
    if (WIP.getAndIncrement(this) == 0) {
      subscribeNext();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    queue.add(nl.next(paramObservable));
    if (WIP.getAndIncrement(this) == 0) {
      subscribeNext();
    }
  }
  
  public void onStart()
  {
    request(2L);
  }
  
  void subscribeNext()
  {
    Object localObject;
    if (requested > 0L)
    {
      localObject = queue.poll();
      if (nl.isCompleted(localObject)) {
        child.onCompleted();
      }
    }
    do
    {
      do
      {
        return;
      } while (localObject == null);
      localObject = (Observable)nl.getValue(localObject);
      currentSubscriber = new OperatorConcat.ConcatInnerSubscriber(this, child, arbiter);
      current.set(currentSubscriber);
      ((Observable)localObject).unsafeSubscribe(currentSubscriber);
      return;
      localObject = queue.peek();
    } while (!nl.isCompleted(localObject));
    child.onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorConcat.ConcatSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */