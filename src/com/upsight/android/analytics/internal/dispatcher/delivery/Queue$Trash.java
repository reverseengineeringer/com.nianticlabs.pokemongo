package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.internal.dispatcher.routing.Packet;

public final class Queue$Trash
  extends Queue
{
  public static final String NAME = "trash";
  private OnDeliveryListener mOnDeliveryListener;
  
  public Queue$Trash()
  {
    super("trash", null, null, null, null);
  }
  
  public void enqueuePacket(Packet paramPacket)
  {
    paramPacket.markTrashed();
    OnDeliveryListener localOnDeliveryListener = mOnDeliveryListener;
    if (localOnDeliveryListener != null) {
      localOnDeliveryListener.onDelivery(paramPacket);
    }
  }
  
  public void setOnDeliveryListener(OnDeliveryListener paramOnDeliveryListener)
  {
    mOnDeliveryListener = paramOnDeliveryListener;
  }
  
  public void setOnResponseListener(OnResponseListener paramOnResponseListener) {}
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.Queue.Trash
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */