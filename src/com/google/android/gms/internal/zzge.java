package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public class zzge
  extends zzgc
{
  private zzgd zzDt;
  
  zzge(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    super(paramContext, paramzza, paramzziz, paramzza1);
  }
  
  protected void zzfs()
  {
    Object localObject = zzoM.zzaN();
    int j;
    if (zztf)
    {
      localObject = mContext.getResources().getDisplayMetrics();
      j = widthPixels;
    }
    for (int i = heightPixels;; i = heightPixels)
    {
      zzDt = new zzgd(this, zzoM, j, i);
      zzoM.zzhe().zza(this);
      zzDt.zza(zzDf);
      return;
      j = widthPixels;
    }
  }
  
  protected int zzft()
  {
    if (zzDt.zzfx())
    {
      zzb.zzaF("Ad-Network indicated no fill with passback URL.");
      return 3;
    }
    if (!zzDt.zzfy()) {
      return 2;
    }
    return -2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */