package com.unity3d.player;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

final class UnityPlayer$13
  implements SurfaceHolder.Callback
{
  UnityPlayer$13(UnityPlayer paramUnityPlayer) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    UnityPlayer.a(a, paramSurfaceHolder.getSurface());
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    UnityPlayer.a(a, paramSurfaceHolder.getSurface());
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    UnityPlayer.a(a, null);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */