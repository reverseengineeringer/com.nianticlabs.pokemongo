package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzis.zzc;

class zzm$2$1
  implements zzis.zzc<zzbe>
{
  zzm$2$1(zzm.2 param2) {}
  
  public void zzb(zzbe paramzzbe)
  {
    try
    {
      paramzzbe.zza("AFMA_getAdapterLessMediationAd", zzFs.zzFq);
      return;
    }
    catch (Exception paramzzbe)
    {
      zzb.zzb("Error requesting an ad url", paramzzbe);
      zzm.zzfN().zzZ(zzFs.zzFr);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzm.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */