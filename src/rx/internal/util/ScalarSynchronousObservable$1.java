package rx.internal.util;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class ScalarSynchronousObservable$1
  implements Observable.OnSubscribe<T>
{
  ScalarSynchronousObservable$1(Object paramObject) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.onNext(val$t);
    paramSubscriber.onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */