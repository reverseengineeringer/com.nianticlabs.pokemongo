package rx.internal.operators;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Notification;
import rx.Subscriber;

class BlockingOperatorNext$NextObserver<T>
  extends Subscriber<Notification<? extends T>>
{
  static final AtomicIntegerFieldUpdater<NextObserver> WAITING_UPDATER = AtomicIntegerFieldUpdater.newUpdater(NextObserver.class, "waiting");
  private final BlockingQueue<Notification<? extends T>> buf = new ArrayBlockingQueue(1);
  volatile int waiting;
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(Notification<? extends T> paramNotification)
  {
    if ((WAITING_UPDATER.getAndSet(this, 0) == 1) || (!paramNotification.isOnNext())) {
      while (!buf.offer(paramNotification))
      {
        Notification localNotification = (Notification)buf.poll();
        if ((localNotification != null) && (!localNotification.isOnNext())) {
          paramNotification = localNotification;
        }
      }
    }
  }
  
  void setWaiting(int paramInt)
  {
    waiting = paramInt;
  }
  
  public Notification<? extends T> takeNext()
    throws InterruptedException
  {
    setWaiting(1);
    return (Notification)buf.take();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext.NextObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */