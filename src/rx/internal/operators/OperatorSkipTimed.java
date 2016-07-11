package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorSkipTimed<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OperatorSkipTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    time = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        localAtomicBoolean.set(true);
      }
    }, time, unit);
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        try
        {
          paramSubscriber.onCompleted();
          return;
        }
        finally
        {
          unsubscribe();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        try
        {
          paramSubscriber.onError(paramAnonymousThrowable);
          return;
        }
        finally
        {
          unsubscribe();
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (localAtomicBoolean.get()) {
          paramSubscriber.onNext(paramAnonymousT);
        }
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSkipTimed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */