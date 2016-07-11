package com.squareup.otto;

import java.util.concurrent.ConcurrentLinkedQueue;

class Bus$1
  extends ThreadLocal<ConcurrentLinkedQueue<Bus.EventWithHandler>>
{
  Bus$1(Bus paramBus) {}
  
  protected ConcurrentLinkedQueue<Bus.EventWithHandler> initialValue()
  {
    return new ConcurrentLinkedQueue();
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.Bus.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */