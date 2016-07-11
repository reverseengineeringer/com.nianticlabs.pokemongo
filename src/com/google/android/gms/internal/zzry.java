package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzry<M extends zzry<M>>
  extends zzse
{
  protected zzsa zzbik;
  
  protected int zzB()
  {
    int j = 0;
    if (zzbik != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= zzbik.size()) {
          break;
        }
        i += zzbik.zzlS(j).zzB();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public M zzFF()
    throws CloneNotSupportedException
  {
    zzry localzzry = (zzry)super.zzFG();
    zzsc.zza(this, localzzry);
    return localzzry;
  }
  
  public final <T> T zza(zzrz<M, T> paramzzrz)
  {
    if (zzbik == null) {}
    zzsb localzzsb;
    do
    {
      return null;
      localzzsb = zzbik.zzlR(zzsh.zzlV(tag));
    } while (localzzsb == null);
    return (T)localzzsb.zzb(paramzzrz);
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    if (zzbik == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < zzbik.size())
      {
        zzbik.zzlS(i).zza(paramzzrx);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzrw paramzzrw, int paramInt)
    throws IOException
  {
    int i = paramzzrw.getPosition();
    if (!paramzzrw.zzlA(paramInt)) {
      return false;
    }
    int j = zzsh.zzlV(paramInt);
    zzsg localzzsg = new zzsg(paramInt, paramzzrw.zzx(i, paramzzrw.getPosition() - i));
    paramzzrw = null;
    if (zzbik == null) {
      zzbik = new zzsa();
    }
    for (;;)
    {
      Object localObject = paramzzrw;
      if (paramzzrw == null)
      {
        localObject = new zzsb();
        zzbik.zza(j, (zzsb)localObject);
      }
      ((zzsb)localObject).zza(localzzsg);
      return true;
      paramzzrw = zzbik.zzlR(j);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */