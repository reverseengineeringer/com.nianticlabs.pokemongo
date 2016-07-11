package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

public class zziy
{
  private final Context mContext;
  private zzk zzCo;
  private final ViewGroup zzJT;
  private final zziz zzoM;
  
  public zziy(Context paramContext, ViewGroup paramViewGroup, zziz paramzziz)
  {
    this(paramContext, paramViewGroup, paramzziz, null);
  }
  
  zziy(Context paramContext, ViewGroup paramViewGroup, zziz paramzziz, zzk paramzzk)
  {
    mContext = paramContext;
    zzJT = paramViewGroup;
    zzoM = paramzziz;
    zzCo = paramzzk;
  }
  
  public void onDestroy()
  {
    zzx.zzci("onDestroy must be called from the UI thread.");
    if (zzCo != null) {
      zzCo.destroy();
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (zzCo != null) {
      return;
    }
    zzcc.zza(zzoM.zzhn().zzdm(), zzoM.zzhm(), new String[] { "vpr" });
    zzce localzzce = zzcc.zzb(zzoM.zzhn().zzdm());
    zzCo = new zzk(mContext, zzoM, paramInt5, zzoM.zzhn().zzdm(), localzzce);
    zzJT.addView(zzCo, 0, new ViewGroup.LayoutParams(-1, -1));
    zzCo.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    zzoM.zzhe().zzF(false);
  }
  
  public void zze(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzx.zzci("The underlay may only be modified from the UI thread.");
    if (zzCo != null) {
      zzCo.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public zzk zzgX()
  {
    zzx.zzci("getAdVideoUnderlay must be called from the UI thread.");
    return zzCo;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */