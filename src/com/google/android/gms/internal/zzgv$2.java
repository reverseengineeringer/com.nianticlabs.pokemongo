package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

class zzgv$2
  implements zzdk
{
  zzgv$2(zzgv paramzzgv) {}
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    zzgx localzzgx;
    synchronized (zzgv.zza(zzFT))
    {
      if (zzgv.zzb(zzFT).isDone()) {
        return;
      }
      localzzgx = new zzgx(-2, paramMap);
      if (!zzgv.zzc(zzFT).equals(localzzgx.getRequestId()))
      {
        zzb.zzaH(localzzgx.getRequestId() + " ==== " + zzgv.zzc(zzFT));
        return;
      }
    }
    String str = localzzgx.getUrl();
    if (str == null)
    {
      zzb.zzaH("URL missing in loadAdUrl GMSG.");
      return;
    }
    if (str.contains("%40mediation_adapters%40"))
    {
      paramzziz = str.replaceAll("%40mediation_adapters%40", zzhy.zza(paramzziz.getContext(), (String)paramMap.get("check_adapters"), zzgv.zzd(zzFT)));
      localzzgx.setUrl(paramzziz);
      zzb.v("Ad request URL modified to " + paramzziz);
    }
    zzgv.zzb(zzFT).zzf(localzzgx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgv.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */