package com.nianticproject.holoholo.sfida.service;

import android.util.Log;
import java.util.UUID;

class SfidaWatchDog$WatchDogRunnable
  implements Runnable
{
  private UUID uuid;
  
  public SfidaWatchDog$WatchDogRunnable(SfidaWatchDog paramSfidaWatchDog, UUID paramUUID)
  {
    uuid = paramUUID;
  }
  
  public void run()
  {
    if (SfidaWatchDog.access$000(this$0) >= 3)
    {
      Log.d(SfidaWatchDog.access$100(), "Reached retry limit.");
      this$0.stopWatch();
      if (SfidaWatchDog.access$200(this$0) != null) {
        SfidaWatchDog.access$200(this$0).reachedRetryCountMax();
      }
    }
    while (SfidaWatchDog.access$200(this$0) == null) {
      return;
    }
    SfidaWatchDog.access$200(this$0).onTimeout(uuid);
    SfidaWatchDog.access$008(this$0);
    Log.d(SfidaWatchDog.access$100(), "SFIDA connection TIMEOUT. UUID : " + uuid + "retryCount : " + SfidaWatchDog.access$000(this$0));
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaWatchDog.WatchDogRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */