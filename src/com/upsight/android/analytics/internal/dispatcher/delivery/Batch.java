package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.internal.dispatcher.routing.Packet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Batch
{
  private int mCapacityLeft;
  private Set<Packet> mPackets;
  
  public Batch(int paramInt)
  {
    mCapacityLeft = paramInt;
    mPackets = new HashSet();
  }
  
  public void addPacket(Packet paramPacket)
  {
    mPackets.add(paramPacket);
    mCapacityLeft -= 1;
  }
  
  public int capacityLeft()
  {
    return mCapacityLeft;
  }
  
  public Set<Packet> getPackets()
  {
    return Collections.unmodifiableSet(mPackets);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.Batch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */