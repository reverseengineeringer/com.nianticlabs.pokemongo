package rx;

import rx.functions.Action1;

class Observable$9
  implements Observer<T>
{
  Observable$9(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.Observable.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */