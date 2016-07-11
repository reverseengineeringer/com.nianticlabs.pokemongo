package rx.internal.util;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.internal.schedulers.EventLoopsScheduler;

final class ScalarSynchronousObservable$DirectScheduledEmission<T>
  implements Observable.OnSubscribe<T>
{
  private final EventLoopsScheduler es;
  private final T value;
  
  ScalarSynchronousObservable$DirectScheduledEmission(EventLoopsScheduler paramEventLoopsScheduler, T paramT)
  {
    es = paramEventLoopsScheduler;
    value = paramT;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(es.scheduleDirect(new ScalarSynchronousObservable.ScalarSynchronousAction(paramSubscriber, value, null)));
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.DirectScheduledEmission
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */