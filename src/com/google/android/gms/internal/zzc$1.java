package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

class zzc$1
  implements Runnable
{
  zzc$1(zzc paramzzc, zzk paramzzk) {}
  
  public void run()
  {
    try
    {
      zzc.zza(zzn).put(zzm);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */