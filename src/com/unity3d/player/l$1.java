package com.unity3d.player;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.locks.Lock;

final class l$1
  implements Choreographer.FrameCallback
{
  l$1(l paraml, UnityPlayer paramUnityPlayer) {}
  
  public final void doFrame(long paramLong)
  {
    
    if (v.c()) {
      a.nativeAddVSyncTime(paramLong);
    }
    UnityPlayer.unlockNativeAccess();
    l.a(b).lock();
    if (l.b(b) != null) {
      l.b(b).postFrameCallback(l.c(b));
    }
    l.a(b).unlock();
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.l.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */