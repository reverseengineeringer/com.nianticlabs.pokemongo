package rx.observers;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

final class Observers$2
  implements Observer<T>
{
  Observers$2(Action1 paramAction1) {}
  
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
 * Qualified Name:     rx.observers.Observers.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */