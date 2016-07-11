package com.unity3d.player;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;

final class UnityPlayer$2
  implements Runnable
{
  UnityPlayer$2(UnityPlayer paramUnityPlayer) {}
  
  public final void run()
  {
    int i = UnityPlayer.l(a);
    if (i >= 0)
    {
      if (UnityPlayer.m(a) == null)
      {
        UnityPlayer.a(a, new ProgressBar(UnityPlayer.n(a), null, new int[] { 16842874, 16843401, 16842873, 16843400 }[i]));
        UnityPlayer.m(a).setIndeterminate(true);
        UnityPlayer.m(a).setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 51));
        a.addView(UnityPlayer.m(a));
      }
      UnityPlayer.m(a).setVisibility(0);
      a.bringChildToFront(UnityPlayer.m(a));
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */