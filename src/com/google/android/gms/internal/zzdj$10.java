package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

final class zzdj$10
  implements zzdk
{
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("tx");
    String str2 = (String)paramMap.get("ty");
    paramMap = (String)paramMap.get("td");
    try
    {
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      int k = Integer.parseInt(paramMap);
      paramzziz = paramzziz.zzhg();
      if (paramzziz != null) {
        paramzziz.zzab().zza(i, j, k);
      }
      return;
    }
    catch (NumberFormatException paramzziz)
    {
      zzb.zzaH("Could not parse touch parameters from gmsg.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdj.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */