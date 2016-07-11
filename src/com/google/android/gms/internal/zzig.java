package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public class zzig
{
  private final String[] zzIO;
  private final double[] zzIP;
  private final double[] zzIQ;
  private final int[] zzIR;
  private int zzIS;
  
  private zzig(zzb paramzzb)
  {
    int i = zzb.zza(paramzzb).size();
    zzIO = ((String[])zzb.zzb(paramzzb).toArray(new String[i]));
    zzIP = zzg(zzb.zza(paramzzb));
    zzIQ = zzg(zzb.zzc(paramzzb));
    zzIR = new int[i];
    zzIS = 0;
  }
  
  private double[] zzg(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public List<zza> getBuckets()
  {
    ArrayList localArrayList = new ArrayList(zzIO.length);
    int i = 0;
    while (i < zzIO.length)
    {
      localArrayList.add(new zza(zzIO[i], zzIQ[i], zzIP[i], zzIR[i] / zzIS, zzIR[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public void zza(double paramDouble)
  {
    zzIS += 1;
    int i = 0;
    for (;;)
    {
      if (i < zzIQ.length)
      {
        if ((zzIQ[i] <= paramDouble) && (paramDouble < zzIP[i]))
        {
          int[] arrayOfInt = zzIR;
          arrayOfInt[i] += 1;
        }
        if (paramDouble >= zzIQ[i]) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static class zza
  {
    public final int count;
    public final String name;
    public final double zzIT;
    public final double zzIU;
    public final double zzIV;
    
    public zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
    {
      name = paramString;
      zzIU = paramDouble1;
      zzIT = paramDouble2;
      zzIV = paramDouble3;
      count = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {}
      do
      {
        return false;
        paramObject = (zza)paramObject;
      } while ((!zzw.equal(name, name)) || (zzIT != zzIT) || (zzIU != zzIU) || (count != count) || (Double.compare(zzIV, zzIV) != 0));
      return true;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { name, Double.valueOf(zzIT), Double.valueOf(zzIU), Double.valueOf(zzIV), Integer.valueOf(count) });
    }
    
    public String toString()
    {
      return zzw.zzv(this).zzg("name", name).zzg("minBound", Double.valueOf(zzIU)).zzg("maxBound", Double.valueOf(zzIT)).zzg("percent", Double.valueOf(zzIV)).zzg("count", Integer.valueOf(count)).toString();
    }
  }
  
  public static class zzb
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */