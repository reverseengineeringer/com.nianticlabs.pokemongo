package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsh
{
  public static final double[] zzbiA = new double[0];
  public static final boolean[] zzbiB = new boolean[0];
  public static final String[] zzbiC = new String[0];
  public static final byte[][] zzbiD = new byte[0][];
  public static final byte[] zzbiE = new byte[0];
  public static final int[] zzbix = new int[0];
  public static final long[] zzbiy = new long[0];
  public static final float[] zzbiz = new float[0];
  
  static int zzD(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static boolean zzb(zzrw paramzzrw, int paramInt)
    throws IOException
  {
    return paramzzrw.zzlA(paramInt);
  }
  
  public static final int zzc(zzrw paramzzrw, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = paramzzrw.getPosition();
    paramzzrw.zzlA(paramInt);
    while (paramzzrw.zzFo() == paramInt)
    {
      paramzzrw.zzlA(paramInt);
      i += 1;
    }
    paramzzrw.zzlE(j);
    return i;
  }
  
  static int zzlU(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int zzlV(int paramInt)
  {
    return paramInt >>> 3;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */