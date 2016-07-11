package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

class zziw
  extends zzix
  implements ViewTreeObserver.OnScrollChangedListener
{
  private final WeakReference<ViewTreeObserver.OnScrollChangedListener> zzJR;
  
  public zziw(View paramView, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    super(paramView);
    zzJR = new WeakReference(paramOnScrollChangedListener);
  }
  
  public void onScrollChanged()
  {
    ViewTreeObserver.OnScrollChangedListener localOnScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener)zzJR.get();
    if (localOnScrollChangedListener != null)
    {
      localOnScrollChangedListener.onScrollChanged();
      return;
    }
    detach();
  }
  
  protected void zza(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnScrollChangedListener(this);
  }
  
  protected void zzb(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.removeOnScrollChangedListener(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */