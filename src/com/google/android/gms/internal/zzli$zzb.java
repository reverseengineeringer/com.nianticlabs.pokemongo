package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class zzli$zzb
{
  private final zzlj zzacy;
  
  protected zzli$zzb(zzlj paramzzlj)
  {
    zzacy = paramzzlj;
  }
  
  public final void zzg(zzli paramzzli)
  {
    zzli.zzb(paramzzli).lock();
    try
    {
      zzlj localzzlj1 = zzli.zzc(paramzzli);
      zzlj localzzlj2 = zzacy;
      if (localzzlj1 != localzzlj2) {
        return;
      }
      zznO();
      return;
    }
    finally
    {
      zzli.zzb(paramzzli).unlock();
    }
  }
  
  protected abstract void zznO();
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */