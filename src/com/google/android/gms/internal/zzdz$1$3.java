package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

class zzdz$1$3
  implements zzdk
{
  zzdz$1$3(zzdz.1 param1, zzbb paramzzbb, zzil paramzzil) {}
  
  public void zza(zziz arg1, Map<String, String> paramMap)
  {
    synchronized (zzdz.zzc(zzyw.zzyu))
    {
      zzb.zzaG("JS Engine is requesting an update");
      if (zzdz.zze(zzyw.zzyu) == 0)
      {
        zzb.zzaG("Starting reload.");
        zzdz.zza(zzyw.zzyu, 2);
        zzyw.zzyu.zzdN();
      }
      zzyv.zzb("/requestReload", (zzdk)zzyz.get());
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.1.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */