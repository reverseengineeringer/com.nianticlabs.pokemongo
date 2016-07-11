package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorOnBackpressureDrop<T>
  implements Observable.Operator<T, T>
{
  private final Action1<? super T> onDrop;
  
  private OperatorOnBackpressureDrop()
  {
    this(null);
  }
  
  public OperatorOnBackpressureDrop(Action1<? super T> paramAction1)
  {
    onDrop = paramAction1;
  }
  
  public static <T> OperatorOnBackpressureDrop<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    final AtomicLong localAtomicLong = new AtomicLong();
    paramSubscriber.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        BackpressureUtils.getAndAddRequest(localAtomicLong, paramAnonymousLong);
      }
    });
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (localAtomicLong.get() > 0L)
        {
          paramSubscriber.onNext(paramAnonymousT);
          localAtomicLong.decrementAndGet();
        }
        while (onDrop == null) {
          return;
        }
        onDrop.call(paramAnonymousT);
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
  }
  
  private static final class Holder
  {
    static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop(null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */