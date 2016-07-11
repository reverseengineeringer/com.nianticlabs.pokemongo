package rx;

import rx.functions.Action1;

public abstract interface Single$OnSubscribe<T>
  extends Action1<SingleSubscriber<? super T>>
{}

/* Location:
 * Qualified Name:     rx.Single.OnSubscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */