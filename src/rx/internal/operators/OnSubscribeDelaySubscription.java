package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public final class OnSubscribeDelaySubscription<T>
  implements Observable.OnSubscribe<T>
{
  final Scheduler scheduler;
  final Observable<? extends T> source;
  final long time;
  final TimeUnit unit;
  
  public OnSubscribeDelaySubscription(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    source = paramObservable;
    time = paramLong;
    unit = paramTimeUnit;
    scheduler = paramScheduler;
  }
  
  public void call(final Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = scheduler.createWorker();
    paramSubscriber.add(localWorker);
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        if (!paramSubscriber.isUnsubscribed()) {
          source.unsafeSubscribe(Subscribers.wrap(paramSubscriber));
        }
      }
    }, time, unit);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */