package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import java.util.HashMap;
import java.util.Map;

@zzgr
public class zzdq
  implements zzdk
{
  static final Map<String, Integer> zzxS = new HashMap();
  private final zze zzxQ;
  private final zzfc zzxR;
  
  static
  {
    zzxS.put("resize", Integer.valueOf(1));
    zzxS.put("playVideo", Integer.valueOf(2));
    zzxS.put("storePicture", Integer.valueOf(3));
    zzxS.put("createCalendarEvent", Integer.valueOf(4));
    zzxS.put("setOrientationProperties", Integer.valueOf(5));
    zzxS.put("closeResizedAd", Integer.valueOf(6));
  }
  
  public zzdq(zze paramzze, zzfc paramzzfc)
  {
    zzxQ = paramzze;
    zzxR = paramzzfc;
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    int i = ((Integer)zzxS.get(str)).intValue();
    if ((i != 5) && (zzxQ != null) && (!zzxQ.zzbe()))
    {
      zzxQ.zzp(null);
      return;
    }
    switch (i)
    {
    case 2: 
    default: 
      zzb.zzaG("Unknown MRAID command called.");
      return;
    case 1: 
      zzxR.zzg(paramMap);
      return;
    case 4: 
      new zzfb(paramzziz, paramMap).execute();
      return;
    case 3: 
      new zzfe(paramzziz, paramMap).execute();
      return;
    case 5: 
      new zzfd(paramzziz, paramMap).execute();
      return;
    }
    zzxR.zzn(true);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */