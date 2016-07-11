package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

class zziv
  extends zzix
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zzJR;
  
  public zziv(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    super(paramView);
    zzJR = new WeakReference(paramOnGlobalLayoutListener);
  }
  
  public void onGlobalLayout()
  {
    ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener)zzJR.get();
    if (localOnGlobalLayoutListener != null)
    {
      localOnGlobalLayoutListener.onGlobalLayout();
      return;
    }
    detach();
  }
  
  protected void zza(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnGlobalLayoutListener(this);
  }
  
  protected void zzb(ViewTreeObserver paramViewTreeObserver)
  {
    zzp.zzbx().zza(paramViewTreeObserver, this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */