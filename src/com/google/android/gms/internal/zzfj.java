package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzgr
public final class zzfj
  extends zzg<zzfl>
{
  private static final zzfj zzCp = new zzfj();
  
  private zzfj()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static zzfk zzb(Activity paramActivity)
  {
    try
    {
      if (zzc(paramActivity))
      {
        zzb.zzaF("Using AdOverlay from the client jar.");
        return new com.google.android.gms.ads.internal.overlay.zzd(paramActivity);
      }
      paramActivity = zzCp.zzd(paramActivity);
      return paramActivity;
    }
    catch (zza paramActivity)
    {
      zzb.zzaH(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean zzc(Activity paramActivity)
    throws zzfj.zza
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private zzfk zzd(Activity paramActivity)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = zze.zzy(paramActivity);
      paramActivity = zzfk.zza.zzL(((zzfl)zzas(paramActivity)).zze(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected zzfl zzK(IBinder paramIBinder)
  {
    return zzfl.zza.zzM(paramIBinder);
  }
  
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */