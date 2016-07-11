package com.upsight.android.internal.persistence.subscription;

import com.squareup.otto.Bus;
import rx.functions.Action0;

class OnSubscribeBus$1
  implements Action0
{
  OnSubscribeBus$1(OnSubscribeBus paramOnSubscribeBus, OnSubscribeBus.BusAdapter paramBusAdapter) {}
  
  public void call()
  {
    OnSubscribeBus.access$100(this$0).unregister(val$adapter);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.OnSubscribeBus.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */