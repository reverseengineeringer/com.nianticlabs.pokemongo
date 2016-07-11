package com.unity3d.player;

import android.hardware.Camera;
import android.view.SurfaceHolder;

final class a$2
  extends b
{
  Camera a = b.a;
  
  a$2(a parama)
  {
    super(3);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    synchronized (a.a(b))
    {
      if (b.a != a) {
        return;
      }
    }
    try
    {
      b.a.setPreviewDisplay(paramSurfaceHolder);
      b.a.startPreview();
      return;
      paramSurfaceHolder = finally;
      throw paramSurfaceHolder;
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        m.Log(6, "Unable to initialize webcam data stream: " + paramSurfaceHolder.getMessage());
      }
    }
  }
  
  public final void surfaceDestroyed(SurfaceHolder arg1)
  {
    synchronized (a.a(b))
    {
      if (b.a != a) {
        return;
      }
      b.a.stopPreview();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.a.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */