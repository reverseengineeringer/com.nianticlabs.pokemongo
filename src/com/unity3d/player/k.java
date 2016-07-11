package com.unity3d.player;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public final class k
  implements g
{
  private Object a = new Object[0];
  private Presentation b;
  private DisplayManager.DisplayListener c;
  
  public final void a(Context paramContext)
  {
    if (c == null) {}
    do
    {
      return;
      paramContext = (DisplayManager)paramContext.getSystemService("display");
    } while (paramContext == null);
    paramContext.unregisterDisplayListener(c);
  }
  
  public final void a(final UnityPlayer paramUnityPlayer, Context paramContext)
  {
    paramContext = (DisplayManager)paramContext.getSystemService("display");
    if (paramContext == null) {
      return;
    }
    paramContext.registerDisplayListener(new DisplayManager.DisplayListener()
    {
      public final void onDisplayAdded(int paramAnonymousInt)
      {
        paramUnityPlayer.displayChanged(-1, null);
      }
      
      public final void onDisplayChanged(int paramAnonymousInt)
      {
        paramUnityPlayer.displayChanged(-1, null);
      }
      
      public final void onDisplayRemoved(int paramAnonymousInt)
      {
        paramUnityPlayer.displayChanged(-1, null);
      }
    }, null);
  }
  
  public final boolean a(final UnityPlayer paramUnityPlayer, final Context paramContext, int paramInt)
  {
    synchronized (a)
    {
      if ((b != null) && (b.isShowing()))
      {
        localObject2 = b.getDisplay();
        if ((localObject2 != null) && (((Display)localObject2).getDisplayId() == paramInt)) {
          return true;
        }
      }
      final Object localObject2 = (DisplayManager)paramContext.getSystemService("display");
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((DisplayManager)localObject2).getDisplay(paramInt);
      if (localObject2 == null) {
        return false;
      }
      paramUnityPlayer.b(new Runnable()
      {
        public final void run()
        {
          synchronized (k.a(k.this))
          {
            if (k.b(k.this) != null) {
              k.b(k.this).dismiss();
            }
            k.a(k.this, new Presentation(paramContext, localObject2)
            {
              protected final void onCreate(Bundle paramAnonymous2Bundle)
              {
                paramAnonymous2Bundle = new SurfaceView(a);
                paramAnonymous2Bundle.getHolder().addCallback(new SurfaceHolder.Callback()
                {
                  public final void surfaceChanged(SurfaceHolder paramAnonymous3SurfaceHolder, int paramAnonymous3Int1, int paramAnonymous3Int2, int paramAnonymous3Int3)
                  {
                    c.displayChanged(1, paramAnonymous3SurfaceHolder.getSurface());
                  }
                  
                  public final void surfaceCreated(SurfaceHolder paramAnonymous3SurfaceHolder)
                  {
                    c.displayChanged(1, paramAnonymous3SurfaceHolder.getSurface());
                  }
                  
                  public final void surfaceDestroyed(SurfaceHolder paramAnonymous3SurfaceHolder)
                  {
                    c.displayChanged(1, null);
                  }
                });
                setContentView(paramAnonymous2Bundle);
              }
              
              public final void onDisplayRemoved()
              {
                dismiss();
                synchronized (k.a(k.this))
                {
                  k.a(k.this, null);
                  return;
                }
              }
            });
            k.b(k.this).show();
            return;
          }
        }
      });
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */