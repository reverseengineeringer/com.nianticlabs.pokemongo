package com.unity3d.player;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    if (b.a(a) == null)
    {
      b.a(a, new SurfaceView(t.a.a()));
      b.a(a).getHolder().setType(b.b(a));
      b.a(a).getHolder().addCallback(a);
      t.a.a(b.a(a));
      b.a(a).setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.b.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */