package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.RefCountSubscription;

final class OnSubscribeGroupJoin$WindowObservableFunc<T>
  implements Observable.OnSubscribe<T>
{
  final RefCountSubscription refCount;
  final Observable<T> underlying;
  
  public OnSubscribeGroupJoin$WindowObservableFunc(Observable<T> paramObservable, RefCountSubscription paramRefCountSubscription)
  {
    refCount = paramRefCountSubscription;
    underlying = paramObservable;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Subscription localSubscription = refCount.get();
    paramSubscriber = new WindowSubscriber(paramSubscriber, localSubscription);
    paramSubscriber.add(localSubscription);
    underlying.unsafeSubscribe(paramSubscriber);
  }
  
  final class WindowSubscriber
    extends Subscriber<T>
  {
    private final Subscription ref;
    final Subscriber<? super T> subscriber;
    
    public WindowSubscriber(Subscription paramSubscription)
    {
      super();
      subscriber = paramSubscription;
      Subscription localSubscription;
      ref = localSubscription;
    }
    
    public void onCompleted()
    {
      subscriber.onCompleted();
      ref.unsubscribe();
    }
    
    public void onError(Throwable paramThrowable)
    {
      subscriber.onError(paramThrowable);
      ref.unsubscribe();
    }
    
    public void onNext(T paramT)
    {
      subscriber.onNext(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.WindowObservableFunc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */