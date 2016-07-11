package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.lang.ref.WeakReference;

class zzi$1
  implements Runnable
{
  zzi$1(zzi paramzzi, AdRequestParcel paramAdRequestParcel) {}
  
  public void run()
  {
    synchronized (zzi.zza(zzpf))
    {
      zzn localzzn = zzpf.zzbj();
      zzi.zza(zzpf, new WeakReference(localzzn));
      localzzn.zzb(zzi.zzb(zzpf));
      localzzn.zzb(zzi.zzc(zzpf));
      localzzn.zza(zzi.zzd(zzpf));
      localzzn.zza(zzi.zze(zzpf));
      localzzn.zzb(zzi.zzf(zzpf));
      localzzn.zza(zzi.zzg(zzpf));
      localzzn.zzb(zzi.zzh(zzpf));
      localzzn.zzb(zzpe);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzi.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */