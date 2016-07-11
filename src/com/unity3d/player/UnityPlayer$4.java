package com.unity3d.player;

import android.widget.ProgressBar;

final class UnityPlayer$4
  implements Runnable
{
  UnityPlayer$4(UnityPlayer paramUnityPlayer) {}
  
  public final void run()
  {
    if (UnityPlayer.m(a) != null)
    {
      UnityPlayer.m(a).setVisibility(8);
      a.removeView(UnityPlayer.m(a));
      UnityPlayer.a(a, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */