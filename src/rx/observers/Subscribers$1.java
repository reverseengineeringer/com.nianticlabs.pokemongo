package rx.observers;

import rx.Observer;
import rx.Subscriber;

final class Subscribers$1
  extends Subscriber<T>
{
  Subscribers$1(Observer paramObserver) {}
  
  public void onCompleted()
  {
    val$o.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$o.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.observers.Subscribers.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */