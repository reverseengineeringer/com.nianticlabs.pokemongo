package rx.internal.operators;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.Producer;

class OnSubscribeAmb$2
  implements Producer
{
  OnSubscribeAmb$2(OnSubscribeAmb paramOnSubscribeAmb) {}
  
  public void request(long paramLong)
  {
    Object localObject = (OnSubscribeAmb.AmbSubscriber)this$0.choice.get();
    if (localObject != null) {
      OnSubscribeAmb.AmbSubscriber.access$300((OnSubscribeAmb.AmbSubscriber)localObject, paramLong);
    }
    for (;;)
    {
      return;
      localObject = this$0.selection.ambSubscribers.iterator();
      while (((Iterator)localObject).hasNext())
      {
        OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)((Iterator)localObject).next();
        if (!localAmbSubscriber.isUnsubscribed())
        {
          if (this$0.choice.get() == localAmbSubscriber)
          {
            OnSubscribeAmb.AmbSubscriber.access$300(localAmbSubscriber, paramLong);
            return;
          }
          OnSubscribeAmb.AmbSubscriber.access$300(localAmbSubscriber, paramLong);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */