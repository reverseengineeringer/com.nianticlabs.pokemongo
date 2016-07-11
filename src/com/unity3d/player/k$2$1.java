package com.unity3d.player;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

final class k$2$1
  extends Presentation
{
  k$2$1(k.2 param2, Context paramContext, Display paramDisplay)
  {
    super(paramContext, paramDisplay);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    paramBundle = new SurfaceView(a.a);
    paramBundle.getHolder().addCallback(new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        a.c.displayChanged(1, paramAnonymousSurfaceHolder.getSurface());
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        a.c.displayChanged(1, paramAnonymousSurfaceHolder.getSurface());
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        a.c.displayChanged(1, null);
      }
    });
    setContentView(paramBundle);
  }
  
  public final void onDisplayRemoved()
  {
    dismiss();
    synchronized (k.a(a.d))
    {
      k.a(a.d, null);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.k.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */