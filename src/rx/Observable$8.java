package rx;

import rx.functions.Action1;

class Observable$8
  implements Observer<T>
{
  Observable$8(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted()
  {
    val$onNotification.call(Notification.createOnCompleted());
  }
  
  public final void onError(Throwable paramThrowable)
  {
    val$onNotification.call(Notification.createOnError(paramThrowable));
  }
  
  public final void onNext(T paramT)
  {
    val$onNotification.call(Notification.createOnNext(paramT));
  }
}

/* Location:
 * Qualified Name:     rx.Observable.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */