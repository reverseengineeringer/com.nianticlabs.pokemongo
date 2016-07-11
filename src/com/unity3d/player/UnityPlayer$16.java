package com.unity3d.player;

final class UnityPlayer$16
  implements Runnable
{
  UnityPlayer$16(UnityPlayer paramUnityPlayer) {}
  
  public final void run()
  {
    if (UnityPlayer.e(a))
    {
      UnityPlayer.g(a).d(UnityPlayer.f(a));
      return;
    }
    UnityPlayer.g(a).c(UnityPlayer.f(a));
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */