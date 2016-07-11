package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

public class zzii
{
  private Handler mHandler = null;
  private HandlerThread zzJh = null;
  private int zzJi = 0;
  private final Object zzpd = new Object();
  
  public Looper zzgM()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzJi == 0)
        {
          if (zzJh == null)
          {
            zzb.v("Starting the looper thread.");
            zzJh = new HandlerThread("LooperProvider");
            zzJh.start();
            mHandler = new Handler(zzJh.getLooper());
            zzb.v("Looper thread started.");
            zzJi += 1;
            Looper localLooper = zzJh.getLooper();
            return localLooper;
          }
          zzb.v("Resuming the looper thread");
          zzpd.notifyAll();
        }
      }
      zzx.zzb(zzJh, "Invalid state: mHandlerThread should already been initialized.");
    }
  }
  
  public void zzgN()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzJi > 0)
        {
          bool = true;
          zzx.zzb(bool, "Invalid state: release() called more times than expected.");
          int i = zzJi - 1;
          zzJi = i;
          if (i == 0) {
            mHandler.post(new Runnable()
            {
              public void run()
              {
                synchronized (zzii.zza(zzii.this))
                {
                  zzb.v("Suspending the looper thread");
                  for (;;)
                  {
                    int i = zzii.zzb(zzii.this);
                    if (i == 0) {
                      try
                      {
                        zzii.zza(zzii.this).wait();
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
            });
          }
          return;
        }
      }
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */