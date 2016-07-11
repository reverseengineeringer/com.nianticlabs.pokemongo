package com.upsight.android.internal.persistence.subscription;

import com.squareup.otto.Subscribe;
import rx.Subscriber;

class OnSubscribeBus$BusAdapter
{
  private final Subscriber<? super DataStoreEvent> mChild;
  
  private OnSubscribeBus$BusAdapter(Subscriber<? super DataStoreEvent> paramSubscriber)
  {
    mChild = paramSubscriber;
  }
  
  @Subscribe
  public void onPersistenceEvent(DataStoreEvent paramDataStoreEvent)
  {
    if (!mChild.isUnsubscribed()) {
      mChild.onNext(paramDataStoreEvent);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.OnSubscribeBus.BusAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */