package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

class OnSubscribeDelaySubscription$1
  implements Action0
{
  OnSubscribeDelaySubscription$1(OnSubscribeDelaySubscription paramOnSubscribeDelaySubscription, Subscriber paramSubscriber) {}
  
  public void call()
  {
    if (!val$s.isUnsubscribed()) {
      this$0.source.unsafeSubscribe(Subscribers.wrap(val$s));
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscription.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */