package rx.observers;

import rx.Subscriber;
import rx.functions.Action1;

final class Subscribers$3
  extends Subscriber<T>
{
  Subscribers$3(Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted() {}
  
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
 * Qualified Name:     rx.observers.Subscribers.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */