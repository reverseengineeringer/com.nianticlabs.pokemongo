package com.nianticproject.holoholo.sfida.service;

import android.os.Handler;
import android.util.Log;
import java.util.UUID;

public class SfidaWatchDog
{
  private static final int DEFAULT_RETRY_MAX = 3;
  private static final int DEFAULT_TIME_OUT = 3000;
  private static final String TAG = SfidaWatchDog.class.getSimpleName();
  private static SfidaWatchDog instance = new SfidaWatchDog();
  private OnTimeoutListener listener;
  private int retryCount = 0;
  private Handler watchDogTimer = new Handler();
  private UUID watchingUuid;
  
  public static SfidaWatchDog getInstance()
  {
    return instance;
  }
  
  public void startWatch(UUID paramUUID, OnTimeoutListener paramOnTimeoutListener)
  {
    Log.d(TAG, "startWatch()");
    startWatch(paramUUID, paramOnTimeoutListener, 3000);
  }
  
  public void startWatch(UUID paramUUID, OnTimeoutListener paramOnTimeoutListener, int paramInt)
  {
    Log.d(TAG, "startWatch()");
    listener = paramOnTimeoutListener;
    if ((watchingUuid != null) && (!watchingUuid.equals(paramUUID))) {
      retryCount = 0;
    }
    watchingUuid = paramUUID;
    watchDogTimer.removeCallbacksAndMessages(null);
    watchDogTimer.postDelayed(new WatchDogRunnable(paramUUID), paramInt);
  }
  
  public void stopWatch()
  {
    Log.d(TAG, "stopWatch()");
    retryCount = 0;
    listener = null;
    watchingUuid = null;
    watchDogTimer.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface OnTimeoutListener
  {
    public abstract void onTimeout(UUID paramUUID);
    
    public abstract void reachedRetryCountMax();
  }
  
  private class WatchDogRunnable
    implements Runnable
  {
    private UUID uuid;
    
    public WatchDogRunnable(UUID paramUUID)
    {
      uuid = paramUUID;
    }
    
    public void run()
    {
      if (retryCount >= 3)
      {
        Log.d(SfidaWatchDog.TAG, "Reached retry limit.");
        stopWatch();
        if (listener != null) {
          listener.reachedRetryCountMax();
        }
      }
      while (listener == null) {
        return;
      }
      listener.onTimeout(uuid);
      SfidaWatchDog.access$008(SfidaWatchDog.this);
      Log.d(SfidaWatchDog.TAG, "SFIDA connection TIMEOUT. UUID : " + uuid + "retryCount : " + retryCount);
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaWatchDog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */