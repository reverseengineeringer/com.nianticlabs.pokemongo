package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zziz;
import java.util.Map;

public class zzm$zzc
  implements zzdk
{
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    paramzziz = (String)paramMap.get("request_id");
    paramMap = (String)paramMap.get("errors");
    zzb.zzaH("Invalid request: " + paramMap);
    zzm.zzfN().zzZ(paramzziz);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzm.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */