package com.voxelbusters.common;

import android.content.Context;
import com.unity3d.player.UnityPlayer;

public class Configuration
{
  public static Context getContext()
  {
    return UnityPlayer.currentActivity;
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.common.Configuration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */