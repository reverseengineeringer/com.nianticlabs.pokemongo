package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzgr
class zzdl$zzd
{
  private final String zzwq;
  private final String zzxF;
  private final int zzxM;
  private final List<zzdl.zza> zzxN;
  
  public zzdl$zzd(String paramString1, int paramInt, List<zzdl.zza> paramList, String paramString2)
  {
    zzxF = paramString1;
    zzxM = paramInt;
    if (paramList == null) {}
    for (zzxN = new ArrayList();; zzxN = paramList)
    {
      zzwq = paramString2;
      return;
    }
  }
  
  public String getBody()
  {
    return zzwq;
  }
  
  public int getResponseCode()
  {
    return zzxM;
  }
  
  public String zzdE()
  {
    return zzxF;
  }
  
  public Iterable<zzdl.zza> zzdJ()
  {
    return zzxN;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdl.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */