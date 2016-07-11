package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Notification;
import rx.Observable;
import rx.exceptions.Exceptions;

final class BlockingOperatorNext$NextIterator<T>
  implements Iterator<T>
{
  private Throwable error = null;
  private boolean hasNext = true;
  private boolean isNextConsumed = true;
  private final Observable<? extends T> items;
  private T next;
  private final BlockingOperatorNext.NextObserver<T> observer;
  private boolean started = false;
  
  private BlockingOperatorNext$NextIterator(Observable<? extends T> paramObservable, BlockingOperatorNext.NextObserver<T> paramNextObserver)
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

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext.NextIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */