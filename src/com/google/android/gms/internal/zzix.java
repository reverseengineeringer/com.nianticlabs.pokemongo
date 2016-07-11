package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class zzix
{
  private final WeakReference<View> zzJS;
  
  public zzix(View paramView)
  {
    zzJS = new WeakReference(paramView);
  }
  
  public final void detach()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null) {
      zzb(localViewTreeObserver);
    }
  }
  
  protected ViewTreeObserver getViewTreeObserver()
  {
    Object localObject = (View)zzJS.get();
    if (localObject == null) {
      localObject = null;
    }
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return (ViewTreeObserver)localObject;
      localViewTreeObserver = ((View)localObject).getViewTreeObserver();
      if (localViewTreeObserver == null) {
        break;
      }
      localObject = localViewTreeObserver;
    } while (localViewTreeObserver.isAlive());
    return null;
  }
  
  protected abstract void zza(ViewTreeObserver paramViewTreeObserver);
  
  protected abstract void zzb(ViewTreeObserver paramViewTreeObserver);
  
  public final void zzgW()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null) {
      zza(localViewTreeObserver);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */