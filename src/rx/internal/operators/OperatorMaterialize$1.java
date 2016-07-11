package rx.internal.operators;

import rx.Notification;
import rx.Subscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class OperatorMaterialize$1
  extends Subscriber<T>
{
  OperatorMaterialize$1(OperatorMaterialize paramOperatorMaterialize, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$child.onNext(Notification.createOnCompleted());
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
    val$child.onNext(Notification.createOnError(paramThrowable));
    val$child.onCompleted();
  }
  
  public void onNext(T paramT)
  {
    val$child.onNext(Notification.createOnNext(paramT));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMaterialize.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */