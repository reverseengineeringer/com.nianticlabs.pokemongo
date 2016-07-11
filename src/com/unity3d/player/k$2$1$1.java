package com.unity3d.player;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

final class k$2$1$1
  implements SurfaceHolder.Callback
{
  k$2$1$1(k.2.1 param1) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    a.a.c.displayChanged(1, paramSurfaceHolder.getSurface());
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    a.a.c.displayChanged(1, paramSurfaceHolder.getSurface());
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    a.a.c.displayChanged(1, null);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.k.2.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */