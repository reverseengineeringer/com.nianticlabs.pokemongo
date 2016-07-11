package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

class zzii$1
  implements Runnable
{
  zzii$1(zzii paramzzii) {}
  
  public void run()
  {
    synchronized (zzii.zza(zzJj))
    {
      zzb.v("Suspending the looper thread");
      for (;;)
      {
        int i = zzii.zzb(zzJj);
        if (i == 0) {
          try
          {
            zzii.zza(zzJj).wait();
            zzb.v("Looper thread resumed");
          }
          catch (InterruptedException localInterruptedException)
          {
            zzb.v("Looper thread interrupted.");
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzii.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */