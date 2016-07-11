package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public final class OperatorElementAt<T>
  implements Observable.Operator<T, T>
{
  private final T defaultValue;
  private final boolean hasDefault;
  private final int index;
  
  public OperatorElementAt(int paramInt)
  {
    this(paramInt, null, false);
  }
  
  public OperatorElementAt(int paramInt, T paramT)
  {
    this(paramInt, paramT, true);
  }
  
  private OperatorElementAt(int paramInt, T paramT, boolean paramBoolean)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException(paramInt + " is out of bounds");
    }
    index = paramInt;
    defaultValue = paramT;
    hasDefault = paramBoolean;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    Subscriber local1 = new Subscriber()
    {
      private int currentIndex = 0;
      
      public void onCompleted()
      {
        if (currentIndex <= index)
        {
          if (hasDefault)
          {
            paramSubscriber.onNext(defaultValue);
            paramSubscriber.onCompleted();
          }
        }
        else {
          return;
        }
        paramSubscriber.onError(new IndexOutOfBoundsException(index + " is out of bounds"));
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        int i = currentIndex;
        currentIndex = (i + 1);
        if (i == index)
        {
          paramSubscriber.onNext(paramAnonymousT);
          paramSubscriber.onCompleted();
          unsubscribe();
        }
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        paramSubscriber.setProducer(new OperatorElementAt.InnerProducer(paramAnonymousProducer));
      }
    };
    paramSubscriber.add(local1);
    return local1;
  }
  
  static class InnerProducer
    extends AtomicBoolean
    implements Producer
  {
    private static final long serialVersionUID = 1L;
    final Producer actual;
    
    public InnerProducer(Producer paramProducer)
    {
      actual = paramProducer;
    }
    
    public void request(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("n >= 0 required");
      }
      if ((paramLong > 0L) && (compareAndSet(false, true))) {
        actual.request(Long.MAX_VALUE);
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorElementAt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */