package rx;

import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

class Observable$30
  extends Subscriber<T>
{
  Observable$30(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    val$onNext.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */