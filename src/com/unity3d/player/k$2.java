package com.unity3d.player;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

final class k$2
  implements Runnable
{
  k$2(k paramk, Context paramContext, Display paramDisplay, UnityPlayer paramUnityPlayer) {}
  
  public final void run()
  {
    synchronized (k.a(d))
    {
      if (k.b(d) != null) {
        k.b(d).dismiss();
      }
      k.a(d, new Presentation(a, b)
      {
        protected final void onCreate(Bundle paramAnonymousBundle)
        {
          paramAnonymousBundle = new SurfaceView(a);
          paramAnonymousBundle.getHolder().addCallback(new SurfaceHolder.Callback()
          {
            public final void surfaceChanged(SurfaceHolder paramAnonymous2SurfaceHolder, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              c.displayChanged(1, paramAnonymous2SurfaceHolder.getSurface());
            }
            
            public final void surfaceCreated(SurfaceHolder paramAnonymous2SurfaceHolder)
            {
              c.displayChanged(1, paramAnonymous2SurfaceHolder.getSurface());
            }
            
            public final void surfaceDestroyed(SurfaceHolder paramAnonymous2SurfaceHolder)
            {
              c.displayChanged(1, null);
            }
          });
          setContentView(paramAnonymousBundle);
        }
        
        public final void onDisplayRemoved()
        {
          dismiss();
          synchronized (k.a(d))
          {
            k.a(d, null);
            return;
          }
        }
      });
      k.b(d).show();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.k.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */