package rx.observers;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

final class Observers$4
  implements Observer<T>
{
  Observers$4(Action0 paramAction0, Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted()
  {
    val$onComplete.call();
  }
  
  public final void onError(Throwable paramThrowable)
  {
    val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    val$onNext.call(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.observers.Observers.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */