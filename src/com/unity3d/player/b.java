package com.unity3d.player;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

abstract class b
  implements SurfaceHolder.Callback
{
  private final Activity a = (Activity)t.a.a();
  private final int b = 3;
  private SurfaceView c;
  
  b(int paramInt) {}
  
  final void a()
  {
    a.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        if (b.a(b.this) == null)
        {
          b.a(b.this, new SurfaceView(t.a.a()));
          b.a(b.this).getHolder().setType(b.b(b.this));
          b.a(b.this).getHolder().addCallback(b.this);
          t.a.a(b.a(b.this));
          b.a(b.this).setVisibility(0);
        }
      }
    });
  }
  
  final void b()
  {
    a.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        if (b.a(b.this) != null) {
          t.a.b(b.a(b.this));
        }
        b.a(b.this, null);
      }
    });
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}

/* Location:
 * Qualified Name:     com.unity3d.player.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */