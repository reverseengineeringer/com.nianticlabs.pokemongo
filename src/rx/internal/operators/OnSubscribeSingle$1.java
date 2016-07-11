package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.SingleSubscriber;
import rx.Subscriber;

class OnSubscribeSingle$1
  extends Subscriber<T>
{
  private T emission = null;
  private boolean emittedTooMany = false;
  private boolean itemEmitted = false;
  
  OnSubscribeSingle$1(OnSubscribeSingle paramOnSubscribeSingle, SingleSubscriber paramSingleSubscriber) {}
  
  public void onCompleted()
  {
    if (emittedTooMany) {
      return;
    }
    if (itemEmitted)
    {
      val$child.onSuccess(emission);
      return;
    }
    val$child.onError(new NoSuchElementException("Observable emitted no items"));
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    if (itemEmitted)
    {
      emittedTooMany = true;
      val$child.onError(new IllegalArgumentException("Observable emitted too many elements"));
      unsubscribe();
      return;
    }
    itemEmitted = true;
    emission = paramT;
  }
  
  public void onStart()
  {
    request(2L);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeSingle.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */