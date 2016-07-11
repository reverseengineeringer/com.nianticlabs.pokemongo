package rx;

import rx.functions.Action0;

class Observable$7
  implements Observer<T>
{
  Observable$7(Observable paramObservable, Action0 paramAction0) {}
  
  public final void onCompleted()
  {
    val$onCompleted.call();
  }
  
  public final void onError(Throwable paramThrowable) {}
  
  public final void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.Observable.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */