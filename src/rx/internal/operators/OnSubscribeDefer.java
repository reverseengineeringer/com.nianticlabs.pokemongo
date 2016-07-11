package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func0;
import rx.observers.Subscribers;

public final class OnSubscribeDefer<T>
  implements Observable.OnSubscribe<T>
{
  final Func0<? extends Observable<? extends T>> observableFactory;
  
  public OnSubscribeDefer(Func0<? extends Observable<? extends T>> paramFunc0)
  {
    observableFactory = paramFunc0;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      Observable localObservable = (Observable)observableFactory.call();
      localObservable.unsafeSubscribe(Subscribers.wrap(paramSubscriber));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeDefer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */