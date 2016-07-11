package com.unity3d.player;

import java.util.concurrent.Semaphore;

final class UnityPlayer$17
  implements Runnable
{
  UnityPlayer$17(UnityPlayer paramUnityPlayer, Semaphore paramSemaphore) {}
  
  public final void run()
  {
    UnityPlayer.h(b);
    a.release();
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */