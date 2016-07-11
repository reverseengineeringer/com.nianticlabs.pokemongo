package com.nianticproject.holoholo.sfida.unity;

import com.nianticproject.holoholo.sfida.service.SfidaService;
import com.unity3d.player.UnityPlayer;

class SfidaUnityPlugin$7
  extends EncounterPokemonClickCallback
{
  SfidaUnityPlugin$7(SfidaUnityPlugin paramSfidaUnityPlugin, String paramString)
  {
    super(paramString);
  }
  
  public void onClick()
  {
    super.onClick();
    SfidaUnityPlugin.access$100(this$0).setOnClickSfidaListener(null);
    UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "EnterEncounterState", getId());
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.SfidaUnityPlugin.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */