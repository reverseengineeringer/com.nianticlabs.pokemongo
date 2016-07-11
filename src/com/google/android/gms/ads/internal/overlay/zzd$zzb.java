package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzif;

@zzgr
final class zzd$zzb
  extends RelativeLayout
{
  zzif zzqQ;
  
  public zzd$zzb(Context paramContext, String paramString)
  {
    super(paramContext);
    zzqQ = new zzif(paramContext, paramString);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    zzqQ.zze(paramMotionEvent);
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */