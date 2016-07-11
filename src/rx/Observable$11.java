package rx;

import rx.functions.Action0;

class Observable$11
  implements Observer<T>
{
  Observable$11(Observable paramObservable, Action0 paramAction0) {}
  
  public final void onCompleted()
  {
    val$onTerminate.call();
  }
  
  public final void onError(Throwable paramThrowable)
  {
    val$onTerminate.call();
  }
  
  public final void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.Observable.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */