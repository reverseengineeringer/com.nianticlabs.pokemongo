package rx.internal.operators;

import rx.Notification;
import rx.functions.Func1;

class OnSubscribeRedo$RedoFinite$1
  implements Func1<Notification<?>, Notification<?>>
{
  int num = 0;
  
  OnSubscribeRedo$RedoFinite$1(OnSubscribeRedo.RedoFinite paramRedoFinite) {}
  
  public Notification<?> call(Notification<?> paramNotification)
  {
    if (OnSubscribeRedo.RedoFinite.access$000(this$0) == 0L) {}
    do
    {
      return paramNotification;
      num += 1;
    } while (num > OnSubscribeRedo.RedoFinite.access$000(this$0));
    return Notification.createOnNext(Integer.valueOf(num));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RedoFinite.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */