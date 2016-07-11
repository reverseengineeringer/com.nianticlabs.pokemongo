package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public class zzig$zzb
{
  private final List<String> zzIW = new ArrayList();
  private final List<Double> zzIX = new ArrayList();
  private final List<Double> zzIY = new ArrayList();
  
  public zzb zza(String paramString, double paramDouble1, double paramDouble2)
  {
    int i = 0;
    for (;;)
    {
      double d1;
      double d2;
      if (i < zzIW.size())
      {
        d1 = ((Double)zzIY.get(i)).doubleValue();
        d2 = ((Double)zzIX.get(i)).doubleValue();
        if (paramDouble1 >= d1) {
          break label107;
        }
      }
      label107:
      while ((d1 == paramDouble1) && (paramDouble2 < d2))
      {
        zzIW.add(i, paramString);
        zzIY.add(i, Double.valueOf(paramDouble1));
        zzIX.add(i, Double.valueOf(paramDouble2));
        return this;
      }
      i += 1;
    }
  }
  
  public zzig zzgK()
  {
    return new zzig(this, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzig.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */