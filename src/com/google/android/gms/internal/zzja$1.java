package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;

class zzja$1
  implements Runnable
{
  zzja$1(zzja paramzzja) {}
  
  public void run()
  {
    zzKi.zzoM.zzho();
    zzd localzzd = zzKi.zzoM.zzhc();
    if (localzzd != null) {
      localzzd.zzeG();
    }
    if (zzja.zzd(zzKi) != null)
    {
      zzja.zzd(zzKi).zzbf();
      zzja.zza(zzKi, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzja.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */