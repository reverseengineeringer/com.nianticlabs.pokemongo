package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

public class zzie$zzf
  extends zzie.zzc
{
  public void zza(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      zza(paramActivity.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzie.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */