package com.unity3d.player;

import java.util.concurrent.Semaphore;

final class UnityPlayer$18
  implements Runnable
{
  UnityPlayer$18(UnityPlayer paramUnityPlayer, Semaphore paramSemaphore) {}
  
  public final void run()
  {
    if (UnityPlayer.i(b))
    {
      UnityPlayer.j(b);
      UnityPlayer.h(b);
      a.release(2);
      return;
    }
    a.release();
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */