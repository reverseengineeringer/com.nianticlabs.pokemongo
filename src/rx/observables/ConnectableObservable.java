package rx.observables;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.OnSubscribeAutoConnect;
import rx.internal.operators.OnSubscribeRefCount;

public abstract class ConnectableObservable<T>
  extends Observable<T>
{
  protected ConnectableObservable(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    super(paramOnSubscribe);
  }
  
  @Experimental
  public Observable<T> autoConnect()
  {
    return autoConnect(1);
  }
  
  @Experimental
  public Observable<T> autoConnect(int paramInt)
  {
    return autoConnect(paramInt, Actions.empty());
  }
  
  @Experimental
  public Observable<T> autoConnect(int paramInt, Action1<? super Subscription> paramAction1)
  {
    if (paramInt <= 0)
    {
      connect(paramAction1);
      return this;
    }
    return create(new OnSubscribeAutoConnect(this, paramInt, paramAction1));
  }
  
  public final Subscription connect()
  {
    final Subscription[] arrayOfSubscription = new Subscription[1];
    connect(new Action1()
    {
      public void call(Subscription paramAnonymousSubscription)
      {
        arrayOfSubscription[0] = paramAnonymousSubscription;
      }
    });
    return arrayOfSubscription[0];
  }
  
  public abstract void connect(Action1<? super Subscription> paramAction1);
  
  public Observable<T> refCount()
  {
    return create(new OnSubscribeRefCount(this));
  }
}

/* Location:
 * Qualified Name:     rx.observables.ConnectableObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */