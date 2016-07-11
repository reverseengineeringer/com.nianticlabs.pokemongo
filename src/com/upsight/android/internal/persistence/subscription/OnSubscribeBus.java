package com.upsight.android.internal.persistence.subscription;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

class OnSubscribeBus
  implements Observable.OnSubscribe<DataStoreEvent>
{
  private final Bus mBus;
  
  OnSubscribeBus(Bus paramBus)
  {
    mBus = paramBus;
  }
  
  public void call(Subscriber<? super DataStoreEvent> paramSubscriber)
  {
    final BusAdapter localBusAdapter = new BusAdapter(paramSubscriber, null);
    mBus.register(localBusAdapter);
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        mBus.unregister(localBusAdapter);
      }
    }));
  }
  
  private static class BusAdapter
  {
    private final Subscriber<? super DataStoreEvent> mChild;
    
    private BusAdapter(Subscriber<? super DataStoreEvent> paramSubscriber)
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
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.OnSubscribeBus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */