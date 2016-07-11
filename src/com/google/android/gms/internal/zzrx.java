package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzrx
{
  private final ByteBuffer zzbij;
  
  private zzrx(ByteBuffer paramByteBuffer)
  {
    zzbij = paramByteBuffer;
    zzbij.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzrx(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static int zzA(int paramInt1, int paramInt2)
  {
    return zzlM(paramInt1) + zzlJ(paramInt2);
  }
  
  public static int zzB(int paramInt1, int paramInt2)
  {
    return zzlM(paramInt1) + zzlK(paramInt2);
  }
  
  public static zzrx zzC(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzE(byte[] paramArrayOfByte)
  {
    return zzlO(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  private static int zza(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label442;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label442:
      if ((55296 <= i) && (i <= 57343) && ((paramInt2 + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2 + 1))))) {
        throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt2);
      }
      throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    zzb(paramCharSequence, paramByteBuffer);
  }
  
  public static int zzaa(long paramLong)
  {
    return zzad(paramLong);
  }
  
  public static int zzab(long paramLong)
  {
    return zzad(zzaf(paramLong));
  }
  
  public static int zzad(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static long zzaf(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int zzav(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzlM(paramInt) + zzk(paramDouble);
  }
  
  public static int zzb(int paramInt, zzse paramzzse)
  {
    return zzlM(paramInt) * 2 + zzd(paramzzse);
  }
  
  public static int zzb(int paramInt, byte[] paramArrayOfByte)
  {
    return zzlM(paramInt) + zzE(paramArrayOfByte);
  }
  
  public static zzrx zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzrx(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException("Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static int zzc(int paramInt, float paramFloat)
  {
    return zzlM(paramInt) + zzj(paramFloat);
  }
  
  public static int zzc(int paramInt, zzse paramzzse)
  {
    return zzlM(paramInt) + zze(paramzzse);
  }
  
  public static int zzc(int paramInt, boolean paramBoolean)
  {
    return zzlM(paramInt) + zzav(paramBoolean);
  }
  
  private static int zzc(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < '')) {
      i += 1;
    }
    for (;;)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + zza(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m) {
          throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (k + 4294967296L));
        }
        return k;
        j = i;
        i = m;
      }
    }
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzlM(paramInt) + zzaa(paramLong);
  }
  
  public static int zzd(zzse paramzzse)
  {
    return paramzzse.zzFR();
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzlM(paramInt) + zzab(paramLong);
  }
  
  public static int zze(zzse paramzzse)
  {
    int i = paramzzse.zzFR();
    return i + zzlO(i);
  }
  
  public static int zzfA(String paramString)
  {
    int i = zzc(paramString);
    return i + zzlO(i);
  }
  
  public static int zzj(float paramFloat)
  {
    return 4;
  }
  
  public static int zzk(double paramDouble)
  {
    return 8;
  }
  
  public static int zzlJ(int paramInt)
  {
    if (paramInt >= 0) {
      return zzlO(paramInt);
    }
    return 10;
  }
  
  public static int zzlK(int paramInt)
  {
    return zzlO(zzlQ(paramInt));
  }
  
  public static int zzlM(int paramInt)
  {
    return zzlO(zzsh.zzD(paramInt, 0));
  }
  
  public static int zzlO(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzlQ(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int zzn(int paramInt, String paramString)
  {
    return zzlM(paramInt) + zzfA(paramString);
  }
  
  public void zzC(int paramInt1, int paramInt2)
    throws IOException
  {
    zzlN(zzsh.zzD(paramInt1, paramInt2));
  }
  
  public void zzD(byte[] paramArrayOfByte)
    throws IOException
  {
    zzlN(paramArrayOfByte.length);
    zzF(paramArrayOfByte);
  }
  
  public void zzF(byte[] paramArrayOfByte)
    throws IOException
  {
    zzc(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int zzFD()
  {
    return zzbij.remaining();
  }
  
  public void zzFE()
  {
    if (zzFD() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void zzY(long paramLong)
    throws IOException
  {
    zzac(paramLong);
  }
  
  public void zzZ(long paramLong)
    throws IOException
  {
    zzac(zzaf(paramLong));
  }
  
  public void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzC(paramInt, 1);
    zzj(paramDouble);
  }
  
  public void zza(int paramInt, zzse paramzzse)
    throws IOException
  {
    zzC(paramInt, 2);
    zzc(paramzzse);
  }
  
  public void zza(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzC(paramInt, 2);
    zzD(paramArrayOfByte);
  }
  
  public void zzac(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzlL((int)paramLong);
        return;
      }
      zzlL((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void zzae(long paramLong)
    throws IOException
  {
    if (zzbij.remaining() < 8) {
      throw new zza(zzbij.position(), zzbij.limit());
    }
    zzbij.putLong(paramLong);
  }
  
  public void zzau(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zzlL(i);
      return;
    }
  }
  
  public void zzb(byte paramByte)
    throws IOException
  {
    if (!zzbij.hasRemaining()) {
      throw new zza(zzbij.position(), zzbij.limit());
    }
    zzbij.put(paramByte);
  }
  
  public void zzb(int paramInt, float paramFloat)
    throws IOException
  {
    zzC(paramInt, 5);
    zzi(paramFloat);
  }
  
  public void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zzC(paramInt, 0);
    zzY(paramLong);
  }
  
  public void zzb(int paramInt, String paramString)
    throws IOException
  {
    zzC(paramInt, 2);
    zzfz(paramString);
  }
  
  public void zzb(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzC(paramInt, 0);
    zzau(paramBoolean);
  }
  
  public void zzb(zzse paramzzse)
    throws IOException
  {
    paramzzse.zza(this);
  }
  
  public void zzc(int paramInt, long paramLong)
    throws IOException
  {
    zzC(paramInt, 0);
    zzZ(paramLong);
  }
  
  public void zzc(zzse paramzzse)
    throws IOException
  {
    zzlN(paramzzse.zzFQ());
    paramzzse.zza(this);
  }
  
  public void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (zzbij.remaining() >= paramInt2)
    {
      zzbij.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new zza(zzbij.position(), zzbij.limit());
  }
  
  public void zzfz(String paramString)
    throws IOException
  {
    int i;
    int j;
    try
    {
      i = zzlO(paramString.length());
      if (i != zzlO(paramString.length() * 3)) {
        break label150;
      }
      j = zzbij.position();
      if (zzbij.remaining() < i) {
        throw new zza(i + j, zzbij.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      zza localzza = new zza(zzbij.position(), zzbij.limit());
      localzza.initCause(paramString);
      throw localzza;
    }
    zzbij.position(j + i);
    zza(paramString, zzbij);
    int k = zzbij.position();
    zzbij.position(j);
    zzlN(k - j - i);
    zzbij.position(k);
    return;
    label150:
    zzlN(zzc(paramString));
    zza(paramString, zzbij);
  }
  
  public void zzi(float paramFloat)
    throws IOException
  {
    zzlP(Float.floatToIntBits(paramFloat));
  }
  
  public void zzj(double paramDouble)
    throws IOException
  {
    zzae(Double.doubleToLongBits(paramDouble));
  }
  
  public void zzlH(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      zzlN(paramInt);
      return;
    }
    zzac(paramInt);
  }
  
  public void zzlI(int paramInt)
    throws IOException
  {
    zzlN(zzlQ(paramInt));
  }
  
  public void zzlL(int paramInt)
    throws IOException
  {
    zzb((byte)paramInt);
  }
  
  public void zzlN(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzlL(paramInt);
        return;
      }
      zzlL(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void zzlP(int paramInt)
    throws IOException
  {
    if (zzbij.remaining() < 4) {
      throw new zza(zzbij.position(), zzbij.limit());
    }
    zzbij.putInt(paramInt);
  }
  
  public void zzy(int paramInt1, int paramInt2)
    throws IOException
  {
    zzC(paramInt1, 0);
    zzlH(paramInt2);
  }
  
  public void zzz(int paramInt1, int paramInt2)
    throws IOException
  {
    zzC(paramInt1, 0);
    zzlI(paramInt2);
  }
  
  public static class zza
    extends IOException
  {
    zza(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */