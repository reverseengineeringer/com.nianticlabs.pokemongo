package com.nianticproject.holoholo.sfida.unity;

import android.os.Handler;
import android.util.Log;
import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.service.SfidaService;

class SfidaUnityPlugin$PeriodicVibrateRunnable
  implements Runnable
{
  Handler handler;
  
  public SfidaUnityPlugin$PeriodicVibrateRunnable(SfidaUnityPlugin paramSfidaUnityPlugin, Handler paramHandler)
  {
    handler = paramHandler;
  }
  
  public void run()
  {
    Log.d(SfidaUnityPlugin.access$000(), getClass().getName() + " run()");
    SfidaUnityPlugin.access$100(this$0).sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getCaptureSucceed());
    if (handler != null) {
      handler.postDelayed(this, 1000L);
    }
  }
  
  public void stop()
  {
    handler.removeCallbacks(null);
    handler = null;
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.SfidaUnityPlugin.PeriodicVibrateRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */