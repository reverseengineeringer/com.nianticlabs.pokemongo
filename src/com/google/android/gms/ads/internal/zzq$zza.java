package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zziz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzq$zza
  extends ViewSwitcher
{
  private final zzif zzqQ;
  private final zzim zzqR;
  
  public zzq$zza(Context paramContext, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    super(paramContext);
    zzqQ = new zzif(paramContext);
    if ((paramContext instanceof Activity))
    {
      zzqR = new zzim((Activity)paramContext, paramOnGlobalLayoutListener, paramOnScrollChangedListener);
      zzqR.zzgO();
      return;
    }
    zzqR = null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (zzqR != null) {
      zzqR.onAttachedToWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (zzqR != null) {
      zzqR.onDetachedFromWindow();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    zzqQ.zze(paramMotionEvent);
    return false;
  }
  
  public void removeAllViews()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof zziz))) {
        ((List)localObject).add((zziz)localView);
      }
      i += 1;
    }
    super.removeAllViews();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((zziz)((Iterator)localObject).next()).destroy();
    }
  }
  
  public void zzbP()
  {
    zzb.v("Disable position monitoring on adFrame.");
    if (zzqR != null) {
      zzqR.zzgP();
    }
  }
  
  public zzif zzbT()
  {
    return zzqQ;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzq.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */