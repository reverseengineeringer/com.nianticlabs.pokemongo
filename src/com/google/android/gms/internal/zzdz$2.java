package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

class zzdz$2
  implements zzis.zzc<zzbb>
{
  zzdz$2(zzdz paramzzdz, zzdz.zze paramzze) {}
  
  public void zza(zzbb arg1)
  {
    synchronized (zzdz.zzc(zzyu))
    {
      zzdz.zza(zzyu, 0);
      if ((zzdz.zzg(zzyu) != null) && (zzyB != zzdz.zzg(zzyu)))
      {
        zzb.v("New JS engine is loaded, marking previous one as destroyable.");
        zzdz.zzg(zzyu).zzdR();
      }
      zzdz.zza(zzyu, zzyB);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */