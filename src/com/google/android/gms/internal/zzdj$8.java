package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

final class zzdj$8
  implements zzdk
{
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("u");
    if (paramMap == null)
    {
      zzb.zzaH("URL missing from httpTrack GMSG.");
      return;
    }
    new zzij(paramzziz.getContext(), zzhhzzJu, paramMap).zzgz();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdj.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */