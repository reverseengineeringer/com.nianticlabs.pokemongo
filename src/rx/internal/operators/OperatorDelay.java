package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorDelay<T>
  implements Observable.Operator<T, T>
{
  final long delay;
  final Scheduler scheduler;
  final Observable<? extends T> source;
  final TimeUnit unit;
  
  public OperatorDelay(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    source = paramObservable;
    delay = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    final Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    new Subscriber(paramSubscriber)
    {
      boolean done;
      
      public void onCompleted()
      {
        localWorker.schedule(new Action0()
        {
          public void call()
          {
            if (!done)
            {
              done = true;
              val$child.onCompleted();
            }
          }
        }, delay, unit);
      }
      
      public void onError(final Throwable paramAnonymousThrowable)
      {
        localWorker.schedule(new Action0()
        {
          public void call()
          {
            if (!done)
            {
              done = true;
              val$child.onError(paramAnonymousThrowable);
              val$worker.unsubscribe();
            }
          }
        });
      }
      
      public void onNext(final T paramAnonymousT)
      {
        localWorker.schedule(new Action0()
        {
          public void call()
          {
            if (!done) {
              val$child.onNext(paramAnonymousT);
            }
          }
        }, delay, unit);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDelay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */