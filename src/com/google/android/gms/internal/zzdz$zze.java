package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

public class zzdz$zze
  extends zzit<zzbb>
{
  private final Object zzpd = new Object();
  private boolean zzyH;
  private int zzyI;
  private zzdz.zzb<zzbb> zzyq;
  
  public zzdz$zze(zzdz.zzb<zzbb> paramzzb)
  {
    zzyq = paramzzb;
    zzyH = false;
    zzyI = 0;
  }
  
  public zzdz.zzd zzdP()
  {
    final zzdz.zzd localzzd = new zzdz.zzd(this);
    for (;;)
    {
      synchronized (zzpd)
      {
        zza(new zzis.zzc()new zzis.zza
        {
          public void zza(zzbb paramAnonymouszzbb)
          {
            zzb.v("Getting a new session for JS Engine.");
            localzzd.zzg(paramAnonymouszzbb.zzci());
          }
        }, new zzis.zza()
        {
          public void run()
          {
            zzb.v("Rejecting reference for JS Engine.");
            localzzd.reject();
          }
        });
        if (zzyI >= 0)
        {
          bool = true;
          zzx.zzZ(bool);
          zzyI += 1;
          return localzzd;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void zzdQ()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (zzpd)
      {
        if (zzyI >= 1)
        {
          zzx.zzZ(bool);
          zzb.v("Releasing 1 reference for JS Engine");
          zzyI -= 1;
          zzdS();
          return;
        }
      }
    }
  }
  
  public void zzdR()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (zzpd)
      {
        if (zzyI >= 0)
        {
          zzx.zzZ(bool);
          zzb.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
          zzyH = true;
          zzdS();
          return;
        }
      }
    }
  }
  
  protected void zzdS()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzyI >= 0)
        {
          bool = true;
          zzx.zzZ(bool);
          if ((zzyH) && (zzyI == 0))
          {
            zzb.v("No reference is left (including root). Cleaning up engine.");
            zza(new zzis.zzc()new zzis.zzb
            {
              public void zza(final zzbb paramAnonymouszzbb)
              {
                zzid.runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    zzdz.zze.zza(zzdz.zze.this).zzc(paramAnonymouszzbb);
                    paramAnonymouszzbb.destroy();
                  }
                });
              }
            }, new zzis.zzb());
            return;
          }
          zzb.v("There are still references to the engine. Not destroying.");
        }
      }
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */