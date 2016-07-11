package com.google.android.gms.internal;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

class zzli$8
  implements Runnable
{
  zzli$8(zzli paramzzli, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    if ((zzacx.isFinishing()) || (zzacx.getSupportFragmentManager().isDestroyed())) {
      return;
    }
    zzlp.zzb(zzacx).zzbp(zzli.zzf(zzacr));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */