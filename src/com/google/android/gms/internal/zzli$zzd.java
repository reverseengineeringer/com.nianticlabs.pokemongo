package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class zzli$zzd
  extends zzll
{
  private WeakReference<zzli> zzacC;
  
  zzli$zzd(zzli paramzzli)
  {
    zzacC = new WeakReference(paramzzli);
  }
  
  public void zzoi()
  {
    zzli localzzli = (zzli)zzacC.get();
    if (localzzli == null) {
      return;
    }
    zzli.zzd(localzzli);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */