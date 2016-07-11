package rx.internal.operators;

import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.TimeInterval;

public final class OperatorTimeInterval<T>
  implements Observable.Operator<TimeInterval<T>, T>
{
  private final Scheduler scheduler;
  
  public OperatorTimeInterval(Scheduler paramScheduler)
  {
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super TimeInterval<T>> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private long lastTimestamp = scheduler.now();
      
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
        paramSubscriber.onNext(new TimeInterval(l - lastTimestamp, paramAnonymousT));
        lastTimestamp = l;
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeInterval
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */