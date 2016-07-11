package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class zzig$zza
{
  public final int count;
  public final String name;
  public final double zzIT;
  public final double zzIU;
  public final double zzIV;
  
  public zzig$zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzig.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */