package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class OperatorReplay$1
  implements Observable.OnSubscribe<T>
{
  OperatorReplay$1(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    OperatorReplay.subscriberOf(val$observedOn).call(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorReplay.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */