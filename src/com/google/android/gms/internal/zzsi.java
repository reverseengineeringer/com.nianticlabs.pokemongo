package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zzsi
{
  public static final class zza
    extends zzry<zza>
  {
    public String[] zzbiF;
    public String[] zzbiG;
    public int[] zzbiH;
    public long[] zzbiI;
    
    public zza()
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
  
  public static final class zzb
    extends zzry<zzb>
  {
    public String version;
    public int zzbiJ;
    public String zzbiK;
    
    public zzb()
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
  
  public static final class zzc
    extends zzry<zzc>
  {
    public byte[] zzbiL;
    public byte[][] zzbiM;
    public boolean zzbiN;
    
    public zzc()
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
  
  public static final class zzd
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
    
    public zzd()
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
  
  public static final class zze
    extends zzry<zze>
  {
    private static volatile zze[] zzbjf;
    public String key;
    public String value;
    
    public zze()
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */