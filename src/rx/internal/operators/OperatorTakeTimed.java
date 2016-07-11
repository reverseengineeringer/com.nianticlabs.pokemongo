package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeTimed<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OperatorTakeTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    time = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    paramSubscriber = new TakeSubscriber(new SerializedSubscriber(paramSubscriber));
    localWorker.schedule(paramSubscriber, time, unit);
    return paramSubscriber;
  }
  
  static final class TakeSubscriber<T>
    extends Subscriber<T>
    implements Action0
  {
    final Subscriber<? super T> child;
    
    public TakeSubscriber(Subscriber<? super T> paramSubscriber)
    {
      super();
      child = paramSubscriber;
    }
    
    public void call()
    {
      onCompleted();
    }
    
    public void onCompleted()
    {
      child.onCompleted();
      unsubscribe();
    }
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
      unsubscribe();
    }
    
    public void onNext(T paramT)
    {
      child.onNext(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeTimed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */