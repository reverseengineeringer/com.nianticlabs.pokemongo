package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public class OperatorTakeLastOne<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorTakeLastOne<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    final ParentSubscriber localParentSubscriber = new ParentSubscriber(paramSubscriber);
    paramSubscriber.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        localParentSubscriber.requestMore(paramAnonymousLong);
      }
    });
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
  
  private static class Holder
  {
    static final OperatorTakeLastOne<Object> INSTANCE = new OperatorTakeLastOne(null);
  }
  
  private static class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private static final Object ABSENT = new Object();
    private static final int NOT_REQUESTED_COMPLETED = 1;
    private static final int NOT_REQUESTED_NOT_COMPLETED = 0;
    private static final int REQUESTED_COMPLETED = 3;
    private static final int REQUESTED_NOT_COMPLETED = 2;
    private final Subscriber<? super T> child;
    private T last = ABSENT;
    private final AtomicInteger state = new AtomicInteger(0);
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber)
    {
      child = paramSubscriber;
    }
    
    private void emit()
    {
      if (isUnsubscribed()) {
        last = null;
      }
      for (;;)
      {
        return;
        Object localObject = last;
        last = null;
        if (localObject != ABSENT) {}
        try
        {
          child.onNext(localObject);
          if (!isUnsubscribed())
          {
            child.onCompleted();
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          child.onError(localThrowable);
        }
      }
    }
    
    public void onCompleted()
    {
      if (last == ABSENT)
      {
        child.onCompleted();
        return;
      }
      do
      {
        int i;
        do
        {
          i = state.get();
          if (i != 0) {
            break;
          }
        } while (!state.compareAndSet(0, 1));
        return;
        if (i != 2) {
          break;
        }
      } while (!state.compareAndSet(2, 3));
      emit();
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      last = paramT;
    }
    
    void requestMore(long paramLong)
    {
      if (paramLong > 0L) {}
      do
      {
        int i;
        do
        {
          i = state.get();
          if (i != 0) {
            break;
          }
        } while (!state.compareAndSet(0, 2));
        while (i != 1) {
          return;
        }
      } while (!state.compareAndSet(1, 3));
      emit();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeLastOne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */