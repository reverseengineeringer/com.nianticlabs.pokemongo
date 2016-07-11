package rx.observables;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class GroupedObservable$1
  implements Observable.OnSubscribe<T>
{
  GroupedObservable$1(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    val$o.unsafeSubscribe(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.observables.GroupedObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */