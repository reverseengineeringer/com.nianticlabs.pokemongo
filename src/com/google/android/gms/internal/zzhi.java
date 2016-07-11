package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzhi
  extends zzhz
  implements zzhj, zzhm
{
  private final Context mContext;
  private final zzhs.zza zzDe;
  private int zzDv = 3;
  private final String zzGY;
  private final zzhh zzHg;
  private final zzhm zzHh;
  private final String zzHi;
  private int zzHj = 0;
  private final Object zzpd;
  private final String zzzj;
  
  public zzhi(Context paramContext, String paramString1, String paramString2, String paramString3, zzhs.zza paramzza, zzhh paramzzhh, zzhm paramzzhm)
  {
    mContext = paramContext;
    zzzj = paramString1;
    zzGY = paramString2;
    zzHi = paramString3;
    zzDe = paramzza;
    zzHg = paramzzhh;
    zzpd = new Object();
    zzHh = paramzzhm;
  }
  
  private void zzk(long paramLong)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzHj != 0) {
          return;
        }
        if (!zzf(paramLong)) {
          return;
        }
      }
    }
  }
  
  public void onStop() {}
  
  public void zzK(int paramInt)
  {
    zzb(zzzj, 0);
  }
  
  public void zzav(String arg1)
  {
    synchronized (zzpd)
    {
      zzHj = 1;
      zzpd.notify();
      return;
    }
  }
  
  public void zzb(String arg1, int paramInt)
  {
    synchronized (zzpd)
    {
      zzHj = 2;
      zzDv = paramInt;
      zzpd.notify();
      return;
    }
  }
  
  public void zzbn()
  {
    if ((zzHg == null) || (zzHg.zzgd() == null) || (zzHg.zzgc() == null)) {
      return;
    }
    final zzhl localzzhl = zzHg.zzgd();
    localzzhl.zza(this);
    localzzhl.zza(this);
    final AdRequestParcel localAdRequestParcel = zzDe.zzHC.zzEn;
    final zzen localzzen = zzHg.zzgc();
    try
    {
      if (localzzen.isInitialized()) {
        zza.zzJt.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzen.zza(localAdRequestParcel, zzhi.zza(zzhi.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              zzb.zzd("Fail to load ad from adapter.", localRemoteException);
              zzb(zzhi.zzb(zzhi.this), 0);
            }
          }
        });
      }
      for (;;)
      {
        zzk(zzp.zzbz().elapsedRealtime());
        localzzhl.zza(null);
        localzzhl.zza(null);
        if (zzHj != 1) {
          break;
        }
        zzHh.zzav(zzzj);
        return;
        zza.zzJt.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzen.zza(zze.zzy(zzhi.zzc(zzhi.this)), localAdRequestParcel, zzhi.zzd(zzhi.this), localzzhl, zzhi.zza(zzhi.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              zzb.zzd("Fail to initialize adapter " + zzhi.zzb(zzhi.this), localRemoteException);
              zzb(zzhi.zzb(zzhi.this), 0);
            }
          }
        });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Fail to check if adapter is initialized.", localRemoteException);
        zzb(zzzj, 0);
      }
      zzHh.zzb(zzzj, zzDv);
    }
  }
  
  protected boolean zzf(long paramLong)
  {
    paramLong = 20000L - (zzp.zzbz().elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      zzpd.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public void zzge()
  {
    zzHg.zzgd();
    AdRequestParcel localAdRequestParcel = zzDe.zzHC.zzEn;
    zzen localzzen = zzHg.zzgc();
    try
    {
      localzzen.zza(localAdRequestParcel, zzHi);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Fail to load ad from adapter.", localRemoteException);
      zzb(zzzj, 0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */