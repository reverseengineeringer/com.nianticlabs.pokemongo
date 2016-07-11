package rx;

import rx.functions.Func1;

class Observable$27$1
  implements Func1<Notification<?>, Throwable>
{
  Observable$27$1(Observable.27 param27) {}
  
  public Throwable call(Notification<?> paramNotification)
  {
    return paramNotification.getThrowable();
  }
}

/* Location:
 * Qualified Name:     rx.Observable.27.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */