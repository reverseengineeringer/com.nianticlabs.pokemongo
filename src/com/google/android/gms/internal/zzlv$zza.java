package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;

public final class zzlv$zza
{
  public final int zzaeE;
  public final int zzaeF;
  
  public zzlv$zza(int paramInt1, int paramInt2)
  {
    zzaeE = paramInt1;
    zzaeF = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof zza)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      paramObject = (zza)paramObject;
      if (zzaeE != zzaeE) {
        break;
      }
      bool1 = bool2;
    } while (zzaeF == zzaeF);
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(zzaeE), Integer.valueOf(zzaeF) });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlv.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */