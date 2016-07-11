package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfd
{
  private final boolean zzAq;
  private final String zzAr;
  private final zziz zzoM;
  
  public zzfd(zziz paramzziz, Map<String, String> paramMap)
  {
    zzoM = paramzziz;
    zzAr = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      zzAq = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    zzAq = true;
  }
  
  public void execute()
  {
    if (zzoM == null)
    {
      zzb.zzaH("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(zzAr)) {
      i = zzp.zzbx().zzgH();
    }
    for (;;)
    {
      zzoM.setRequestedOrientation(i);
      return;
      if ("landscape".equalsIgnoreCase(zzAr)) {
        i = zzp.zzbx().zzgG();
      } else if (zzAq) {
        i = -1;
      } else {
        i = zzp.zzbx().zzgI();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */