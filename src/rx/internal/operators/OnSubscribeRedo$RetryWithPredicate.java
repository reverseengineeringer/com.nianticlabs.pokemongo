package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OnSubscribeRedo$RetryWithPredicate
  implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>>
{
  private Func2<Integer, Throwable, Boolean> predicate;
  
  public OnSubscribeRedo$RetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    predicate = paramFunc2;
  }
  
  public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> paramObservable)
  {
    paramObservable.scan(Notification.createOnNext(Integer.valueOf(0)), new Func2()
    {
      public Notification<Integer> call(Notification<Integer> paramAnonymousNotification, Notification<?> paramAnonymousNotification1)
      {
        int i = ((Integer)paramAnonymousNotification.getValue()).intValue();
        paramAnonymousNotification = paramAnonymousNotification1;
        if (((Boolean)predicate.call(Integer.valueOf(i), paramAnonymousNotification1.getThrowable())).booleanValue()) {
          paramAnonymousNotification = Notification.createOnNext(Integer.valueOf(i + 1));
        }
        return paramAnonymousNotification;
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RetryWithPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */