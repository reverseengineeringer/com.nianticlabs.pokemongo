package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithTime<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OperatorSampleWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    time = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = new SerializedSubscriber(paramSubscriber);
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    localObject = new SamplerSubscriber((Subscriber)localObject);
    paramSubscriber.add((Subscription)localObject);
    localWorker.schedulePeriodically((Action0)localObject, time, time, unit);
    return (Subscriber<? super T>)localObject;
  }
  
  static final class SamplerSubscriber<T>
    extends Subscriber<T>
    implements Action0
  {
    private static final Object EMPTY_TOKEN = new Object();
    static final AtomicReferenceFieldUpdater<SamplerSubscriber, Object> VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SamplerSubscriber.class, Object.class, "value");
    private final Subscriber<? super T> subscriber;
    volatile Object value = EMPTY_TOKEN;
    
    public SamplerSubscriber(Subscriber<? super T> paramSubscriber)
    {
      subscriber = paramSubscriber;
    }
    
    public void call()
    {
      Object localObject = VALUE_UPDATER.getAndSet(this, EMPTY_TOKEN);
      if (localObject != EMPTY_TOKEN) {}
      try
      {
        subscriber.onNext(localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        onError(localThrowable);
      }
    }
    
    public void onCompleted()
    {
      subscriber.onCompleted();
      unsubscribe();
    }
    
    public void onError(Throwable paramThrowable)
    {
      subscriber.onError(paramThrowable);
      unsubscribe();
    }
    
    public void onNext(T paramT)
    {
      value = paramT;
    }
    
    public void onStart()
    {
      request(Long.MAX_VALUE);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSampleWithTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */