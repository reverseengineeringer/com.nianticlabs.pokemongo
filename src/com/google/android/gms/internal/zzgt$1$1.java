package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

class zzgt$1$1
  implements zzis.zzc<zzbe>
{
  zzgt$1$1(zzgt.1 param1, zzce paramzzce) {}
  
  public void zzb(zzbe paramzzbe)
  {
    zzFI.zzoD.zza(zzFH, new String[] { "jsf" });
    zzFI.zzoD.zzdo();
    paramzzbe.zza("/invalidRequest", zzFI.zzFE.zzFR);
    paramzzbe.zza("/loadAdURL", zzFI.zzFE.zzFS);
    try
    {
      paramzzbe.zza("AFMA_buildAdURL", zzFI.zzFG);
      return;
    }
    catch (Exception paramzzbe)
    {
      zzb.zzb("Error requesting an ad url", paramzzbe);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgt.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */