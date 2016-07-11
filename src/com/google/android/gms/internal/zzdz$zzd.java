package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

public class zzdz$zzd
  extends zzit<zzbe>
{
  private final Object zzpd = new Object();
  private final zzdz.zze zzyE;
  private boolean zzyF;
  
  public zzdz$zzd(zzdz.zze paramzze)
  {
    zzyE = paramzze;
  }
  
  public void release()
  {
    synchronized (zzpd)
    {
      if (zzyF) {
        return;
      }
      zzyF = true;
      zza(new zzis.zzc()new zzis.zzb
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          zzb.v("Ending javascript session.");
          ((zzbf)paramAnonymouszzbe).zzck();
        }
      }, new zzis.zzb());
      zza(new zzis.zzc()new zzis.zza
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          zzb.v("Releasing engine reference.");
          zzdz.zzd.zza(zzdz.zzd.this).zzdQ();
        }
      }, new zzis.zza()
      {
        public void run()
        {
          zzdz.zzd.zza(zzdz.zzd.this).zzdQ();
        }
      });
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */