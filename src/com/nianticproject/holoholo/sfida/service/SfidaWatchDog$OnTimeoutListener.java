package com.nianticproject.holoholo.sfida.service;

import java.util.UUID;

public abstract interface SfidaWatchDog$OnTimeoutListener
{
  public abstract void onTimeout(UUID paramUUID);
  
  public abstract void reachedRetryCountMax();
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaWatchDog.OnTimeoutListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */