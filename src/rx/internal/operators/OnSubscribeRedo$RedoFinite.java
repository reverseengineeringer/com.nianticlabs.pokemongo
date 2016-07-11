package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;

public final class OnSubscribeRedo$RedoFinite
  implements Func1<Observable<? extends Notification<?>>, Observable<?>>
{
  private final long count;
  
  public OnSubscribeRedo$RedoFinite(long paramLong)
  {
    count = paramLong;
  }
  
  public Observable<?> call(Observable<? extends Notification<?>> paramObservable)
  {
    paramObservable.map(new Func1()
    {
      int num = 0;
      
      public Notification<?> call(Notification<?> paramAnonymousNotification)
      {
        if (count == 0L) {}
        do
        {
          return paramAnonymousNotification;
          num += 1;
        } while (num > count);
        return Notification.createOnNext(Integer.valueOf(num));
      }
    }).dematerialize();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RedoFinite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */