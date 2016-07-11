package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzse
{
  protected volatile int zzbiv = -1;
  
  public static final <T extends zzse> T zza(T paramT, byte[] paramArrayOfByte)
    throws zzsd
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void zza(zzse paramzzse, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzrx.zzb(paramArrayOfByte, paramInt1, paramInt2);
      paramzzse.zza(paramArrayOfByte);
      paramArrayOfByte.zzFE();
      return;
    }
    catch (IOException paramzzse)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzse);
    }
  }
  
  public static final <T extends zzse> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzsd
  {
    try
    {
      paramArrayOfByte = zzrw.zza(paramArrayOfByte, paramInt1, paramInt2);
      paramT.zzb(paramArrayOfByte);
      paramArrayOfByte.zzlz(0);
      return paramT;
    }
    catch (zzsd paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] zzf(zzse paramzzse)
  {
    byte[] arrayOfByte = new byte[paramzzse.zzFR()];
    zza(paramzzse, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return zzsf.zzg(this);
  }
  
  protected int zzB()
  {
    return 0;
  }
  
  public zzse zzFG()
    throws CloneNotSupportedException
  {
    return (zzse)super.clone();
  }
  
  public int zzFQ()
  {
    if (zzbiv < 0) {
      zzFR();
    }
    return zzbiv;
  }
  
  public int zzFR()
  {
    int i = zzB();
    zzbiv = i;
    return i;
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {}
  
  public abstract zzse zzb(zzrw paramzzrw)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */