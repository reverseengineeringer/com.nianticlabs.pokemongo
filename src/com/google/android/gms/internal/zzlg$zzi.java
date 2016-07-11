package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class zzlg$zzi
  implements Runnable
{
  private zzlg$zzi(zzlg paramzzlg) {}
  
  public void run()
  {
    zzlg.zzc(zzabL).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      zznO();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzlg.zzd(zzabL).zza(localRuntimeException);
      return;
    }
    finally
    {
      zzlg.zzc(zzabL).unlock();
    }
  }
  
  protected abstract void zznO();
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */