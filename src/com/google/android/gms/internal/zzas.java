package com.google.android.gms.internal;

import java.io.IOException;

class zzas
  implements zzaq
{
  private zzrx zznG;
  private byte[] zznH;
  private final int zznI;
  
  public zzas(int paramInt)
  {
    zznI = paramInt;
    reset();
  }
  
  public void reset()
  {
    zznH = new byte[zznI];
    zznG = zzrx.zzC(zznH);
  }
  
  public byte[] zzac()
    throws IOException
  {
    int i = zznG.zzFD();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return zznH;
    }
    byte[] arrayOfByte = new byte[zznH.length - i];
    System.arraycopy(zznH, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zznG.zzb(paramInt, paramLong);
  }
  
  public void zzb(int paramInt, String paramString)
    throws IOException
  {
    zznG.zzb(paramInt, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzas
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */