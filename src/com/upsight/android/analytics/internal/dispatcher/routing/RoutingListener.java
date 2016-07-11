package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.analytics.internal.DataStoreRecord;
import com.upsight.android.analytics.internal.dispatcher.delivery.OnResponseListener;

public abstract interface RoutingListener
  extends OnResponseListener
{
  public abstract void onDelivery(DataStoreRecord paramDataStoreRecord, boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public abstract void onRoutingFinished(Router paramRouter);
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.RoutingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */