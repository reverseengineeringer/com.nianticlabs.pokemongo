package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T>
  implements Observable.OnSubscribe<T>
{
  static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1()
  {
    public Observable<?> call(Observable<? extends Notification<?>> paramAnonymousObservable)
    {
      paramAnonymousObservable.map(new Func1()
      {
        public Notification<?> call(Notification<?> paramAnonymous2Notification)
        {
          return Notification.createOnNext(null);
        }
      });
    }
  };
  private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
  private final Scheduler scheduler;
  private final Observable<T> source;
  private final boolean stopOnComplete;
  private final boolean stopOnError;
  
  private OnSubscribeRedo(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, boolean paramBoolean1, boolean paramBoolean2, Scheduler paramScheduler)
  {
    source = paramObservable;
    controlHandlerFunction = paramFunc1;
    stopOnComplete = paramBoolean1;
    stopOnError = paramBoolean2;
    scheduler = paramScheduler;
  }
  
  public static <T> Observable<T> redo(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, false, paramScheduler));
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable)
  {
    return repeat(paramObservable, Schedulers.trampoline());
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, long paramLong)
  {
    return repeat(paramObservable, paramLong, Schedulers.trampoline());
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, long paramLong, Scheduler paramScheduler)
  {
    if (paramLong == 0L) {
      return Observable.empty();
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("count >= 0 expected");
    }
    return repeat(paramObservable, new RedoFinite(paramLong - 1L), paramScheduler);
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Scheduler paramScheduler)
  {
    return repeat(paramObservable, REDO_INFINITE, paramScheduler);
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, true, Schedulers.trampoline()));
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, true, paramScheduler));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable)
  {
    return retry(paramObservable, REDO_INFINITE);
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("count >= 0 expected");
    }
    if (paramLong == 0L) {
      return paramObservable;
    }
    return retry(paramObservable, new RedoFinite(paramLong));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, true, false, Schedulers.trampoline()));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, true, false, paramScheduler));
  }
  
  public void call(final Subscriber<? super T> paramSubscriber)
  {
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    final AtomicLong localAtomicLong = new AtomicLong(0L);
    final Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    final Object localObject = new SerialSubscription();
    paramSubscriber.add((Subscription)localObject);
    final BehaviorSubject localBehaviorSubject = BehaviorSubject.create();
    localBehaviorSubject.subscribe(Subscribers.empty());
    final ProducerArbiter localProducerArbiter = new ProducerArbiter();
    localObject = new Action0()
    {
      public void call()
      {
        if (paramSubscriber.isUnsubscribed()) {
          return;
        }
        Subscriber local1 = new Subscriber()
        {
          boolean done;
          
          private void decrementConsumerCapacity()
          {
            long l;
            do
            {
              l = val$consumerCapacity.get();
            } while ((l != Long.MAX_VALUE) && (!val$consumerCapacity.compareAndSet(l, l - 1L)));
          }
          
          public void onCompleted()
          {
            if (!done)
            {
              done = true;
              unsubscribe();
              val$terminals.onNext(Notification.createOnCompleted());
            }
          }
          
          public void onError(Throwable paramAnonymous2Throwable)
          {
            if (!done)
            {
              done = true;
              unsubscribe();
              val$terminals.onNext(Notification.createOnError(paramAnonymous2Throwable));
            }
          }
          
          public void onNext(T paramAnonymous2T)
          {
            if (!done)
            {
              val$child.onNext(paramAnonymous2T);
              decrementConsumerCapacity();
              val$arbiter.produced(1L);
            }
          }
          
          public void setProducer(Producer paramAnonymous2Producer)
          {
            val$arbiter.setProducer(paramAnonymous2Producer);
          }
        };
        localObject.set(local1);
        source.unsafeSubscribe(local1);
      }
    };
    localWorker.schedule(new Action0()
    {
      public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> paramAnonymousSubscriber)
      {
        new Subscriber(paramAnonymousSubscriber)
        {
          public void onCompleted()
          {
            paramAnonymousSubscriber.onCompleted();
          }
          
          public void onError(Throwable paramAnonymous2Throwable)
          {
            paramAnonymousSubscriber.onError(paramAnonymous2Throwable);
          }
          
          public void onNext(Notification<?> paramAnonymous2Notification)
          {
            if ((paramAnonymous2Notification.isOnCompleted()) && (stopOnComplete))
            {
              paramAnonymousSubscriber.onCompleted();
              return;
            }
            if ((paramAnonymous2Notification.isOnError()) && (stopOnError))
            {
              paramAnonymousSubscriber.onError(paramAnonymous2Notification.getThrowable());
              return;
            }
            paramAnonymousSubscriber.onNext(paramAnonymous2Notification);
          }
          
          public void setProducer(Producer paramAnonymous2Producer)
          {
            paramAnonymous2Producer.request(Long.MAX_VALUE);
          }
        };
      }
    }
    {
      public void call()
      {
        val$restarts.unsafeSubscribe(new Subscriber(paramSubscriber)
        {
          public void onCompleted()
          {
            val$child.onCompleted();
          }
          
          public void onError(Throwable paramAnonymous2Throwable)
          {
            val$child.onError(paramAnonymous2Throwable);
          }
          
          public void onNext(Object paramAnonymous2Object)
          {
            if (!val$child.isUnsubscribed())
            {
              if (val$consumerCapacity.get() > 0L) {
                val$worker.schedule(val$subscribeToSource);
              }
            }
            else {
              return;
            }
            val$resumeBoundary.compareAndSet(false, true);
          }
          
          public void setProducer(Producer paramAnonymous2Producer)
          {
            paramAnonymous2Producer.request(Long.MAX_VALUE);
          }
        });
      }
    });
    paramSubscriber.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        if (paramAnonymousLong > 0L)
        {
          BackpressureUtils.getAndAddRequest(localAtomicLong, paramAnonymousLong);
          localProducerArbiter.request(paramAnonymousLong);
          if (localAtomicBoolean.compareAndSet(true, false)) {
            localWorker.schedule(localObject);
          }
        }
      }
    });
  }
  
  public static final class RedoFinite
    implements Func1<Observable<? extends Notification<?>>, Observable<?>>
  {
    private final long count;
    
    public RedoFinite(long paramLong)
    {
      count = paramLong;
    }
    
    public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
    {
      paramObservable.map(new Func1()
      {
        int num = 0;
        
        public Notification<?> call(Notification<?> paramAnonymousNotification)
        {
          if (count == 0L) {}
          do
          {
            return paramAnonymousNotification;
            num += 1;
          } while (num > count);
          return Notification.createOnNext(Integer.valueOf(num));
        }
      }).dematerialize();
    }
  }
  
  public static final class RetryWithPredicate
    implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>>
  {
    private Func2<Integer, Throwable, Boolean> predicate;
    
    public RetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
    {
      predicate = paramFunc2;
    }
    
    public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> paramObservable)
    {
      paramObservable.scan(Notification.createOnNext(Integer.valueOf(0)), new Func2()
      {
        public Notification<Integer> call(Notification<Integer> paramAnonymousNotification, Notification<?> paramAnonymousNotification1)
        {
          int i = ((Integer)paramAnonymousNotification.getValue()).intValue();
          paramAnonymousNotification = paramAnonymousNotification1;
          if (((Boolean)predicate.call(Integer.valueOf(i), paramAnonymousNotification1.getThrowable())).booleanValue()) {
            paramAnonymousNotification = Notification.createOnNext(Integer.valueOf(i + 1));
          }
          return paramAnonymousNotification;
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */