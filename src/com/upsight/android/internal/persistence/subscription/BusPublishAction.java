package com.upsight.android.internal.persistence.subscription;

import com.squareup.otto.Bus;
import rx.functions.Action1;

class BusPublishAction
  implements Action1<DataStoreEvent>
{
  private final Bus bus;
  
  BusPublishAction(Bus paramBus)
  {
    bus = paramBus;
  }
  
  public void call(DataStoreEvent paramDataStoreEvent)
  {
    bus.post(paramDataStoreEvent);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.BusPublishAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */