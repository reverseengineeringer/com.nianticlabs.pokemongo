package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import rx.Notification;
import rx.Subscription;
import rx.exceptions.Exceptions;

final class BlockingOperatorToIterator$2
  implements Iterator<T>
{
  private Notification<? extends T> buf;
  
  BlockingOperatorToIterator$2(BlockingQueue paramBlockingQueue, Subscription paramSubscription) {}
  
  private Notification<? extends T> take()
  {
    try
    {
      Notification localNotification = (Notification)val$notifications.take();
      return localNotification;
    }
    catch (InterruptedException localInterruptedException)
    {
      val$subscription.unsubscribe();
      throw Exceptions.propagate(localInterruptedException);
    }
  }
  
  public boolean hasNext()
  {
    if (buf == null) {
      buf = take();
    }
    if (buf.isOnError()) {
      throw Exceptions.propagate(buf.getThrowable());
    }
    return !buf.isOnCompleted();
  }
  
  public T next()
  {
    if (hasNext())
    {
      Object localObject = buf.getValue();
      buf = null;
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read-only iterator");
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorToIterator.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */