package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorMostRecent
{
  private BlockingOperatorMostRecent()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> mostRecent(final Observable<? extends T> paramObservable, T paramT)
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        BlockingOperatorMostRecent.MostRecentObserver localMostRecentObserver = new BlockingOperatorMostRecent.MostRecentObserver(val$initialValue, null);
        paramObservable.subscribe(localMostRecentObserver);
        return localMostRecentObserver.getIterable();
      }
    };
  }
  
  private static final class MostRecentObserver<T>
    extends Subscriber<T>
  {
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile Object value = nl.next(paramT);
    
    private MostRecentObserver(T paramT) {}
    
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
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */