package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzp;

public final class zzim
{
  private Activity zzJn;
  private boolean zzJo;
  private boolean zzJp;
  private boolean zzJq;
  private ViewTreeObserver.OnGlobalLayoutListener zzJr;
  private ViewTreeObserver.OnScrollChangedListener zzJs;
  
  public zzim(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    zzJn = paramActivity;
    zzJr = paramOnGlobalLayoutListener;
    zzJs = paramOnScrollChangedListener;
  }
  
  private void zzgQ()
  {
    if (zzJn == null) {}
    while (zzJo) {
      return;
    }
    if (zzJr != null) {
      zzp.zzbv().zza(zzJn, zzJr);
    }
    if (zzJs != null) {
      zzp.zzbv().zza(zzJn, zzJs);
    }
    zzJo = true;
  }
  
  private void zzgR()
  {
    if (zzJn == null) {}
    while (!zzJo) {
      return;
    }
    if (zzJr != null) {
      zzp.zzbx().zzb(zzJn, zzJr);
    }
    if (zzJs != null) {
      zzp.zzbv().zzb(zzJn, zzJs);
    }
    zzJo = false;
  }
  
  public void onAttachedToWindow()
  {
    zzJp = true;
    if (zzJq) {
      zzgQ();
    }
  }
  
  public void onDetachedFromWindow()
  {
    zzJp = false;
    zzgR();
  }
  
  public void zzgO()
  {
    zzJq = true;
    if (zzJp) {
      zzgQ();
    }
  }
  
  public void zzgP()
  {
    zzJq = false;
    zzgR();
  }
  
  public void zzk(Activity paramActivity)
  {
    zzJn = paramActivity;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */