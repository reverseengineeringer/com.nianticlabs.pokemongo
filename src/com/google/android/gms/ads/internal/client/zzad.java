package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zzad
  extends zzg<zzx>
{
  public zzad()
  {
    super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
  }
  
  private zzw zzu(Context paramContext)
  {
    try
    {
      zzd localzzd = zze.zzy(paramContext);
      paramContext = zzw.zza.zzo(((zzx)zzas(paramContext)).zza(localzzd, 8115000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzb.zzd("Could not get remote MobileAdsSettingManager.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      zzb.zzd("Could not get remote MobileAdsSettingManager.", paramContext);
    }
    return null;
  }
  
  protected zzx zzq(IBinder paramIBinder)
  {
    return zzx.zza.zzp(paramIBinder);
  }
  
  public zzw zzt(Context paramContext)
  {
    Object localObject;
    if (zzl.zzcF().zzR(paramContext))
    {
      zzw localzzw = zzu(paramContext);
      localObject = localzzw;
      if (localzzw != null) {}
    }
    else
    {
      zzb.zzaF("Using MobileAdsSettingManager from the client jar.");
      new VersionInfoParcel(8115000, 8115000, true);
      localObject = zzm.zzq(paramContext);
    }
    return (zzw)localObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */