package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmx;

public class zzl
  implements zzj
{
  public zzi zza(Context paramContext, zziz paramzziz, int paramInt, zzcg paramzzcg, zzce paramzzce)
  {
    if (!zzmx.zzqx()) {
      return null;
    }
    return new zzc(paramContext, new zzp(paramContext, paramzziz.zzhh(), paramzziz.getRequestId(), paramzzcg, paramzzce));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */