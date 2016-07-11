package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

class zzgv$1
  implements zzdk
{
  zzgv$1(zzgv paramzzgv) {}
  
  public void zza(zziz arg1, Map<String, String> paramMap)
  {
    synchronized (zzgv.zza(zzFT))
    {
      if (zzgv.zzb(zzFT).isDone()) {
        return;
      }
      if (!zzgv.zzc(zzFT).equals(paramMap.get("request_id"))) {
        return;
      }
    }
    paramMap = new zzgx(1, paramMap);
    zzb.zzaH("Invalid " + paramMap.getType() + " request error: " + paramMap.zzfU());
    zzgv.zzb(zzFT).zzf(paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgv.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */