package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.analytics.dispatcher.EndpointResponse;
import com.upsight.android.analytics.internal.DataStoreRecord;
import com.upsight.android.analytics.internal.dispatcher.delivery.OnDeliveryListener;
import com.upsight.android.analytics.internal.dispatcher.delivery.OnResponseListener;
import com.upsight.android.analytics.internal.dispatcher.util.ByFilterSelector;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;

public class Router
  implements OnDeliveryListener, OnResponseListener
{
  private final AtomicInteger mEventsInRouting = new AtomicInteger();
  private boolean mIsFinishRequested;
  private final ByFilterSelector<Route> mRouteSelector;
  private final RoutingListener mRoutingListener;
  private final Scheduler.Worker mWorker;
  
  Router(Scheduler paramScheduler, ByFilterSelector<Route> paramByFilterSelector, RoutingListener paramRoutingListener)
  {
    mWorker = paramScheduler.createWorker();
    mRouteSelector = paramByFilterSelector;
    mRoutingListener = paramRoutingListener;
  }
  
  private void finishPacket()
  {
    int i = mEventsInRouting.decrementAndGet();
    if ((mIsFinishRequested) && (i == 0)) {
      mRoutingListener.onRoutingFinished(this);
    }
  }
  
  public void finishRouting()
  {
    mIsFinishRequested = true;
    if (mEventsInRouting.get() == 0) {
      mRoutingListener.onRoutingFinished(this);
    }
  }
  
  public void onDelivery(final Packet paramPacket)
  {
    mWorker.schedule(new Action0()
    {
      public void call()
      {
        Packet.State localState = paramPacket.getState();
        switch (Router.3.$SwitchMap$com$upsight$android$analytics$internal$dispatcher$routing$Packet$State[localState.ordinal()])
        {
        default: 
          return;
        case 1: 
          if (paramPacket.hasMoreOptionsToTry())
          {
            paramPacket.routeToNext();
            return;
          }
          mRoutingListener.onDelivery(paramPacket.getRecord(), false, false, paramPacket.getDeliveryHistory());
          Router.this.finishPacket();
          return;
        case 2: 
          mRoutingListener.onDelivery(paramPacket.getRecord(), true, false, null);
          Router.this.finishPacket();
          return;
        }
        mRoutingListener.onDelivery(paramPacket.getRecord(), false, true, paramPacket.getDeliveryHistory());
        Router.this.finishPacket();
      }
    });
  }
  
  public void onResponse(final EndpointResponse paramEndpointResponse)
  {
    mWorker.schedule(new Action0()
    {
      public void call()
      {
        mRoutingListener.onResponse(paramEndpointResponse);
      }
    });
  }
  
  public boolean routeEvent(DataStoreRecord paramDataStoreRecord)
  {
    if (mIsFinishRequested) {
      throw new IllegalStateException("Router is requested to finish routing");
    }
    Route localRoute = (Route)mRouteSelector.select(paramDataStoreRecord.getSourceType());
    if ((localRoute == null) || (localRoute.getStepsCount() == 0)) {
      return false;
    }
    new Packet(paramDataStoreRecord, new Route(localRoute)).routeToNext();
    mEventsInRouting.incrementAndGet();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.Router
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */