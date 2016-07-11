package com.google.android.gms.internal;

import java.util.Map;
import java.util.Set;

class zzja$zzd
  implements zzdk
{
  private zzja$zzd(zzja paramzzja) {}
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    if (paramMap.keySet().contains("start")) {
      zzja.zza(zzKi);
    }
    do
    {
      return;
      if (paramMap.keySet().contains("stop"))
      {
        zzja.zzb(zzKi);
        return;
      }
    } while (!paramMap.keySet().contains("cancel"));
    zzja.zzc(zzKi);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzja.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */