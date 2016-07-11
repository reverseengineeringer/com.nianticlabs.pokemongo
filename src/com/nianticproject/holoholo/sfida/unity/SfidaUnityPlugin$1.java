package com.nianticproject.holoholo.sfida.unity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.nianticproject.holoholo.sfida.service.SfidaService;
import com.nianticproject.holoholo.sfida.service.SfidaService.LocalBinder;

class SfidaUnityPlugin$1
  implements ServiceConnection
{
  SfidaUnityPlugin$1(SfidaUnityPlugin paramSfidaUnityPlugin) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Log.d(SfidaUnityPlugin.access$000(), "onServiceConnected()");
    SfidaUnityPlugin.access$102(this$0, ((SfidaService.LocalBinder)paramIBinder).getService());
    if (!SfidaUnityPlugin.access$100(this$0).initialize())
    {
      Log.e(SfidaUnityPlugin.access$000(), "Unable to initialize Bluetooth");
      return;
    }
    SfidaUnityPlugin.access$100(this$0).connect(SfidaUnityPlugin.access$200(this$0));
    SfidaUnityPlugin.access$302(this$0, true);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.d(SfidaUnityPlugin.access$000(), "[BLE] onServiceDisconnected()");
    SfidaUnityPlugin.access$102(this$0, null);
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.SfidaUnityPlugin.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */