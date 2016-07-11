package rx.internal.util;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousObservable<T>
  extends Observable<T>
{
  private final T t;
  
  protected ScalarSynchronousObservable(T paramT)
  {
    super(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        paramAnonymousSubscriber.onNext(ScalarSynchronousObservable.this);
        paramAnonymousSubscriber.onCompleted();
      }
    });
    t = paramT;
  }
  
  public static final <T> ScalarSynchronousObservable<T> create(T paramT)
  {
    return new ScalarSynchronousObservable(paramT);
  }
  
  public T get()
  {
    return (T)t;
  }
  
  public <R> Observable<R> scalarFlatMap(final Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    create(new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super R> paramAnonymousSubscriber)
      {
        Observable localObservable = (Observable)paramFunc1.call(t);
        if (localObservable.getClass() == ScalarSynchronousObservable.class)
        {
          paramAnonymousSubscriber.onNext(t);
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        localObservable.unsafeSubscribe(new Subscriber(paramAnonymousSubscriber)
        {
          public void onCompleted()
          {
            paramAnonymousSubscriber.onCompleted();
          }
          
          public void onError(Throwable paramAnonymous2Throwable)
          {
            paramAnonymousSubscriber.onError(paramAnonymous2Throwable);
          }
          
          public void onNext(R paramAnonymous2R)
          {
            paramAnonymousSubscriber.onNext(paramAnonymous2R);
          }
        });
      }
    });
  }
  
  public Observable<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    if ((paramScheduler instanceof EventLoopsScheduler)) {
      return create(new DirectScheduledEmission((EventLoopsScheduler)paramScheduler, t));
    }
    return create(new NormalScheduledEmission(paramScheduler, t));
  }
  
  static final class DirectScheduledEmission<T>
    implements Observable.OnSubscribe<T>
  {
    private final EventLoopsScheduler es;
    private final T value;
    
    DirectScheduledEmission(EventLoopsScheduler paramEventLoopsScheduler, T paramT)
    {
      es = paramEventLoopsScheduler;
      value = paramT;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      paramSubscriber.add(es.scheduleDirect(new ScalarSynchronousObservable.ScalarSynchronousAction(paramSubscriber, value, null)));
    }
  }
  
  static final class NormalScheduledEmission<T>
    implements Observable.OnSubscribe<T>
  {
    private final Scheduler scheduler;
    private final T value;
    
    NormalScheduledEmission(Scheduler paramScheduler, T paramT)
    {
      scheduler = paramScheduler;
      value = paramT;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      Scheduler.Worker localWorker = scheduler.createWorker();
      paramSubscriber.add(localWorker);
      localWorker.schedule(new ScalarSynchronousObservable.ScalarSynchronousAction(paramSubscriber, value, null));
    }
  }
  
  static final class ScalarSynchronousAction<T>
    implements Action0
  {
    private final Subscriber<? super T> subscriber;
    private final T value;
    
    private ScalarSynchronousAction(Subscriber<? super T> paramSubscriber, T paramT)
    {
      subscriber = paramSubscriber;
      value = paramT;
    }
    
    public void call()
    {
      try
      {
        subscriber.onNext(value);
        subscriber.onCompleted();
        return;
      }
      catch (Throwable localThrowable)
      {
        subscriber.onError(localThrowable);
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */