package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorThrottleFirst<T>
  implements Observable.Operator<T, T>
{
  private final Scheduler scheduler;
  private final long timeInMilliseconds;
  
  public OperatorThrottleFirst(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    timeInMilliseconds = paramTimeUnit.toMillis(paramLong);
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private long lastOnNext = 0L;
      
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
        long l = scheduler.now();
        if ((lastOnNext == 0L) || (l - lastOnNext >= timeInMilliseconds))
        {
          lastOnNext = l;
          paramSubscriber.onNext(paramAnonymousT);
        }
      }
      
      public void onStart()
      {
        request(Long.MAX_VALUE);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorThrottleFirst
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */