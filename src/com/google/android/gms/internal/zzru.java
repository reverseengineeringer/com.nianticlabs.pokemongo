package com.google.android.gms.internal;

import java.io.IOException;

public final class zzru
  extends zzry<zzru>
{
  public String[] zzbhU;
  public int[] zzbhV;
  public byte[][] zzbhW;
  
  public zzru()
  {
    zzFn();
  }
  
  public static zzru zzz(byte[] paramArrayOfByte)
    throws zzsd
  {
    return (zzru)zzse.zza(new zzru(), paramArrayOfByte);
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
            } while (!(paramObject instanceof zzru));
            paramObject = (zzru)paramObject;
            bool1 = bool2;
          } while (!zzsc.equals(zzbhU, zzbhU));
          bool1 = bool2;
        } while (!zzsc.equals(zzbhV, zzbhV));
        bool1 = bool2;
      } while (!zzsc.zza(zzbhW, zzbhW));
      if ((zzbik != null) && (!zzbik.isEmpty())) {
        break label111;
      }
      if (zzbik == null) {
        break;
      }
      bool1 = bool2;
    } while (!zzbik.isEmpty());
    return true;
    label111:
    return zzbik.equals(zzbik);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzsc.hashCode(zzbhU);
    int m = zzsc.hashCode(zzbhV);
    int n = zzsc.zza(zzbhW);
    if ((zzbik == null) || (zzbik.isEmpty())) {}
    for (int i = 0;; i = zzbik.hashCode()) {
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  protected int zzB()
  {
    int i1 = 0;
    int i2 = super.zzB();
    int i;
    int k;
    Object localObject;
    int n;
    int m;
    if ((zzbhU != null) && (zzbhU.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < zzbhU.length; k = m)
      {
        localObject = zzbhU[i];
        n = j;
        m = k;
        if (localObject != null)
        {
          m = k + 1;
          n = j + zzrx.zzfA((String)localObject);
        }
        i += 1;
        j = n;
      }
    }
    for (int j = i2 + j + k * 1;; j = i2)
    {
      i = j;
      if (zzbhV != null)
      {
        i = j;
        if (zzbhV.length > 0)
        {
          i = 0;
          k = 0;
          while (i < zzbhV.length)
          {
            k += zzrx.zzlJ(zzbhV[i]);
            i += 1;
          }
          i = j + k + zzbhV.length * 1;
        }
      }
      j = i;
      if (zzbhW != null)
      {
        j = i;
        if (zzbhW.length > 0)
        {
          k = 0;
          m = 0;
          j = i1;
          while (j < zzbhW.length)
          {
            localObject = zzbhW[j];
            i1 = k;
            n = m;
            if (localObject != null)
            {
              n = m + 1;
              i1 = k + zzrx.zzE((byte[])localObject);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      return j;
    }
  }
  
  public zzru zzE(zzrw paramzzrw)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzrw.zzFo();
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (zza(paramzzrw, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        j = zzsh.zzc(paramzzrw, 10);
        if (zzbhU == null) {}
        for (i = 0;; i = zzbhU.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbhU, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzrw.readString();
            paramzzrw.zzFo();
            j += 1;
          }
        }
        localObject[j] = paramzzrw.readString();
        zzbhU = ((String[])localObject);
        break;
      case 16: 
        j = zzsh.zzc(paramzzrw, 16);
        if (zzbhV == null) {}
        for (i = 0;; i = zzbhV.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbhV, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzrw.zzFr();
            paramzzrw.zzFo();
            j += 1;
          }
        }
        localObject[j] = paramzzrw.zzFr();
        zzbhV = ((int[])localObject);
        break;
      case 18: 
        int k = paramzzrw.zzlC(paramzzrw.zzFv());
        i = paramzzrw.getPosition();
        j = 0;
        while (paramzzrw.zzFA() > 0)
        {
          paramzzrw.zzFr();
          j += 1;
        }
        paramzzrw.zzlE(i);
        if (zzbhV == null) {}
        for (i = 0;; i = zzbhV.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbhV, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzrw.zzFr();
            j += 1;
          }
        }
        zzbhV = ((int[])localObject);
        paramzzrw.zzlD(k);
        break;
      case 26: 
        j = zzsh.zzc(paramzzrw, 26);
        if (zzbhW == null) {}
        for (i = 0;; i = zzbhW.length)
        {
          localObject = new byte[j + i][];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbhW, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzrw.readBytes();
            paramzzrw.zzFo();
            j += 1;
          }
        }
        localObject[j] = paramzzrw.readBytes();
        zzbhW = ((byte[][])localObject);
      }
    }
  }
  
  public zzru zzFn()
  {
    zzbhU = zzsh.zzbiC;
    zzbhV = zzsh.zzbix;
    zzbhW = zzsh.zzbiD;
    zzbik = null;
    zzbiv = -1;
    return this;
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    int j = 0;
    int i;
    Object localObject;
    if ((zzbhU != null) && (zzbhU.length > 0))
    {
      i = 0;
      while (i < zzbhU.length)
      {
        localObject = zzbhU[i];
        if (localObject != null) {
          paramzzrx.zzb(1, (String)localObject);
        }
        i += 1;
      }
    }
    if ((zzbhV != null) && (zzbhV.length > 0))
    {
      i = 0;
      while (i < zzbhV.length)
      {
        paramzzrx.zzy(2, zzbhV[i]);
        i += 1;
      }
    }
    if ((zzbhW != null) && (zzbhW.length > 0))
    {
      i = j;
      while (i < zzbhW.length)
      {
        localObject = zzbhW[i];
        if (localObject != null) {
          paramzzrx.zza(3, (byte[])localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzrx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzru
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */