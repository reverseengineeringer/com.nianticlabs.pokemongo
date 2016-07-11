package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public final class OperatorSingle<T>
  implements Observable.Operator<T, T>
{
  private final T defaultValue;
  private final boolean hasDefaultValue;
  
  private OperatorSingle()
  {
    this(false, null);
  }
  
  public OperatorSingle(T paramT)
  {
    this(true, paramT);
  }
  
  private OperatorSingle(boolean paramBoolean, T paramT)
  {
    hasDefaultValue = paramBoolean;
    defaultValue = paramT;
  }
  
  public static <T> OperatorSingle<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    final ParentSubscriber localParentSubscriber = new ParentSubscriber(paramSubscriber, hasDefaultValue, defaultValue);
    paramSubscriber.setProducer(new Producer()
    {
      private final AtomicBoolean requestedTwo = new AtomicBoolean(false);
      
      public void request(long paramAnonymousLong)
      {
        if ((paramAnonymousLong > 0L) && (requestedTwo.compareAndSet(false, true))) {
          localParentSubscriber.requestMore(2L);
        }
      }
    });
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
  
  private static class Holder
  {
    static final OperatorSingle<?> INSTANCE = new OperatorSingle(null);
  }
  
  private static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private final Subscriber<? super T> child;
    private final T defaultValue;
    private final boolean hasDefaultValue;
    private boolean hasTooManyElements = false;
    private boolean isNonEmpty = false;
    private T value;
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, T paramT)
    {
      child = paramSubscriber;
      hasDefaultValue = paramBoolean;
      defaultValue = paramT;
    }
    
    public void onCompleted()
    {
      if (hasTooManyElements) {
        return;
      }
      if (isNonEmpty)
      {
        child.onNext(value);
        child.onCompleted();
        return;
      }
      if (hasDefaultValue)
      {
        child.onNext(defaultValue);
        child.onCompleted();
        return;
      }
      child.onError(new NoSuchElementException("Sequence contains no elements"));
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (isNonEmpty)
      {
        hasTooManyElements = true;
        child.onError(new IllegalArgumentException("Sequence contains too many elements"));
        unsubscribe();
        return;
      }
      value = paramT;
      isNonEmpty = true;
    }
    
    void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSingle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */