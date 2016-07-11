package rx.observers;

import rx.Subscriber;

final class Subscribers$5
  extends Subscriber<T>
{
  Subscribers$5(Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$subscriber.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.observers.Subscribers.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */