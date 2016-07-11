package rx;

import rx.exceptions.OnErrorNotImplementedException;

class Observable$29
  extends Subscriber<T>
{
  Observable$29(Observable paramObservable) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT) {}
}

/* Location:
 * Qualified Name:     rx.Observable.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */