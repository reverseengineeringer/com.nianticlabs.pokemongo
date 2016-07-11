package rx.internal.operators;

import rx.Notification;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorDematerialize<T>
  implements Observable.Operator<T, Notification<T>>
{
  public static OperatorDematerialize instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super Notification<T>> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      boolean terminated;
      
      public void onCompleted()
      {
        if (!terminated)
        {
          terminated = true;
          paramSubscriber.onCompleted();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (!terminated)
        {
          terminated = true;
          paramSubscriber.onError(paramAnonymousThrowable);
        }
      }
      
      public void onNext(Notification<T> paramAnonymousNotification)
      {
        switch (OperatorDematerialize.2.$SwitchMap$rx$Notification$Kind[paramAnonymousNotification.getKind().ordinal()])
        {
        default: 
        case 1: 
          do
          {
            return;
          } while (terminated);
          paramSubscriber.onNext(paramAnonymousNotification.getValue());
          return;
        case 2: 
          onError(paramAnonymousNotification.getThrowable());
          return;
        }
        onCompleted();
      }
    };
  }
  
  private static final class Holder
  {
    static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize(null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDematerialize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */