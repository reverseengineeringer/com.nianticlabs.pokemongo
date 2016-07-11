package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action0;

class OnSubscribeAmb$1
  implements Action0
{
  OnSubscribeAmb$1(OnSubscribeAmb paramOnSubscribeAmb) {}
  
  public void call()
  {
    OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)this$0.choice.get();
    if (localAmbSubscriber != null) {
      localAmbSubscriber.unsubscribe();
    }
    OnSubscribeAmb.access$100(this$0.selection.ambSubscribers);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */