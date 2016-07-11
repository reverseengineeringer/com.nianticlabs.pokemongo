package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;

final class OnSubscribeRedo$1
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    paramObservable.map(new Func1()
    {
      public Notification<?> call(Notification<?> paramAnonymousNotification)
      {
        return Notification.createOnNext(null);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */