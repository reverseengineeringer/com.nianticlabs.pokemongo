package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observer;

final class BufferUntilSubscriber$State<T>
{
  static final AtomicReferenceFieldUpdater<State, Observer> OBSERVER_UPDATER = AtomicReferenceFieldUpdater.newUpdater(State.class, Observer.class, "observerRef");
  final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue();
  boolean emitting = false;
  Object guard = new Object();
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile Observer<? super T> observerRef = null;
  
  boolean casObserverRef(Observer<? super T> paramObserver1, Observer<? super T> paramObserver2)
  {
    return OBSERVER_UPDATER.compareAndSet(this, paramObserver1, paramObserver2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */