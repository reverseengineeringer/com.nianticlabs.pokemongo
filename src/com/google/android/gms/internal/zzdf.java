package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzgr
public final class zzdf
  implements zzdk
{
  private final zzdg zzxn;
  
  public zzdf(zzdg paramzzdg)
  {
    zzxn = paramzzdg;
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    paramzziz = (String)paramMap.get("name");
    if (paramzziz == null)
    {
      zzb.zzaH("App event with no name parameter.");
      return;
    }
    zzxn.onAppEvent(paramzziz, (String)paramMap.get("info"));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */