package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgr
public class zzin<T>
  implements zziq<T>
{
  private final zzir zzJA = new zzir();
  private T zzJy = null;
  private boolean zzJz = false;
  private final Object zzpd = new Object();
  private boolean zzzD = false;
  
  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    synchronized (zzpd)
    {
      if (zzJz) {
        return false;
      }
    }
    zzzD = true;
    zzJz = true;
    zzpd.notifyAll();
    zzJA.zzgV();
    return true;
  }
  
  public T get()
  {
    synchronized (zzpd)
    {
      boolean bool = zzJz;
      if (bool) {}
    }
    try
    {
      zzpd.wait();
      if (zzzD)
      {
        throw new CancellationException("CallbackFuture was cancelled.");
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      Object localObject3 = zzJy;
      return (T)localObject3;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    synchronized (zzpd)
    {
      boolean bool = zzJz;
      if (!bool) {}
      try
      {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong != 0L) {
          zzpd.wait(paramLong);
        }
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;) {}
      }
      if (!zzJz) {
        throw new TimeoutException("CallbackFuture timed out.");
      }
    }
    if (zzzD) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    paramTimeUnit = zzJy;
    return paramTimeUnit;
  }
  
  public boolean isCancelled()
  {
    synchronized (zzpd)
    {
      boolean bool = zzzD;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (zzpd)
    {
      boolean bool = zzJz;
      return bool;
    }
  }
  
  public void zzc(Runnable paramRunnable)
  {
    zzJA.zzc(paramRunnable);
  }
  
  public void zzd(Runnable paramRunnable)
  {
    zzJA.zzd(paramRunnable);
  }
  
  public void zzf(T paramT)
  {
    synchronized (zzpd)
    {
      if (zzzD) {
        return;
      }
      if (zzJz) {
        throw new IllegalStateException("Provided CallbackFuture with multiple values.");
      }
    }
    zzJz = true;
    zzJy = paramT;
    zzpd.notifyAll();
    zzJA.zzgV();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */