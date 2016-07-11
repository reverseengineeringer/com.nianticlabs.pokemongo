package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsi$zza
  extends zzry<zza>
{
  public String[] zzbiF;
  public String[] zzbiG;
  public int[] zzbiH;
  public long[] zzbiI;
  
  public zzsi$zza()
  {
    zzFS();
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
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (!zzsc.equals(zzbiF, zzbiF));
            bool1 = bool2;
          } while (!zzsc.equals(zzbiG, zzbiG));
          bool1 = bool2;
        } while (!zzsc.equals(zzbiH, zzbiH));
        bool1 = bool2;
      } while (!zzsc.equals(zzbiI, zzbiI));
      if ((zzbik != null) && (!zzbik.isEmpty())) {
        break label127;
      }
      if (zzbik == null) {
        break;
      }
      bool1 = bool2;
    } while (!zzbik.isEmpty());
    return true;
    label127:
    return zzbik.equals(zzbik);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzsc.hashCode(zzbiF);
    int m = zzsc.hashCode(zzbiG);
    int n = zzsc.hashCode(zzbiH);
    int i1 = zzsc.hashCode(zzbiI);
    if ((zzbik == null) || (zzbik.isEmpty())) {}
    for (int i = 0;; i = zzbik.hashCode()) {
      return i + (((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
    }
  }
  
  protected int zzB()
  {
    int i2 = 0;
    int i1 = super.zzB();
    int j;
    int k;
    String str;
    int n;
    int m;
    if ((zzbiF != null) && (zzbiF.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < zzbiF.length; k = m)
      {
        str = zzbiF[i];
        n = j;
        m = k;
        if (str != null)
        {
          m = k + 1;
          n = j + zzrx.zzfA(str);
        }
        i += 1;
        j = n;
      }
    }
    for (int i = i1 + j + k * 1;; i = i1)
    {
      j = i;
      if (zzbiG != null)
      {
        j = i;
        if (zzbiG.length > 0)
        {
          j = 0;
          k = 0;
          for (m = 0; j < zzbiG.length; m = n)
          {
            str = zzbiG[j];
            i1 = k;
            n = m;
            if (str != null)
            {
              n = m + 1;
              i1 = k + zzrx.zzfA(str);
            }
            j += 1;
            k = i1;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (zzbiH != null)
      {
        i = j;
        if (zzbiH.length > 0)
        {
          i = 0;
          k = 0;
          while (i < zzbiH.length)
          {
            k += zzrx.zzlJ(zzbiH[i]);
            i += 1;
          }
          i = j + k + zzbiH.length * 1;
        }
      }
      j = i;
      if (zzbiI != null)
      {
        j = i;
        if (zzbiI.length > 0)
        {
          k = 0;
          j = i2;
          while (j < zzbiI.length)
          {
            k += zzrx.zzaa(zzbiI[j]);
            j += 1;
          }
          j = i + k + zzbiI.length * 1;
        }
      }
      return j;
    }
  }
  
  public zza zzFS()
  {
    zzbiF = zzsh.zzbiC;
    zzbiG = zzsh.zzbiC;
    zzbiH = zzsh.zzbix;
    zzbiI = zzsh.zzbiy;
    zzbik = null;
    zzbiv = -1;
    return this;
  }
  
  public zza zzG(zzrw paramzzrw)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzrw.zzFo();
      int j;
      Object localObject;
      int k;
      switch (i)
      {
      default: 
        if (zza(paramzzrw, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        j = zzsh.zzc(paramzzrw, 10);
        if (zzbiF == null) {}
        for (i = 0;; i = zzbiF.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiF, 0, localObject, 0, i);
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
        zzbiF = ((String[])localObject);
        break;
      case 18: 
        j = zzsh.zzc(paramzzrw, 18);
        if (zzbiG == null) {}
        for (i = 0;; i = zzbiG.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiG, 0, localObject, 0, i);
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
        zzbiG = ((String[])localObject);
        break;
      case 24: 
        j = zzsh.zzc(paramzzrw, 24);
        if (zzbiH == null) {}
        for (i = 0;; i = zzbiH.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiH, 0, localObject, 0, i);
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
        zzbiH = ((int[])localObject);
        break;
      case 26: 
        k = paramzzrw.zzlC(paramzzrw.zzFv());
        i = paramzzrw.getPosition();
        j = 0;
        while (paramzzrw.zzFA() > 0)
        {
          paramzzrw.zzFr();
          j += 1;
        }
        paramzzrw.zzlE(i);
        if (zzbiH == null) {}
        for (i = 0;; i = zzbiH.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiH, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzrw.zzFr();
            j += 1;
          }
        }
        zzbiH = ((int[])localObject);
        paramzzrw.zzlD(k);
        break;
      case 32: 
        j = zzsh.zzc(paramzzrw, 32);
        if (zzbiI == null) {}
        for (i = 0;; i = zzbiI.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiI, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzrw.zzFq();
            paramzzrw.zzFo();
            j += 1;
          }
        }
        localObject[j] = paramzzrw.zzFq();
        zzbiI = ((long[])localObject);
        break;
      case 34: 
        k = paramzzrw.zzlC(paramzzrw.zzFv());
        i = paramzzrw.getPosition();
        j = 0;
        while (paramzzrw.zzFA() > 0)
        {
          paramzzrw.zzFq();
          j += 1;
        }
        paramzzrw.zzlE(i);
        if (zzbiI == null) {}
        for (i = 0;; i = zzbiI.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiI, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzrw.zzFq();
            j += 1;
          }
        }
        zzbiI = ((long[])localObject);
        paramzzrw.zzlD(k);
      }
    }
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    int j = 0;
    int i;
    String str;
    if ((zzbiF != null) && (zzbiF.length > 0))
    {
      i = 0;
      while (i < zzbiF.length)
      {
        str = zzbiF[i];
        if (str != null) {
          paramzzrx.zzb(1, str);
        }
        i += 1;
      }
    }
    if ((zzbiG != null) && (zzbiG.length > 0))
    {
      i = 0;
      while (i < zzbiG.length)
      {
        str = zzbiG[i];
        if (str != null) {
          paramzzrx.zzb(2, str);
        }
        i += 1;
      }
    }
    if ((zzbiH != null) && (zzbiH.length > 0))
    {
      i = 0;
      while (i < zzbiH.length)
      {
        paramzzrx.zzy(3, zzbiH[i]);
        i += 1;
      }
    }
    if ((zzbiI != null) && (zzbiI.length > 0))
    {
      i = j;
      while (i < zzbiI.length)
      {
        paramzzrx.zzb(4, zzbiI[i]);
        i += 1;
      }
    }
    super.zza(paramzzrx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsi.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */