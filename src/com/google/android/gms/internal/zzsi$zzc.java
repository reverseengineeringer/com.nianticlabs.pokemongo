package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzsi$zzc
  extends zzry<zzc>
{
  public byte[] zzbiL;
  public byte[][] zzbiM;
  public boolean zzbiN;
  
  public zzsi$zzc()
  {
    zzFU();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
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
            } while (!(paramObject instanceof zzc));
            paramObject = (zzc)paramObject;
            bool1 = bool2;
          } while (!Arrays.equals(zzbiL, zzbiL));
          bool1 = bool2;
        } while (!zzsc.zza(zzbiM, zzbiM));
        bool1 = bool2;
      } while (zzbiN != zzbiN);
      if ((zzbik != null) && (!zzbik.isEmpty())) {
        break label108;
      }
      if (zzbik == null) {
        break;
      }
      bool1 = bool2;
    } while (!zzbik.isEmpty());
    return true;
    label108:
    return zzbik.equals(zzbik);
  }
  
  public int hashCode()
  {
    int k = getClass().getName().hashCode();
    int m = Arrays.hashCode(zzbiL);
    int n = zzsc.zza(zzbiM);
    int i;
    if (zzbiN)
    {
      i = 1231;
      if ((zzbik != null) && (!zzbik.isEmpty())) {
        break label94;
      }
    }
    label94:
    for (int j = 0;; j = zzbik.hashCode())
    {
      return j + (i + (((k + 527) * 31 + m) * 31 + n) * 31) * 31;
      i = 1237;
      break;
    }
  }
  
  protected int zzB()
  {
    int n = 0;
    int j = super.zzB();
    int i = j;
    if (!Arrays.equals(zzbiL, zzsh.zzbiE)) {
      i = j + zzrx.zzb(1, zzbiL);
    }
    j = i;
    if (zzbiM != null)
    {
      j = i;
      if (zzbiM.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < zzbiM.length)
        {
          byte[] arrayOfByte = zzbiM[j];
          int i1 = k;
          n = m;
          if (arrayOfByte != null)
          {
            n = m + 1;
            i1 = k + zzrx.zzE(arrayOfByte);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (zzbiN) {
      i = j + zzrx.zzc(3, zzbiN);
    }
    return i;
  }
  
  public zzc zzFU()
  {
    zzbiL = zzsh.zzbiE;
    zzbiM = zzsh.zzbiD;
    zzbiN = false;
    zzbik = null;
    zzbiv = -1;
    return this;
  }
  
  public zzc zzI(zzrw paramzzrw)
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
        zzbiL = paramzzrw.readBytes();
        break;
      case 18: 
        int j = zzsh.zzc(paramzzrw, 18);
        if (zzbiM == null) {}
        byte[][] arrayOfByte;
        for (i = 0;; i = zzbiM.length)
        {
          arrayOfByte = new byte[j + i][];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiM, 0, arrayOfByte, 0, i);
            j = i;
          }
          while (j < arrayOfByte.length - 1)
          {
            arrayOfByte[j] = paramzzrw.readBytes();
            paramzzrw.zzFo();
            j += 1;
          }
        }
        arrayOfByte[j] = paramzzrw.readBytes();
        zzbiM = arrayOfByte;
        break;
      case 24: 
        zzbiN = paramzzrw.zzFs();
      }
    }
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    if (!Arrays.equals(zzbiL, zzsh.zzbiE)) {
      paramzzrx.zza(1, zzbiL);
    }
    if ((zzbiM != null) && (zzbiM.length > 0))
    {
      int i = 0;
      while (i < zzbiM.length)
      {
        byte[] arrayOfByte = zzbiM[i];
        if (arrayOfByte != null) {
          paramzzrx.zza(2, arrayOfByte);
        }
        i += 1;
      }
    }
    if (zzbiN) {
      paramzzrx.zzb(3, zzbiN);
    }
    super.zza(paramzzrx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsi.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */