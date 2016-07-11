package com.squareup.otto;

public class DeadEvent
{
  public final Object event;
  public final Object source;
  
  public DeadEvent(Object paramObject1, Object paramObject2)
  {
    source = paramObject1;
    event = paramObject2;
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.DeadEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */