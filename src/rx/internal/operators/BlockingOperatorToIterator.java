package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class BlockingOperatorToIterator
{
  private BlockingOperatorToIterator()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterator<T> toIterator(Observable<? extends T> paramObservable)
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    new Iterator()
    {
      public void onCompleted() {}
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        val$notifications.offer(Notification.createOnError(paramAnonymousThrowable));
      }
      
      public void onNext(Notification<? extends T> paramAnonymousNotification)
      {
        val$notifications.offer(paramAnonymousNotification);
      }
    }
    {
      private Notification<? extends T> buf;
      
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
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorToIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */