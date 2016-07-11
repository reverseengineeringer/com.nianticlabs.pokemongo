package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

class zzdz$1$2
  implements zzdk
{
  zzdz$1$2(zzdz.1 param1, zzbb paramzzbb) {}
  
  public void zza(zziz arg1, Map<String, String> paramMap)
  {
    synchronized (zzdz.zzc(zzyw.zzyu))
    {
      if ((zzyw.zzyt.getStatus() == -1) || (zzyw.zzyt.getStatus() == 1)) {
        return;
      }
      zzdz.zza(zzyw.zzyu, 0);
      zzdz.zzd(zzyw.zzyu).zzc(zzyv);
      zzyw.zzyt.zzg(zzyv);
      zzdz.zza(zzyw.zzyu, zzyw.zzyt);
      zzb.v("Successfully loaded JS Engine.");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */