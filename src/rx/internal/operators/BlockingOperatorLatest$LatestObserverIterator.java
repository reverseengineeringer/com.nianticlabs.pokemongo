package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Notification;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class BlockingOperatorLatest$LatestObserverIterator<T>
  extends Subscriber<Notification<? extends T>>
  implements Iterator<T>
{
  static final AtomicReferenceFieldUpdater<LatestObserverIterator, Notification> REFERENCE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(LatestObserverIterator.class, Notification.class, "value");
  Notification<? extends T> iNotif;
  final Semaphore notify = new Semaphore(0);
  volatile Notification<? extends T> value;
  
  public boolean hasNext()
  {
    if ((iNotif != null) && (iNotif.isOnError())) {
      throw Exceptions.propagate(iNotif.getThrowable());
    }
    if (((iNotif == null) || (!iNotif.isOnCompleted())) && (iNotif == null)) {
      try
      {
        notify.acquire();
        iNotif = ((Notification)REFERENCE_UPDATER.getAndSet(this, null));
        if (iNotif.isOnError()) {
          throw Exceptions.propagate(iNotif.getThrowable());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        unsubscribe();
        Thread.currentThread().interrupt();
        iNotif = Notification.createOnError(localInterruptedException);
        throw Exceptions.propagate(localInterruptedException);
      }
    }
    return !iNotif.isOnCompleted();
  }
  
  public T next()
  {
    if ((hasNext()) && (iNotif.isOnNext()))
    {
      Object localObject = iNotif.getValue();
      iNotif = null;
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(Notification<? extends T> paramNotification)
  {
    if (REFERENCE_UPDATER.getAndSet(this, paramNotification) == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        notify.release();
      }
      return;
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read-only iterator.");
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorLatest.LatestObserverIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */