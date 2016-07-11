package rx.internal.operators;

import rx.Notification;
import rx.functions.Func1;

class OnSubscribeRedo$1$1
  implements Func1<Notification<?>, Notification<?>>
{
  OnSubscribeRedo$1$1(OnSubscribeRedo.1 param1) {}
  
  public Notification<?> call(Notification<?> paramNotification)
  {
    return Notification.createOnNext(null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */