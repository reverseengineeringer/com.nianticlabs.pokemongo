package rx.internal.operators;

import rx.Notification;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public final class OperatorMaterialize<T>
  implements Observable.Operator<Notification<T>, T>
{
  public static <T> OperatorMaterialize<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super Notification<T>> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onNext(Notification.createOnCompleted());
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(paramAnonymousThrowable);
        paramSubscriber.onNext(Notification.createOnError(paramAnonymousThrowable));
        paramSubscriber.onCompleted();
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSubscriber.onNext(Notification.createOnNext(paramAnonymousT));
      }
    };
  }
  
  private static final class Holder
  {
    static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize(null);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMaterialize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */