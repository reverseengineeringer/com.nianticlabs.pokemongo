package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

final class zzgt$1
  implements Runnable
{
  zzgt$1(zzdz paramzzdz, zzgv paramzzgv, zzcg paramzzcg, zzce paramzzce, String paramString) {}
  
  public void run()
  {
    zzdz.zzd localzzd = zzFD.zzdO();
    zzFE.zzb(localzzd);
    zzoD.zza(zzFF, new String[] { "rwc" });
    localzzd.zza(new zzis.zzc()new zzis.zza
    {
      public void zzb(zzbe paramAnonymouszzbe)
      {
        zzoD.zza(zzFH, new String[] { "jsf" });
        zzoD.zzdo();
        paramAnonymouszzbe.zza("/invalidRequest", zzFE.zzFR);
        paramAnonymouszzbe.zza("/loadAdURL", zzFE.zzFS);
        try
        {
          paramAnonymouszzbe.zza("AFMA_buildAdURL", zzFG);
          return;
        }
        catch (Exception paramAnonymouszzbe)
        {
          zzb.zzb("Error requesting an ad url", paramAnonymouszzbe);
        }
      }
    }, new zzis.zza()
    {
      public void run() {}
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgt.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */