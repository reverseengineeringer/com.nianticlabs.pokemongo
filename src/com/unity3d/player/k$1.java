package com.unity3d.player;

import android.hardware.display.DisplayManager.DisplayListener;

final class k$1
  implements DisplayManager.DisplayListener
{
  k$1(k paramk, UnityPlayer paramUnityPlayer) {}
  
  public final void onDisplayAdded(int paramInt)
  {
    a.displayChanged(-1, null);
  }
  
  public final void onDisplayChanged(int paramInt)
  {
    a.displayChanged(-1, null);
  }
  
  public final void onDisplayRemoved(int paramInt)
  {
    a.displayChanged(-1, null);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.k.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */