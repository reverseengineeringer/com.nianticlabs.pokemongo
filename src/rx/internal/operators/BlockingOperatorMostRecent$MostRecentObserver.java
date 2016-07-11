package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class BlockingOperatorMostRecent$MostRecentObserver<T>
  extends Subscriber<T>
{
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile Object value = nl.next(paramT);
  
  private BlockingOperatorMostRecent$MostRecentObserver(T paramT) {}
  
  public Iterator<T> getIterable()
  {
    new Iterator()
    {
      private Object buf = null;
      
      public boolean hasNext()
      {
        buf = value;
        return !nl.isCompleted(buf);
      }
      
      public T next()
      {
        try
        {
          if (buf == null) {
            buf = value;
          }
          if (nl.isCompleted(buf)) {
            throw new NoSuchElementException();
          }
        }
        finally
        {
          buf = null;
        }
        if (nl.isError(buf)) {
          throw Exceptions.propagate(nl.getError(buf));
        }
        Object localObject2 = nl.getValue(buf);
        buf = null;
        return (T)localObject2;
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Read only iterator");
      }
    };
  }
  
  public void onCompleted()
  {
    value = nl.completed();
  }
  
  public void onError(Throwable paramThrowable)
  {
    value = nl.error(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    value = nl.next(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */