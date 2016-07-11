package rx.internal.operators;

import rx.Subscription;
import rx.functions.Action1;
import rx.observers.SafeSubscriber;

class OnSubscribeMulticastSelector$1
  implements Action1<Subscription>
{
  OnSubscribeMulticastSelector$1(OnSubscribeMulticastSelector paramOnSubscribeMulticastSelector, SafeSubscriber paramSafeSubscriber) {}
  
  public void call(Subscription paramSubscription)
  {
    val$s.add(paramSubscription);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeMulticastSelector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */