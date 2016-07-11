package rx.internal.util;

import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

final class ScalarSynchronousObservable$NormalScheduledEmission<T>
  implements Observable.OnSubscribe<T>
{
  private final Scheduler scheduler;
  private final T value;
  
  ScalarSynchronousObservable$NormalScheduledEmission(Scheduler paramScheduler, T paramT)
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

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.NormalScheduledEmission
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */