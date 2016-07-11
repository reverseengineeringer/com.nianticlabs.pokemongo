package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class AdvertisingIdClient$zza
  extends Thread
{
  private WeakReference<AdvertisingIdClient> zzoi;
  private long zzoj;
  CountDownLatch zzok;
  boolean zzol;
  
  public AdvertisingIdClient$zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
  {
    zzoi = new WeakReference(paramAdvertisingIdClient);
    zzoj = paramLong;
    zzok = new CountDownLatch(1);
    zzol = false;
    start();
  }
  
  private void disconnect()
  {
    AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)zzoi.get();
    if (localAdvertisingIdClient != null)
    {
      localAdvertisingIdClient.finish();
      zzol = true;
    }
  }
  
  public void cancel()
  {
    zzok.countDown();
  }
  
  public void run()
  {
    try
    {
      if (!zzok.await(zzoj, TimeUnit.MILLISECONDS)) {
        disconnect();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      disconnect();
    }
  }
  
  public boolean zzaK()
  {
    return zzol;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */