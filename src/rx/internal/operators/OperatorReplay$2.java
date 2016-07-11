package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class OperatorReplay$2
  implements Observable.OnSubscribe<T>
{
  OperatorReplay$2(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    val$target.unsafeSubscribe(paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorReplay.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */