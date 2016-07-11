package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zze
  extends zzg<zzt>
{
  public zze()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  private zzs zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzel paramzzel, int paramInt)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = com.google.android.gms.dynamic.zze.zzy(paramContext);
      paramContext = zzs.zza.zzk(((zzt)zzas(paramContext)).zza(localzzd, paramAdSizeParcel, paramString, paramzzel, 8115000, paramInt));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzb.zza("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;) {}
    }
  }
  
  public zzs zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzel paramzzel)
  {
    Object localObject;
    if (zzl.zzcF().zzR(paramContext))
    {
      zzs localzzs = zza(paramContext, paramAdSizeParcel, paramString, paramzzel, 1);
      localObject = localzzs;
      if (localzzs != null) {}
    }
    else
    {
      zzb.zzaF("Using BannerAdManager from the client jar.");
      localObject = new zzf(paramContext, paramAdSizeParcel, paramString, paramzzel, new VersionInfoParcel(8115000, 8115000, true), com.google.android.gms.ads.internal.zzd.zzbd());
    }
    return (zzs)localObject;
  }
  
  public zzs zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzel paramzzel)
  {
    Object localObject;
    if (zzl.zzcF().zzR(paramContext))
    {
      zzs localzzs = zza(paramContext, paramAdSizeParcel, paramString, paramzzel, 2);
      localObject = localzzs;
      if (localzzs != null) {}
    }
    else
    {
      zzb.zzaH("Using InterstitialAdManager from the client jar.");
      localObject = new zzk(paramContext, paramAdSizeParcel, paramString, paramzzel, new VersionInfoParcel(8115000, 8115000, true), com.google.android.gms.ads.internal.zzd.zzbd());
    }
    return (zzs)localObject;
  }
  
  protected zzt zze(IBinder paramIBinder)
  {
    return zzt.zza.zzl(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */