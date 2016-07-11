package com.unity3d.player;

final class UnityPlayer$7
  implements Runnable
{
  UnityPlayer$7(UnityPlayer paramUnityPlayer) {}
  
  public final void run()
  {
    if (a.b != null)
    {
      a.b.dismiss();
      a.b = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */