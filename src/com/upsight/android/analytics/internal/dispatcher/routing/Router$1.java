package com.upsight.android.analytics.internal.dispatcher.routing;

import rx.functions.Action0;

class Router$1
  implements Action0
{
  Router$1(Router paramRouter, Packet paramPacket) {}
  
  public void call()
  {
    Packet.State localState = val$packet.getState();
    switch (Router.3.$SwitchMap$com$upsight$android$analytics$internal$dispatcher$routing$Packet$State[localState.ordinal()])
    {
    default: 
      return;
    case 1: 
      if (val$packet.hasMoreOptionsToTry())
      {
        val$packet.routeToNext();
        return;
      }
      Router.access$000(this$0).onDelivery(val$packet.getRecord(), false, false, val$packet.getDeliveryHistory());
      Router.access$100(this$0);
      return;
    case 2: 
      Router.access$000(this$0).onDelivery(val$packet.getRecord(), true, false, null);
      Router.access$100(this$0);
      return;
    }
    Router.access$000(this$0).onDelivery(val$packet.getRecord(), false, true, val$packet.getDeliveryHistory());
    Router.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.Router.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */