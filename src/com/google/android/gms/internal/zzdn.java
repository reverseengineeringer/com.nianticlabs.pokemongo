package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzgr
public class zzdn
  implements zzdk
{
  private final zzdo zzxO;
  
  public zzdn(zzdo paramzzdo)
  {
    zzxO = paramzzdo;
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") != null)
      {
        f = Float.parseFloat((String)paramMap.get("blurRadius"));
        zzxO.zzd(bool1);
        zzxO.zza(bool2, f);
        return;
      }
    }
    catch (NumberFormatException paramzziz)
    {
      for (;;)
      {
        zzb.zzb("Fail to parse float", paramzziz);
        float f = 0.0F;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */