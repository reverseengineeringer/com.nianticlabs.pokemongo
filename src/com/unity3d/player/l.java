package com.unity3d.player;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class l
  implements h
{
  private Choreographer a = null;
  private long b = 0L;
  private Choreographer.FrameCallback c;
  private Lock d = new ReentrantLock();
  
  public final void a()
  {
    d.lock();
    if (a != null) {
      a.removeFrameCallback(c);
    }
    a = null;
    d.unlock();
  }
  
  public final void a(final UnityPlayer paramUnityPlayer)
  {
    d.lock();
    if (a == null)
    {
      a = Choreographer.getInstance();
      if (a != null)
      {
        m.Log(4, "Choreographer available: Enabling VSYNC timing");
        c = new Choreographer.FrameCallback()
        {
          public final void doFrame(long paramAnonymousLong)
          {
            
            if (v.c()) {
              paramUnityPlayer.nativeAddVSyncTime(paramAnonymousLong);
            }
            UnityPlayer.unlockNativeAccess();
            l.a(l.this).lock();
            if (l.b(l.this) != null) {
              l.b(l.this).postFrameCallback(l.c(l.this));
            }
            l.a(l.this).unlock();
          }
        };
        a.postFrameCallback(c);
      }
    }
    d.unlock();
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */