package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.internal.dispatcher.routing.Packet;

public abstract interface OnDeliveryListener
{
  public abstract void onDelivery(Packet paramPacket);
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.OnDeliveryListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */