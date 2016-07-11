package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T>
  implements Observable.Operator<T, Observable<T>>
{
  final Func2<Integer, Throwable, Boolean> predicate;
  
  public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    predicate = paramFunc2;
  }
  
  public Subscriber<? super Observable<T>> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = Schedulers.trampoline().createWorker();
    paramSubscriber.add(localWorker);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    return new SourceSubscriber(paramSubscriber, predicate, localWorker, localSerialSubscription);
  }
  
  static final class SourceSubscriber<T>
    extends Subscriber<Observable<T>>
  {
    static final AtomicIntegerFieldUpdater<SourceSubscriber> ATTEMPTS_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SourceSubscriber.class, "attempts");
    volatile int attempts;
    final Subscriber<? super T> child;
    final Scheduler.Worker inner;
    final Func2<Integer, Throwable, Boolean> predicate;
    final SerialSubscription serialSubscription;
    
    public SourceSubscriber(Subscriber<? super T> paramSubscriber, Func2<Integer, Throwable, Boolean> paramFunc2, Scheduler.Worker paramWorker, SerialSubscription paramSerialSubscription)
    {
      child = paramSubscriber;
      predicate = paramFunc2;
      inner = paramWorker;
      serialSubscription = paramSerialSubscription;
    }
    
    public void onCompleted() {}
    
    public void onError(Throwable paramThrowable)
    {
      child.onError(paramThrowable);
    }
    
    public void onNext(final Observable<T> paramObservable)
    {
      inner.schedule(new Action0()
      {
        public void call()
        {
          OperatorRetryWithPredicate.SourceSubscriber.ATTEMPTS_UPDATER.incrementAndGet(OperatorRetryWithPredicate.SourceSubscriber.this);
          Subscriber local1 = new Subscriber()
          {
            boolean done;
            
            public void onCompleted()
            {
              if (!done)
              {
                done = true;
                child.onCompleted();
              }
            }
            
            public void onError(Throwable paramAnonymous2Throwable)
            {
              if (!done)
              {
                done = true;
                if ((((Boolean)predicate.call(Integer.valueOf(attempts), paramAnonymous2Throwable)).booleanValue()) && (!inner.isUnsubscribed())) {
                  inner.schedule(jdField_this);
                }
              }
              else
              {
                return;
              }
              child.onError(paramAnonymous2Throwable);
            }
            
            public void onNext(T paramAnonymous2T)
            {
              if (!done) {
                child.onNext(paramAnonymous2T);
              }
            }
          };
          serialSubscription.set(local1);
          paramObservable.unsafeSubscribe(local1);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */