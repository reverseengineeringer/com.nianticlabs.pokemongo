package com.unity3d.player;

final class UnityPlayer$14
  implements Runnable
{
  UnityPlayer$14(UnityPlayer paramUnityPlayer) {}
  
  public final void run()
  {
    if (UnityPlayer.q(a) == null) {
      return;
    }
    UnityPlayer.g(a).c(UnityPlayer.f(a));
    a.removeView(UnityPlayer.q(a));
    UnityPlayer.a(a, null);
    a.resume();
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */