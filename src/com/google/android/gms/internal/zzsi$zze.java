package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsi$zze
  extends zzry<zze>
{
  private static volatile zze[] zzbjf;
  public String key;
  public String value;
  
  public zzsi$zze()
  {
    zzFX();
  }
  
  public static zze[] zzFW()
  {
    if (zzbjf == null) {}
    synchronized (zzsc.zzbiu)
    {
      if (zzbjf == null) {
        zzbjf = new zze[0];
      }
      return zzbjf;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label41:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zze));
        paramObject = (zze)paramObject;
        if (key != null) {
          break;
        }
        bool1 = bool2;
      } while (key != null);
      if (value != null) {
        break label111;
      }
      bool1 = bool2;
    } while (value != null);
    for (;;)
    {
      if ((zzbik == null) || (zzbik.isEmpty()))
      {
        if (zzbik != null)
        {
          bool1 = bool2;
          if (!zzbik.isEmpty()) {
            break;
          }
        }
        return true;
        if (key.equals(key)) {
          break label41;
        }
        return false;
        label111:
        if (!value.equals(value)) {
          return false;
        }
      }
    }
    return zzbik.equals(zzbik);
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i;
    int j;
    if (key == null)
    {
      i = 0;
      if (value != null) {
        break label89;
      }
      j = 0;
      label33:
      k = m;
      if (zzbik != null) {
        if (!zzbik.isEmpty()) {
          break label100;
        }
      }
    }
    label89:
    label100:
    for (int k = m;; k = zzbik.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = key.hashCode();
      break;
      j = value.hashCode();
      break label33;
    }
  }
  
  protected int zzB()
  {
    int j = super.zzB();
    int i = j;
    if (!key.equals("")) {
      i = j + zzrx.zzn(1, key);
    }
    j = i;
    if (!value.equals("")) {
      j = i + zzrx.zzn(2, value);
    }
    return j;
  }
  
  public zze zzFX()
  {
    key = "";
    value = "";
    zzbik = null;
    zzbiv = -1;
    return this;
  }
  
  public zze zzK(zzrw paramzzrw)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzrw.zzFo();
      switch (i)
      {
      default: 
        if (zza(paramzzrw, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        key = paramzzrw.readString();
        break;
      case 18: 
        value = paramzzrw.readString();
      }
    }
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    if (!key.equals("")) {
      paramzzrx.zzb(1, key);
    }
    if (!value.equals("")) {
      paramzzrx.zzb(2, value);
    }
    super.zza(paramzzrx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsi.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */