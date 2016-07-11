package com.google.android.gms.internal;

import java.io.IOException;

public final class zzrw
{
  private final byte[] buffer;
  private int zzbia;
  private int zzbib;
  private int zzbic;
  private int zzbid;
  private int zzbie;
  private int zzbif = Integer.MAX_VALUE;
  private int zzbig;
  private int zzbih = 64;
  private int zzbii = 67108864;
  
  private zzrw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    buffer = paramArrayOfByte;
    zzbia = paramInt1;
    zzbib = (paramInt1 + paramInt2);
    zzbid = paramInt1;
  }
  
  public static zzrw zzB(byte[] paramArrayOfByte)
  {
    return zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void zzFz()
  {
    zzbib += zzbic;
    int i = zzbib;
    if (i > zzbif)
    {
      zzbic = (i - zzbif);
      zzbib -= zzbic;
      return;
    }
    zzbic = 0;
  }
  
  public static long zzX(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static zzrw zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzrw(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int zzlB(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public int getPosition()
  {
    return zzbid - zzbia;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = zzFv();
    if ((i <= zzbib - zzbid) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(buffer, zzbid, arrayOfByte, 0, i);
      zzbid = (i + zzbid);
      return arrayOfByte;
    }
    if (i == 0) {
      return zzsh.zzbiE;
    }
    return zzlF(i);
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzFy());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzFx());
  }
  
  public String readString()
    throws IOException
  {
    int i = zzFv();
    if ((i <= zzbib - zzbid) && (i > 0))
    {
      String str = new String(buffer, zzbid, i, "UTF-8");
      zzbid = (i + zzbid);
      return str;
    }
    return new String(zzlF(i), "UTF-8");
  }
  
  public int zzFA()
  {
    if (zzbif == Integer.MAX_VALUE) {
      return -1;
    }
    int i = zzbid;
    return zzbif - i;
  }
  
  public boolean zzFB()
  {
    return zzbid == zzbib;
  }
  
  public byte zzFC()
    throws IOException
  {
    if (zzbid == zzbib) {
      throw zzsd.zzFJ();
    }
    byte[] arrayOfByte = buffer;
    int i = zzbid;
    zzbid = (i + 1);
    return arrayOfByte[i];
  }
  
  public int zzFo()
    throws IOException
  {
    if (zzFB())
    {
      zzbie = 0;
      return 0;
    }
    zzbie = zzFv();
    if (zzbie == 0) {
      throw zzsd.zzFM();
    }
    return zzbie;
  }
  
  public void zzFp()
    throws IOException
  {
    int i;
    do
    {
      i = zzFo();
    } while ((i != 0) && (zzlA(i)));
  }
  
  public long zzFq()
    throws IOException
  {
    return zzFw();
  }
  
  public int zzFr()
    throws IOException
  {
    return zzFv();
  }
  
  public boolean zzFs()
    throws IOException
  {
    return zzFv() != 0;
  }
  
  public int zzFt()
    throws IOException
  {
    return zzlB(zzFv());
  }
  
  public long zzFu()
    throws IOException
  {
    return zzX(zzFw());
  }
  
  public int zzFv()
    throws IOException
  {
    int i = zzFC();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zzFC();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zzFC();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zzFC();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zzFC();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (zzFC() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zzsd.zzFL();
  }
  
  public long zzFw()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzFC();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzsd.zzFL();
  }
  
  public int zzFx()
    throws IOException
  {
    return zzFC() & 0xFF | (zzFC() & 0xFF) << 8 | (zzFC() & 0xFF) << 16 | (zzFC() & 0xFF) << 24;
  }
  
  public long zzFy()
    throws IOException
  {
    int i = zzFC();
    int j = zzFC();
    int k = zzFC();
    int m = zzFC();
    int n = zzFC();
    int i1 = zzFC();
    int i2 = zzFC();
    int i3 = zzFC();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public void zza(zzse paramzzse)
    throws IOException
  {
    int i = zzFv();
    if (zzbig >= zzbih) {
      throw zzsd.zzFP();
    }
    i = zzlC(i);
    zzbig += 1;
    paramzzse.zzb(this);
    zzlz(0);
    zzbig -= 1;
    zzlD(i);
  }
  
  public void zza(zzse paramzzse, int paramInt)
    throws IOException
  {
    if (zzbig >= zzbih) {
      throw zzsd.zzFP();
    }
    zzbig += 1;
    paramzzse.zzb(this);
    zzlz(zzsh.zzD(paramInt, 4));
    zzbig -= 1;
  }
  
  public boolean zzlA(int paramInt)
    throws IOException
  {
    switch (zzsh.zzlU(paramInt))
    {
    default: 
      throw zzsd.zzFO();
    case 0: 
      zzFr();
      return true;
    case 1: 
      zzFy();
      return true;
    case 2: 
      zzlG(zzFv());
      return true;
    case 3: 
      zzFp();
      zzlz(zzsh.zzD(zzsh.zzlV(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zzFx();
    return true;
  }
  
  public int zzlC(int paramInt)
    throws zzsd
  {
    if (paramInt < 0) {
      throw zzsd.zzFK();
    }
    paramInt = zzbid + paramInt;
    int i = zzbif;
    if (paramInt > i) {
      throw zzsd.zzFJ();
    }
    zzbif = paramInt;
    zzFz();
    return i;
  }
  
  public void zzlD(int paramInt)
  {
    zzbif = paramInt;
    zzFz();
  }
  
  public void zzlE(int paramInt)
  {
    if (paramInt > zzbid - zzbia) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (zzbid - zzbia));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    zzbid = (zzbia + paramInt);
  }
  
  public byte[] zzlF(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzsd.zzFK();
    }
    if (zzbid + paramInt > zzbif)
    {
      zzlG(zzbif - zzbid);
      throw zzsd.zzFJ();
    }
    if (paramInt <= zzbib - zzbid)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(buffer, zzbid, arrayOfByte, 0, paramInt);
      zzbid += paramInt;
      return arrayOfByte;
    }
    throw zzsd.zzFJ();
  }
  
  public void zzlG(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzsd.zzFK();
    }
    if (zzbid + paramInt > zzbif)
    {
      zzlG(zzbif - zzbid);
      throw zzsd.zzFJ();
    }
    if (paramInt <= zzbib - zzbid)
    {
      zzbid += paramInt;
      return;
    }
    throw zzsd.zzFJ();
  }
  
  public void zzlz(int paramInt)
    throws zzsd
  {
    if (zzbie != paramInt) {
      throw zzsd.zzFN();
    }
  }
  
  public byte[] zzx(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzsh.zzbiE;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = zzbia;
    System.arraycopy(buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */