package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhf;

@zzgr
public class zzf
  extends zzg<zzc>
{
  public zzf()
  {
    super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
  }
  
  private zzb zzb(Context paramContext, zzel paramzzel)
  {
    try
    {
      zzd localzzd = zze.zzy(paramContext);
      paramContext = zzb.zza.zzaa(((zzc)zzas(paramContext)).zza(localzzd, paramzzel, 8115000));
      return paramContext;
    }
    catch (zzg.zza paramContext)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote RewardedVideoAd.", paramContext);
      return null;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
  }
  
  public zzb zza(Context paramContext, zzel paramzzel)
  {
    Object localObject;
    if (zzl.zzcF().zzR(paramContext))
    {
      zzb localzzb = zzb(paramContext, paramzzel);
      localObject = localzzb;
      if (localzzb != null) {}
    }
    else
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Using RewardedVideoAd from the client jar.");
      localObject = new zzhf(paramContext, paramzzel, new VersionInfoParcel(8115000, 8115000, true));
    }
    return (zzb)localObject;
  }
  
  protected zzc zzad(IBinder paramIBinder)
  {
    return zzc.zza.zzab(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */