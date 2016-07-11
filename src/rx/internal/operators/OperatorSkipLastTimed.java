package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

public class OperatorSkipLastTimed<T>
  implements Observable.Operator<T, T>
{
  private final Scheduler scheduler;
  private final long timeInMillis;
  
  public OperatorSkipLastTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    timeInMillis = paramTimeUnit.toMillis(paramLong);
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private Deque<Timestamped<T>> buffer = new ArrayDeque();
      
      private void emitItemsOutOfWindow(long paramAnonymousLong)
      {
        long l = timeInMillis;
        while (!buffer.isEmpty())
        {
          Timestamped localTimestamped = (Timestamped)buffer.getFirst();
          if (localTimestamped.getTimestampMillis() >= paramAnonymousLong - l) {
            break;
          }
          buffer.removeFirst();
          paramSubscriber.onNext(localTimestamped.getValue());
        }
      }
      
      public void onCompleted()
      {
        emitItemsOutOfWindow(scheduler.now());
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        long l = scheduler.now();
        emitItemsOutOfWindow(l);
        buffer.offerLast(new Timestamped(l, paramAnonymousT));
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipLastTimed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */