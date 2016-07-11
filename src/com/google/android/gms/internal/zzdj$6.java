package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

final class zzdj$6
  implements zzdk
{
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    paramMap = paramzziz.zzhc();
    if (paramMap != null)
    {
      paramMap.close();
      return;
    }
    paramzziz = paramzziz.zzhd();
    if (paramzziz != null)
    {
      paramzziz.close();
      return;
    }
    zzb.zzaH("A GMSG tried to close something that wasn't an overlay.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdj.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */