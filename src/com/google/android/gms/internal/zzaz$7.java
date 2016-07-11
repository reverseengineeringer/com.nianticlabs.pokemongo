package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

class zzaz$7
  implements zzdk
{
  zzaz$7(zzaz paramzzaz) {}
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    if (!zzrw.zzb(paramMap)) {
      return;
    }
    zzb.zzaF("Received request to untrack: " + zzaz.zzb(zzrw).zzbX());
    zzrw.destroy();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaz.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */