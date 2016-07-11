package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;

class OnSubscribeDelaySubscriptionWithSelector$1
  extends Subscriber<U>
{
  OnSubscribeDelaySubscriptionWithSelector$1(OnSubscribeDelaySubscriptionWithSelector paramOnSubscribeDelaySubscriptionWithSelector, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this$0.source.unsafeSubscribe(Subscribers.wrap(val$child));
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onNext(U paramU) {}
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */