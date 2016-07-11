package com.google.android.gms.internal;

public class zzrv
{
  private final byte[] zzbhX = new byte['Ā'];
  private int zzbhY;
  private int zzbhZ;
  
  public zzrv(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      zzbhX[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + zzbhX[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = zzbhX[j];
      zzbhX[j] = zzbhX[k];
      zzbhX[k] = i;
      j += 1;
    }
    zzbhY = 0;
    zzbhZ = 0;
  }
  
  public void zzA(byte[] paramArrayOfByte)
  {
    int m = zzbhY;
    int k = zzbhZ;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + zzbhX[m] & 0xFF;
      int i = zzbhX[m];
      zzbhX[m] = zzbhX[k];
      zzbhX[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ zzbhX[(zzbhX[m] + zzbhX[k] & 0xFF)]));
      j += 1;
    }
    zzbhY = m;
    zzbhZ = k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */