package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorNext
{
  private BlockingOperatorNext()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> next(Observable<? extends T> paramObservable)
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        BlockingOperatorNext.NextObserver localNextObserver = new BlockingOperatorNext.NextObserver(null);
        return new BlockingOperatorNext.NextIterator(val$items, localNextObserver, null);
      }
    };
  }
  
  static final class NextIterator<T>
    implements Iterator<T>
  {
    private Throwable error = null;
    private boolean hasNext = true;
    private boolean isNextConsumed = true;
    private final Observable<? extends T> items;
    private T next;
    private final BlockingOperatorNext.NextObserver<T> observer;
    private boolean started = false;
    
    private NextIterator(Observable<? extends T> paramObservable, BlockingOperatorNext.NextObserver<T> paramNextObserver)
    {
      items = paramObservable;
      observer = paramNextObserver;
    }
    
    private boolean moveToNext()
    {
      try
      {
        if (!started)
        {
          started = true;
          observer.setWaiting(1);
          items.materialize().subscribe(observer);
        }
        Notification localNotification = observer.takeNext();
        if (localNotification.isOnNext())
        {
          isNextConsumed = false;
          next = localNotification.getValue();
          return true;
        }
        hasNext = false;
        if (localNotification.isOnCompleted()) {
          return false;
        }
        if (localNotification.isOnError())
        {
          error = localNotification.getThrowable();
          throw Exceptions.propagate(error);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        observer.unsubscribe();
        Thread.currentThread().interrupt();
        error = localInterruptedException;
        throw Exceptions.propagate(error);
      }
      throw new IllegalStateException("Should not reach here");
    }
    
    public boolean hasNext()
    {
      if (error != null) {
        throw Exceptions.propagate(error);
      }
      if (!hasNext) {
        return false;
      }
      if (!isNextConsumed) {
        return true;
      }
      return moveToNext();
    }
    
    public T next()
    {
      if (error != null) {
        throw Exceptions.propagate(error);
      }
      if (hasNext())
      {
        isNextConsumed = true;
        return (T)next;
      }
      throw new NoSuchElementException("No more elements");
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read only iterator");
    }
  }
  
  private static class NextObserver<T>
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
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */