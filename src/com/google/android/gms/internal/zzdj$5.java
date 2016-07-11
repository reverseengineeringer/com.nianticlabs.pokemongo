package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

final class zzdj$5
  implements zzdk
{
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    str = (String)paramMap.get("u");
    if (str == null)
    {
      zzb.zzaH("URL missing from click GMSG.");
      return;
    }
    paramMap = Uri.parse(str);
    try
    {
      Object localObject = paramzziz.zzhg();
      if ((localObject == null) || (!((zzan)localObject).zzb(paramMap))) {
        break label120;
      }
      localObject = ((zzan)localObject).zza(paramMap, paramzziz.getContext());
      paramMap = (Map<String, String>)localObject;
    }
    catch (zzao localzzao)
    {
      for (;;)
      {
        zzb.zzaH("Unable to append parameter to URL: " + str);
      }
    }
    paramMap = paramMap.toString();
    new zzij(paramzziz.getContext(), zzhhzzJu, paramMap).zzgz();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdj.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */