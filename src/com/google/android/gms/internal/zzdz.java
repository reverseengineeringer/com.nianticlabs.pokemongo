package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

@zzgr
public class zzdz
{
  private final Context mContext;
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private final String zzyo;
  private zzb<zzbb> zzyp;
  private zzb<zzbb> zzyq;
  private zze zzyr;
  private int zzys = 1;
  
  public zzdz(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    zzyo = paramString;
    mContext = paramContext.getApplicationContext();
    zzpb = paramVersionInfoParcel;
    zzyp = new zzc();
    zzyq = new zzc();
  }
  
  public zzdz(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, zzb<zzbb> paramzzb1, zzb<zzbb> paramzzb2)
  {
    this(paramContext, paramVersionInfoParcel, paramString);
    zzyp = paramzzb1;
    zzyq = paramzzb2;
  }
  
  private zze zzdM()
  {
    final zze localzze = new zze(zzyq);
    zzid.runOnUiThread(new Runnable()
    {
      public void run()
      {
        final zzbb localzzbb = zza(zzdz.zza(zzdz.this), zzdz.zzb(zzdz.this));
        localzzbb.zza(new zzbb.zza()
        {
          public void zzcj()
          {
            zzid.zzIE.postDelayed(new Runnable()
            {
              public void run()
              {
                synchronized (zzdz.zzc(zzdz.this))
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
          public void zza(zziz arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzdz.zzc(zzdz.this))
            {
              if ((zzyt.getStatus() == -1) || (zzyt.getStatus() == 1)) {
                return;
              }
              zzdz.zza(zzdz.this, 0);
              zzdz.zzd(zzdz.this).zzc(localzzbb);
              zzyt.zzg(localzzbb);
              zzdz.zza(zzdz.this, zzyt);
              zzb.v("Successfully loaded JS Engine.");
              return;
            }
          }
        });
        final zzil localzzil = new zzil();
        zzdk local3 = new zzdk()
        {
          public void zza(zziz arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzdz.zzc(zzdz.this))
            {
              zzb.zzaG("JS Engine is requesting an update");
              if (zzdz.zze(zzdz.this) == 0)
              {
                zzb.zzaG("Starting reload.");
                zzdz.zza(zzdz.this, 2);
                zzdN();
              }
              localzzbb.zzb("/requestReload", (zzdk)localzzil.get());
              return;
            }
          }
        };
        localzzil.set(local3);
        localzzbb.zza("/requestReload", local3);
        if (zzdz.zzf(zzdz.this).endsWith(".js")) {
          localzzbb.zzs(zzdz.zzf(zzdz.this));
        }
        for (;;)
        {
          zzid.zzIE.postDelayed(new Runnable()
          {
            public void run()
            {
              synchronized (zzdz.zzc(zzdz.this))
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
          if (zzdz.zzf(zzdz.this).startsWith("<html>")) {
            localzzbb.zzu(zzdz.zzf(zzdz.this));
          } else {
            localzzbb.zzt(zzdz.zzf(zzdz.this));
          }
        }
      }
    });
    return localzze;
  }
  
  protected zzbb zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    return new zzbd(paramContext, paramVersionInfoParcel, null);
  }
  
  protected zze zzdN()
  {
    final zze localzze = zzdM();
    localzze.zza(new zzis.zzc()new zzis.zza
    {
      public void zza(zzbb arg1)
      {
        synchronized (zzdz.zzc(zzdz.this))
        {
          zzdz.zza(zzdz.this, 0);
          if ((zzdz.zzg(zzdz.this) != null) && (localzze != zzdz.zzg(zzdz.this)))
          {
            zzb.v("New JS engine is loaded, marking previous one as destroyable.");
            zzdz.zzg(zzdz.this).zzdR();
          }
          zzdz.zza(zzdz.this, localzze);
          return;
        }
      }
    }, new zzis.zza()
    {
      public void run()
      {
        synchronized (zzdz.zzc(zzdz.this))
        {
          zzdz.zza(zzdz.this, 1);
          zzb.v("Failed loading new engine. Marking new engine destroyable.");
          localzze.zzdR();
          return;
        }
      }
    });
    return localzze;
  }
  
  public zzd zzdO()
  {
    synchronized (zzpd)
    {
      zzd localzzd1;
      if ((zzyr == null) || (zzyr.getStatus() == -1))
      {
        zzys = 2;
        zzyr = zzdN();
        localzzd1 = zzyr.zzdP();
        return localzzd1;
      }
      if (zzys == 0)
      {
        localzzd1 = zzyr.zzdP();
        return localzzd1;
      }
    }
    if (zzys == 1)
    {
      zzys = 2;
      zzdN();
      localzzd2 = zzyr.zzdP();
      return localzzd2;
    }
    if (zzys == 2)
    {
      localzzd2 = zzyr.zzdP();
      return localzzd2;
    }
    zzd localzzd2 = zzyr.zzdP();
    return localzzd2;
  }
  
  static class zza
  {
    static int zzyC = 60000;
    static int zzyD = 10000;
  }
  
  public static abstract interface zzb<T>
  {
    public abstract void zzc(T paramT);
  }
  
  public static class zzc<T>
    implements zzdz.zzb<T>
  {
    public void zzc(T paramT) {}
  }
  
  public static class zzd
    extends zzit<zzbe>
  {
    private final Object zzpd = new Object();
    private final zzdz.zze zzyE;
    private boolean zzyF;
    
    public zzd(zzdz.zze paramzze)
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
  
  public static class zze
    extends zzit<zzbb>
  {
    private final Object zzpd = new Object();
    private boolean zzyH;
    private int zzyI;
    private zzdz.zzb<zzbb> zzyq;
    
    public zze(zzdz.zzb<zzbb> paramzzb)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */