package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzdw
  implements zzdk
{
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    zzdu localzzdu = zzp.zzbI();
    if (paramMap.containsKey("abort"))
    {
      if (!localzzdu.zza(paramzziz)) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache abort but no preload task running.");
      }
      return;
    }
    String str = (String)paramMap.get("src");
    if (str == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      i = Integer.parseInt((String)paramMap.get("player"));
      if (paramMap.containsKey("mimetype"))
      {
        paramMap = (String)paramMap.get("mimetype");
        if (!localzzdu.zzb(paramzziz)) {
          break label121;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache task already running.");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      for (;;)
      {
        i = 0;
        continue;
        paramMap = "";
      }
      label121:
      com.google.android.gms.common.internal.zzb.zzs(paramzziz.zzhb());
      new zzdt(paramzziz, zzhbzzoG.zza(paramzziz, i, paramMap), str).zzgz();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */