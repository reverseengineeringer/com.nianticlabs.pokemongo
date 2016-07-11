package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsi$zzb
  extends zzry<zzb>
{
  public String version;
  public int zzbiJ;
  public String zzbiK;
  
  public zzsi$zzb()
  {
    zzFT();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label54:
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          bool1 = bool2;
        } while (zzbiJ != zzbiJ);
        if (zzbiK != null) {
          break;
        }
        bool1 = bool2;
      } while (zzbiK != null);
      if (version != null) {
        break label124;
      }
      bool1 = bool2;
    } while (version != null);
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
        if (zzbiK.equals(zzbiK)) {
          break label54;
        }
        return false;
        label124:
        if (!version.equals(version)) {
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
    int i1 = zzbiJ;
    int i;
    int j;
    if (zzbiK == null)
    {
      i = 0;
      if (version != null) {
        break label101;
      }
      j = 0;
      label39:
      k = m;
      if (zzbik != null) {
        if (!zzbik.isEmpty()) {
          break label112;
        }
      }
    }
    label101:
    label112:
    for (int k = m;; k = zzbik.hashCode())
    {
      return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      i = zzbiK.hashCode();
      break;
      j = version.hashCode();
      break label39;
    }
  }
  
  protected int zzB()
  {
    int j = super.zzB();
    int i = j;
    if (zzbiJ != 0) {
      i = j + zzrx.zzA(1, zzbiJ);
    }
    j = i;
    if (!zzbiK.equals("")) {
      j = i + zzrx.zzn(2, zzbiK);
    }
    i = j;
    if (!version.equals("")) {
      i = j + zzrx.zzn(3, version);
    }
    return i;
  }
  
  public zzb zzFT()
  {
    zzbiJ = 0;
    zzbiK = "";
    version = "";
    zzbik = null;
    zzbiv = -1;
    return this;
  }
  
  public zzb zzH(zzrw paramzzrw)
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
      case 8: 
        i = paramzzrw.zzFr();
        switch (i)
        {
        default: 
          break;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
          zzbiJ = i;
        }
        break;
      case 18: 
        zzbiK = paramzzrw.readString();
        break;
      case 26: 
        version = paramzzrw.readString();
      }
    }
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    if (zzbiJ != 0) {
      paramzzrx.zzy(1, zzbiJ);
    }
    if (!zzbiK.equals("")) {
      paramzzrx.zzb(2, zzbiK);
    }
    if (!version.equals("")) {
      paramzzrx.zzb(3, version);
    }
    super.zza(paramzzrx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsi.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */