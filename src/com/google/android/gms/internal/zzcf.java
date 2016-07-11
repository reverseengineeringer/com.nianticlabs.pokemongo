package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class zzcf
{
  private final zzcg zzoo;
  private final Map<String, zzce> zzvQ;
  
  public zzcf(zzcg paramzzcg)
  {
    zzoo = paramzzcg;
    zzvQ = new HashMap();
  }
  
  public void zza(String paramString, zzce paramzzce)
  {
    zzvQ.put(paramString, paramzzce);
  }
  
  public void zza(String paramString1, String paramString2, long paramLong)
  {
    zzcc.zza(zzoo, (zzce)zzvQ.get(paramString2), paramLong, new String[] { paramString1 });
    zzvQ.put(paramString1, zzcc.zza(zzoo, paramLong));
  }
  
  public zzcg zzdm()
  {
    return zzoo;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */