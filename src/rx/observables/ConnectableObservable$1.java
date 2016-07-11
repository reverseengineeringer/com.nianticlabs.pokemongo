package rx.observables;

import rx.Subscription;
import rx.functions.Action1;

class ConnectableObservable$1
  implements Action1<Subscription>
{
  ConnectableObservable$1(ConnectableObservable paramConnectableObservable, Subscription[] paramArrayOfSubscription) {}
  
  public void call(Subscription paramSubscription)
  {
    val$out[0] = paramSubscription;
  }
}

/* Location:
 * Qualified Name:     rx.observables.ConnectableObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */