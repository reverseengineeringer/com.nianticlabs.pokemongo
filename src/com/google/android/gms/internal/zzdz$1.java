package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

class zzdz$1
  implements Runnable
{
  zzdz$1(zzdz paramzzdz, zzdz.zze paramzze) {}
  
  public void run()
  {
    final zzbb localzzbb = zzyu.zza(zzdz.zza(zzyu), zzdz.zzb(zzyu));
    localzzbb.zza(new zzbb.zza()
    {
      public void zzcj()
      {
        zzid.zzIE.postDelayed(new Runnable()
        {
          public void run()
          {
            synchronized (zzdz.zzc(zzyu))
            {
              if ((zzyt.getStatus() == -1) || (zzyt.getStatus() == 1)) {
                return;
              }
              zzyt.reject();
              zzid.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  zzyv.destroy();
                }
              });
              zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
              return;
            }
          }
        }, zzdz.zza.zzyD);
      }
    });
    localzzbb.zza("/jsLoaded", new zzdk()
    {
      public void zza(zziz arg1, Map<String, String> paramAnonymousMap)
      {
        synchronized (zzdz.zzc(zzyu))
        {
          if ((zzyt.getStatus() == -1) || (zzyt.getStatus() == 1)) {
            return;
          }
          zzdz.zza(zzyu, 0);
          zzdz.zzd(zzyu).zzc(localzzbb);
          zzyt.zzg(localzzbb);
          zzdz.zza(zzyu, zzyt);
          zzb.v("Successfully loaded JS Engine.");
          return;
        }
      }
    });
    final zzil localzzil = new zzil();
    zzdk local3 = new zzdk()
    {
      public void zza(zziz arg1, Map<String, String> paramAnonymousMap)
      {
        synchronized (zzdz.zzc(zzyu))
        {
          zzb.zzaG("JS Engine is requesting an update");
          if (zzdz.zze(zzyu) == 0)
          {
            zzb.zzaG("Starting reload.");
            zzdz.zza(zzyu, 2);
            zzyu.zzdN();
          }
          localzzbb.zzb("/requestReload", (zzdk)localzzil.get());
          return;
        }
      }
    };
    localzzil.set(local3);
    localzzbb.zza("/requestReload", local3);
    if (zzdz.zzf(zzyu).endsWith(".js")) {
      localzzbb.zzs(zzdz.zzf(zzyu));
    }
    for (;;)
    {
      zzid.zzIE.postDelayed(new Runnable()
      {
        public void run()
        {
          synchronized (zzdz.zzc(zzyu))
          {
            if ((zzyt.getStatus() == -1) || (zzyt.getStatus() == 1)) {
              return;
            }
            zzyt.reject();
            zzid.runOnUiThread(new Runnable()
            {
              public void run()
              {
                zzyv.destroy();
              }
            });
            zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
            return;
          }
        }
      }, zzdz.zza.zzyC);
      return;
      if (zzdz.zzf(zzyu).startsWith("<html>")) {
        localzzbb.zzu(zzdz.zzf(zzyu));
      } else {
        localzzbb.zzt(zzdz.zzf(zzyu));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */