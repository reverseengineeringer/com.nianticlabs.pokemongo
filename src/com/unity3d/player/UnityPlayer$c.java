package com.unity3d.player;

abstract class UnityPlayer$c
  implements Runnable
{
  private UnityPlayer$c(UnityPlayer paramUnityPlayer) {}
  
  public abstract void a();
  
  public final void run()
  {
    if (!f.isFinishing()) {
      a();
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */