package com.google.android.gms.ads.internal.client;

import java.util.Random;

public class zzm
  extends zzv.zza
{
  private Object zzpd = new Object();
  private final Random zzts = new Random();
  private long zztt;
  
  public zzm()
  {
    zzcL();
  }
  
  public long getValue()
  {
    return zztt;
  }
  
  public void zzcL()
  {
    Object localObject1 = zzpd;
    int i = 3;
    long l1 = 0L;
    for (;;)
    {
      int j = i - 1;
      if (j > 0) {}
      try
      {
        long l2 = zzts.nextInt() + 2147483648L;
        l1 = l2;
        i = j;
        if (l2 == zztt) {
          continue;
        }
        l1 = l2;
        i = j;
        if (l2 == 0L) {
          continue;
        }
        l1 = l2;
        zztt = l1;
        return;
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */