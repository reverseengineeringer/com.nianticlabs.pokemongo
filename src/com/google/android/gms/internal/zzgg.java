package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;

@zzgr
public class zzgg
{
  public zzgh zza(Context paramContext, zza paramzza, zzhs.zza paramzza1, zzan paramzzan, zziz paramzziz, zzem paramzzem, zza paramzza2, zzcg paramzzcg)
  {
    AdResponseParcel localAdResponseParcel = zzHD;
    if (zzEK) {
      paramContext = new zzgk(paramContext, paramzza1, paramzzem, paramzza2, paramzzcg);
    }
    for (;;)
    {
      zzb.zzaF("AdRenderer: " + paramContext.getClass().getName());
      paramContext.zzfu();
      return paramContext;
      if (zzth)
      {
        if ((paramzza instanceof zzn))
        {
          paramContext = new zzgl(paramContext, (zzn)paramzza, new zzbc(), paramzza1, paramzzan, paramzza2);
        }
        else
        {
          paramzza1 = new StringBuilder().append("Invalid NativeAdManager type. Found: ");
          if (paramzza != null) {}
          for (paramContext = paramzza.getClass().getName();; paramContext = "null") {
            throw new IllegalArgumentException(paramContext + "; Required: NativeAdManager.");
          }
        }
      }
      else if (zzEQ) {
        paramContext = new zzge(paramContext, paramzza1, paramzziz, paramzza2);
      } else if ((((Boolean)zzby.zzvb.get()).booleanValue()) && (zzmx.zzqB()) && (!zzmx.isAtLeastL()) && (zzaNzztf)) {
        paramContext = new zzgj(paramContext, paramzza1, paramzziz, paramzza2);
      } else {
        paramContext = new zzgi(paramContext, paramzza1, paramzziz, paramzza2);
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(zzhs paramzzhs);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */