package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

final class OperatorPublish$2
  implements Observable.OnSubscribe<R>
{
  OperatorPublish$2(Observable paramObservable, Func1 paramFunc1) {}
  
  public void call(final Subscriber<? super R> paramSubscriber)
  {
    ConnectableObservable localConnectableObservable = OperatorPublish.create(val$source);
    ((Observable)val$selector.call(localConnectableObservable)).unsafeSubscribe(paramSubscriber);
    localConnectableObservable.connect(new Action1()
    {
      public void call(Subscription paramAnonymousSubscription)
      {
        paramSubscriber.add(paramAnonymousSubscription);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */