package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public class zzgj
  extends zzgi
{
  private Object zzDw = new Object();
  private PopupWindow zzDx;
  private boolean zzDy = false;
  
  zzgj(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    super(paramContext, paramzza, paramzziz, paramzza1);
  }
  
  private void zzfA()
  {
    synchronized (zzDw)
    {
      zzDy = true;
      if (((mContext instanceof Activity)) && (((Activity)mContext).isDestroyed())) {
        zzDx = null;
      }
      if (zzDx != null)
      {
        if (zzDx.isShowing()) {
          zzDx.dismiss();
        }
        zzDx = null;
      }
      return;
    }
  }
  
  public void cancel()
  {
    zzfA();
    super.cancel();
  }
  
  protected void zzfz()
  {
    if ((mContext instanceof Activity)) {}
    Object localObject2;
    for (Window localWindow = ((Activity)mContext).getWindow();; localObject2 = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null)) {}
      while (((Activity)mContext).isDestroyed()) {
        return;
      }
      FrameLayout localFrameLayout = new FrameLayout(mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(zzoM.getView(), -1, -1);
      synchronized (zzDw)
      {
        if (zzDy) {
          return;
        }
      }
      zzDx = new PopupWindow(localFrameLayout, 1, 1, false);
      zzDx.setOutsideTouchable(true);
      zzDx.setClippingEnabled(false);
      zzb.zzaF("Displaying the 1x1 popup off the screen.");
      try
      {
        zzDx.showAtLocation(((Window)localObject1).getDecorView(), 0, -1, -1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          zzDx = null;
        }
      }
    }
  }
  
  protected void zzz(int paramInt)
  {
    zzfA();
    super.zzz(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */