package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

public class zzik
{
  private long zzJk;
  private long zzJl = Long.MIN_VALUE;
  private Object zzpd = new Object();
  
  public zzik(long paramLong)
  {
    zzJk = paramLong;
  }
  
  public boolean tryAcquire()
  {
    synchronized (zzpd)
    {
      long l = zzp.zzbz().elapsedRealtime();
      if (zzJl + zzJk > l) {
        return false;
      }
      zzJl = l;
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzik
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */