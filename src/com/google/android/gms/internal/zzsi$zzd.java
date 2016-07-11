package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzsi$zzd
  extends zzry<zzd>
{
  public String tag;
  public long zzbiO;
  public long zzbiP;
  public int zzbiQ;
  public int zzbiR;
  public boolean zzbiS;
  public zzsi.zze[] zzbiT;
  public zzsi.zzb zzbiU;
  public byte[] zzbiV;
  public byte[] zzbiW;
  public byte[] zzbiX;
  public zzsi.zza zzbiY;
  public String zzbiZ;
  public long zzbja;
  public zzsi.zzc zzbjb;
  public byte[] zzbjc;
  public int zzbjd;
  public int[] zzbje;
  
  public zzsi$zzd()
  {
    zzFV();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label69:
    label140:
    label204:
    label220:
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
                                  } while (!(paramObject instanceof zzd));
                                  paramObject = (zzd)paramObject;
                                  bool1 = bool2;
                                } while (zzbiO != zzbiO);
                                bool1 = bool2;
                              } while (zzbiP != zzbiP);
                              if (tag != null) {
                                break;
                              }
                              bool1 = bool2;
                            } while (tag != null);
                            bool1 = bool2;
                          } while (zzbiQ != zzbiQ);
                          bool1 = bool2;
                        } while (zzbiR != zzbiR);
                        bool1 = bool2;
                      } while (zzbiS != zzbiS);
                      bool1 = bool2;
                    } while (!zzsc.equals(zzbiT, zzbiT));
                    if (zzbiU != null) {
                      break label349;
                    }
                    bool1 = bool2;
                  } while (zzbiU != null);
                  bool1 = bool2;
                } while (!Arrays.equals(zzbiV, zzbiV));
                bool1 = bool2;
              } while (!Arrays.equals(zzbiW, zzbiW));
              bool1 = bool2;
            } while (!Arrays.equals(zzbiX, zzbiX));
            if (zzbiY != null) {
              break label365;
            }
            bool1 = bool2;
          } while (zzbiY != null);
          if (zzbiZ != null) {
            break label381;
          }
          bool1 = bool2;
        } while (zzbiZ != null);
        bool1 = bool2;
      } while (zzbja != zzbja);
      if (zzbjb != null) {
        break label397;
      }
      bool1 = bool2;
    } while (zzbjb != null);
    label349:
    label365:
    label381:
    label397:
    while (zzbjb.equals(zzbjb))
    {
      bool1 = bool2;
      if (!Arrays.equals(zzbjc, zzbjc)) {
        break;
      }
      bool1 = bool2;
      if (zzbjd != zzbjd) {
        break;
      }
      bool1 = bool2;
      if (!zzsc.equals(zzbje, zzbje)) {
        break;
      }
      if ((zzbik != null) && (!zzbik.isEmpty())) {
        break label413;
      }
      if (zzbik != null)
      {
        bool1 = bool2;
        if (!zzbik.isEmpty()) {
          break;
        }
      }
      return true;
      if (tag.equals(tag)) {
        break label69;
      }
      return false;
      if (zzbiU.equals(zzbiU)) {
        break label140;
      }
      return false;
      if (zzbiY.equals(zzbiY)) {
        break label204;
      }
      return false;
      if (zzbiZ.equals(zzbiZ)) {
        break label220;
      }
      return false;
    }
    return false;
    label413:
    return zzbik.equals(zzbik);
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i4 = getClass().getName().hashCode();
    int i5 = (int)(zzbiO ^ zzbiO >>> 32);
    int i6 = (int)(zzbiP ^ zzbiP >>> 32);
    int i;
    int i7;
    int i8;
    int j;
    label77:
    int i9;
    int k;
    label95:
    int i10;
    int i11;
    int i12;
    int m;
    label132:
    int n;
    label142:
    int i13;
    int i1;
    label167:
    int i14;
    int i15;
    int i16;
    if (tag == null)
    {
      i = 0;
      i7 = zzbiQ;
      i8 = zzbiR;
      if (!zzbiS) {
        break label345;
      }
      j = 1231;
      i9 = zzsc.hashCode(zzbiT);
      if (zzbiU != null) {
        break label352;
      }
      k = 0;
      i10 = Arrays.hashCode(zzbiV);
      i11 = Arrays.hashCode(zzbiW);
      i12 = Arrays.hashCode(zzbiX);
      if (zzbiY != null) {
        break label363;
      }
      m = 0;
      if (zzbiZ != null) {
        break label375;
      }
      n = 0;
      i13 = (int)(zzbja ^ zzbja >>> 32);
      if (zzbjb != null) {
        break label387;
      }
      i1 = 0;
      i14 = Arrays.hashCode(zzbjc);
      i15 = zzbjd;
      i16 = zzsc.hashCode(zzbje);
      i2 = i3;
      if (zzbik != null) {
        if (!zzbik.isEmpty()) {
          break label399;
        }
      }
    }
    label345:
    label352:
    label363:
    label375:
    label387:
    label399:
    for (int i2 = i3;; i2 = zzbik.hashCode())
    {
      return ((((i1 + ((n + (m + ((((k + ((j + (((i + (((i4 + 527) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31) * 31 + i9) * 31) * 31 + i10) * 31 + i11) * 31 + i12) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i2;
      i = tag.hashCode();
      break;
      j = 1237;
      break label77;
      k = zzbiU.hashCode();
      break label95;
      m = zzbiY.hashCode();
      break label132;
      n = zzbiZ.hashCode();
      break label142;
      i1 = zzbjb.hashCode();
      break label167;
    }
  }
  
  protected int zzB()
  {
    int m = 0;
    int i = super.zzB();
    int j = i;
    if (zzbiO != 0L) {
      j = i + zzrx.zzd(1, zzbiO);
    }
    i = j;
    if (!tag.equals("")) {
      i = j + zzrx.zzn(2, tag);
    }
    j = i;
    if (zzbiT != null)
    {
      j = i;
      if (zzbiT.length > 0)
      {
        j = 0;
        while (j < zzbiT.length)
        {
          zzsi.zze localzze = zzbiT[j];
          k = i;
          if (localzze != null) {
            k = i + zzrx.zzc(3, localzze);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!Arrays.equals(zzbiV, zzsh.zzbiE)) {
      i = j + zzrx.zzb(6, zzbiV);
    }
    j = i;
    if (zzbiY != null) {
      j = i + zzrx.zzc(7, zzbiY);
    }
    i = j;
    if (!Arrays.equals(zzbiW, zzsh.zzbiE)) {
      i = j + zzrx.zzb(8, zzbiW);
    }
    j = i;
    if (zzbiU != null) {
      j = i + zzrx.zzc(9, zzbiU);
    }
    i = j;
    if (zzbiS) {
      i = j + zzrx.zzc(10, zzbiS);
    }
    j = i;
    if (zzbiQ != 0) {
      j = i + zzrx.zzA(11, zzbiQ);
    }
    i = j;
    if (zzbiR != 0) {
      i = j + zzrx.zzA(12, zzbiR);
    }
    j = i;
    if (!Arrays.equals(zzbiX, zzsh.zzbiE)) {
      j = i + zzrx.zzb(13, zzbiX);
    }
    i = j;
    if (!zzbiZ.equals("")) {
      i = j + zzrx.zzn(14, zzbiZ);
    }
    j = i;
    if (zzbja != 180000L) {
      j = i + zzrx.zze(15, zzbja);
    }
    i = j;
    if (zzbjb != null) {
      i = j + zzrx.zzc(16, zzbjb);
    }
    j = i;
    if (zzbiP != 0L) {
      j = i + zzrx.zzd(17, zzbiP);
    }
    int k = j;
    if (!Arrays.equals(zzbjc, zzsh.zzbiE)) {
      k = j + zzrx.zzb(18, zzbjc);
    }
    i = k;
    if (zzbjd != 0) {
      i = k + zzrx.zzA(19, zzbjd);
    }
    j = i;
    if (zzbje != null)
    {
      j = i;
      if (zzbje.length > 0)
      {
        k = 0;
        j = m;
        while (j < zzbje.length)
        {
          k += zzrx.zzlJ(zzbje[j]);
          j += 1;
        }
        j = i + k + zzbje.length * 2;
      }
    }
    return j;
  }
  
  public zzd zzFV()
  {
    zzbiO = 0L;
    zzbiP = 0L;
    tag = "";
    zzbiQ = 0;
    zzbiR = 0;
    zzbiS = false;
    zzbiT = zzsi.zze.zzFW();
    zzbiU = null;
    zzbiV = zzsh.zzbiE;
    zzbiW = zzsh.zzbiE;
    zzbiX = zzsh.zzbiE;
    zzbiY = null;
    zzbiZ = "";
    zzbja = 180000L;
    zzbjb = null;
    zzbjc = zzsh.zzbiE;
    zzbjd = 0;
    zzbje = zzsh.zzbix;
    zzbik = null;
    zzbiv = -1;
    return this;
  }
  
  public zzd zzJ(zzrw paramzzrw)
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
      case 8: 
        zzbiO = paramzzrw.zzFq();
        break;
      case 18: 
        tag = paramzzrw.readString();
        break;
      case 26: 
        j = zzsh.zzc(paramzzrw, 26);
        if (zzbiT == null) {}
        for (i = 0;; i = zzbiT.length)
        {
          localObject = new zzsi.zze[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbiT, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzsi.zze();
            paramzzrw.zza(localObject[j]);
            paramzzrw.zzFo();
            j += 1;
          }
        }
        localObject[j] = new zzsi.zze();
        paramzzrw.zza(localObject[j]);
        zzbiT = ((zzsi.zze[])localObject);
        break;
      case 50: 
        zzbiV = paramzzrw.readBytes();
        break;
      case 58: 
        if (zzbiY == null) {
          zzbiY = new zzsi.zza();
        }
        paramzzrw.zza(zzbiY);
        break;
      case 66: 
        zzbiW = paramzzrw.readBytes();
        break;
      case 74: 
        if (zzbiU == null) {
          zzbiU = new zzsi.zzb();
        }
        paramzzrw.zza(zzbiU);
        break;
      case 80: 
        zzbiS = paramzzrw.zzFs();
        break;
      case 88: 
        zzbiQ = paramzzrw.zzFr();
        break;
      case 96: 
        zzbiR = paramzzrw.zzFr();
        break;
      case 106: 
        zzbiX = paramzzrw.readBytes();
        break;
      case 114: 
        zzbiZ = paramzzrw.readString();
        break;
      case 120: 
        zzbja = paramzzrw.zzFu();
        break;
      case 130: 
        if (zzbjb == null) {
          zzbjb = new zzsi.zzc();
        }
        paramzzrw.zza(zzbjb);
        break;
      case 136: 
        zzbiP = paramzzrw.zzFq();
        break;
      case 146: 
        zzbjc = paramzzrw.readBytes();
        break;
      case 152: 
        i = paramzzrw.zzFr();
        switch (i)
        {
        default: 
          break;
        case 0: 
        case 1: 
        case 2: 
          zzbjd = i;
        }
        break;
      case 160: 
        j = zzsh.zzc(paramzzrw, 160);
        if (zzbje == null) {}
        for (i = 0;; i = zzbje.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbje, 0, localObject, 0, i);
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
        zzbje = ((int[])localObject);
        break;
      case 162: 
        int k = paramzzrw.zzlC(paramzzrw.zzFv());
        i = paramzzrw.getPosition();
        j = 0;
        while (paramzzrw.zzFA() > 0)
        {
          paramzzrw.zzFr();
          j += 1;
        }
        paramzzrw.zzlE(i);
        if (zzbje == null) {}
        for (i = 0;; i = zzbje.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbje, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzrw.zzFr();
            j += 1;
          }
        }
        zzbje = ((int[])localObject);
        paramzzrw.zzlD(k);
      }
    }
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    int j = 0;
    if (zzbiO != 0L) {
      paramzzrx.zzb(1, zzbiO);
    }
    if (!tag.equals("")) {
      paramzzrx.zzb(2, tag);
    }
    int i;
    if ((zzbiT != null) && (zzbiT.length > 0))
    {
      i = 0;
      while (i < zzbiT.length)
      {
        zzsi.zze localzze = zzbiT[i];
        if (localzze != null) {
          paramzzrx.zza(3, localzze);
        }
        i += 1;
      }
    }
    if (!Arrays.equals(zzbiV, zzsh.zzbiE)) {
      paramzzrx.zza(6, zzbiV);
    }
    if (zzbiY != null) {
      paramzzrx.zza(7, zzbiY);
    }
    if (!Arrays.equals(zzbiW, zzsh.zzbiE)) {
      paramzzrx.zza(8, zzbiW);
    }
    if (zzbiU != null) {
      paramzzrx.zza(9, zzbiU);
    }
    if (zzbiS) {
      paramzzrx.zzb(10, zzbiS);
    }
    if (zzbiQ != 0) {
      paramzzrx.zzy(11, zzbiQ);
    }
    if (zzbiR != 0) {
      paramzzrx.zzy(12, zzbiR);
    }
    if (!Arrays.equals(zzbiX, zzsh.zzbiE)) {
      paramzzrx.zza(13, zzbiX);
    }
    if (!zzbiZ.equals("")) {
      paramzzrx.zzb(14, zzbiZ);
    }
    if (zzbja != 180000L) {
      paramzzrx.zzc(15, zzbja);
    }
    if (zzbjb != null) {
      paramzzrx.zza(16, zzbjb);
    }
    if (zzbiP != 0L) {
      paramzzrx.zzb(17, zzbiP);
    }
    if (!Arrays.equals(zzbjc, zzsh.zzbiE)) {
      paramzzrx.zza(18, zzbjc);
    }
    if (zzbjd != 0) {
      paramzzrx.zzy(19, zzbjd);
    }
    if ((zzbje != null) && (zzbje.length > 0))
    {
      i = j;
      while (i < zzbje.length)
      {
        paramzzrx.zzy(20, zzbje[i]);
        i += 1;
      }
    }
    super.zza(paramzzrx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsi.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */