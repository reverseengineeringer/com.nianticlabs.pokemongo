package com.upsight.android.internal.persistence.subscription;

import com.squareup.otto.Bus;
import rx.functions.Action1;

final class Subscriptions$3
  implements Action1<T>
{
  Subscriptions$3(Bus paramBus, String paramString) {}
  
  public void call(T paramT)
  {
    val$bus.post(new DataStoreEvent(DataStoreEvent.Action.Removed, val$type, paramT));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.Subscriptions.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */