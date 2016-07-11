package com.nianticproject.holoholo.sfida.unity;

import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.service.SfidaButtonDetector.OnClickListener;
import com.nianticproject.holoholo.sfida.service.SfidaService;
import com.unity3d.player.UnityPlayer;

class SfidaUnityPlugin$8
  implements SfidaButtonDetector.OnClickListener
{
  SfidaUnityPlugin$8(SfidaUnityPlugin paramSfidaUnityPlugin) {}
  
  public void onClick()
  {
    SfidaUnityPlugin.access$100(this$0).sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getThrewPokeball());
    SfidaUnityPlugin.access$100(this$0).setOnClickSfidaListener(null);
    UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "ThrowPokeball", "");
  }
  
  public void onPress() {}
  
  public void onRelease() {}
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.SfidaUnityPlugin.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */