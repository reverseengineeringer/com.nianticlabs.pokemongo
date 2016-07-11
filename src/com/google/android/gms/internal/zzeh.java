package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import java.util.List;

@zzgr
public final class zzeh
  implements zzei.zza
{
  private final Context mContext;
  private final NativeAdOptionsParcel zzoY;
  private final List<String> zzoZ;
  private final zzem zzox;
  private final AdRequestParcel zzpH;
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private final String zzzj;
  private final long zzzk;
  private final zzed zzzl;
  private final AdSizeParcel zzzm;
  private final boolean zzzn;
  private zzen zzzo;
  private int zzzp = -2;
  private zzep zzzq;
  
  public zzeh(Context paramContext, String paramString, zzem paramzzem, zzee paramzzee, zzed paramzzed, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, boolean paramBoolean, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
  {
    mContext = paramContext;
    zzox = paramzzem;
    zzzl = paramzzed;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      zzzj = zzdT();
      if (zzyX == -1L) {
        break label124;
      }
    }
    label124:
    for (long l = zzyX;; l = 10000L)
    {
      zzzk = l;
      zzpH = paramAdRequestParcel;
      zzzm = paramAdSizeParcel;
      zzpb = paramVersionInfoParcel;
      zzzn = paramBoolean;
      zzoY = paramNativeAdOptionsParcel;
      zzoZ = paramList;
      return;
      zzzj = paramString;
      break;
    }
  }
  
  private void zza(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (zzzp != -2) {
        return;
      }
      zzb(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void zza(zzeg paramzzeg)
  {
    if ("com.google.ads.mediation.AdUrlAdapter".equals(zzzj))
    {
      Bundle localBundle2 = zzpH.zzsL.getBundle(zzzj);
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      localBundle1.putString("sdk_less_network_id", zzzl.zzyN);
      zzpH.zzsL.putBundle(zzzj, localBundle1);
    }
    try
    {
      if (zzpb.zzJw < 4100000)
      {
        if (zzzm.zztf)
        {
          zzzo.zza(zze.zzy(mContext), zzpH, zzzl.zzyT, paramzzeg);
          return;
        }
        zzzo.zza(zze.zzy(mContext), zzzm, zzpH, zzzl.zzyT, paramzzeg);
        return;
      }
    }
    catch (RemoteException paramzzeg)
    {
      zzb.zzd("Could not request ad from mediation adapter.", paramzzeg);
      zzq(5);
      return;
    }
    if (zzzn)
    {
      zzzo.zza(zze.zzy(mContext), zzpH, zzzl.zzyT, zzzl.zzyM, paramzzeg, zzoY, zzoZ);
      return;
    }
    if (zzzm.zztf)
    {
      zzzo.zza(zze.zzy(mContext), zzpH, zzzl.zzyT, zzzl.zzyM, paramzzeg);
      return;
    }
    zzzo.zza(zze.zzy(mContext), zzzm, zzpH, zzzl.zzyT, zzzl.zzyM, paramzzeg);
  }
  
  private void zzb(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      zzb.zzaG("Timed out waiting for adapter.");
      zzzp = 3;
      return;
    }
    try
    {
      zzpd.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzzp = -1;
    }
  }
  
  private String zzdT()
  {
    try
    {
      if (!TextUtils.isEmpty(zzzl.zzyQ))
      {
        if (zzox.zzaf(zzzl.zzyQ)) {
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private zzen zzdU()
  {
    zzb.zzaG("Instantiating mediation adapter: " + zzzj);
    if (((Boolean)zzby.zzvu.get()).booleanValue())
    {
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(zzzj)) {
        return new zzet(new AdMobAdapter());
      }
      if ("com.google.ads.mediation.AdUrlAdapter".equals(zzzj)) {
        return new zzet(new AdUrlAdapter());
      }
    }
    try
    {
      zzen localzzen = zzox.zzae(zzzj);
      return localzzen;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zza("Could not instantiate mediation adapter: " + zzzj, localRemoteException);
    }
    return null;
  }
  
  public void cancel()
  {
    synchronized (zzpd)
    {
      try
      {
        if (zzzo != null) {
          zzzo.destroy();
        }
        zzzp = -1;
        zzpd.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public zzei zza(long paramLong1, long paramLong2)
  {
    synchronized (zzpd)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new zzeg();
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          synchronized (zzeh.zza(zzeh.this))
          {
            if (zzeh.zzb(zzeh.this) != -2) {
              return;
            }
            zzeh.zza(zzeh.this, zzeh.zzc(zzeh.this));
            if (zzeh.zzd(zzeh.this) == null)
            {
              zzq(4);
              return;
            }
          }
          localObject2.zza(zzeh.this);
          zzeh.zza(zzeh.this, localObject2);
        }
      });
      zza(l, zzzk, paramLong1, paramLong2);
      localObject2 = new zzei(zzzl, zzzo, zzzj, (zzeg)localObject2, zzzp, zzzq);
      return (zzei)localObject2;
    }
  }
  
  public void zza(int paramInt, zzep paramzzep)
  {
    synchronized (zzpd)
    {
      zzzp = paramInt;
      zzzq = paramzzep;
      zzpd.notify();
      return;
    }
  }
  
  public void zzq(int paramInt)
  {
    synchronized (zzpd)
    {
      zzzp = paramInt;
      zzpd.notify();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */