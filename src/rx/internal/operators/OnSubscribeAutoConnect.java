package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;

public final class OnSubscribeAutoConnect<T>
  implements Observable.OnSubscribe<T>
{
  final AtomicInteger clients;
  final Action1<? super Subscription> connection;
  final int numberOfSubscribers;
  final ConnectableObservable<? extends T> source;
  
  public OnSubscribeAutoConnect(ConnectableObservable<? extends T> paramConnectableObservable, int paramInt, Action1<? super Subscription> paramAction1)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }
    source = paramConnectableObservable;
    numberOfSubscribers = paramInt;
    connection = paramAction1;
    clients = new AtomicInteger();
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    source.unsafeSubscribe(Subscribers.wrap(paramSubscriber));
    if (clients.incrementAndGet() == numberOfSubscribers) {
      source.connect(connection);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeAutoConnect
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */