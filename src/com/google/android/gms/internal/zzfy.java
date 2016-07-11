package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzgr
public final class zzfy
  extends zzg<zzfu>
{
  private static final zzfy zzDb = new zzfy();
  
  private zzfy()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  private static boolean zzc(Activity paramActivity)
    throws zzfy.zza
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
      throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
  }
  
  public static zzft zze(Activity paramActivity)
  {
    try
    {
      if (zzc(paramActivity))
      {
        zzb.zzaF("Using AdOverlay from the client jar.");
        return new com.google.android.gms.ads.internal.purchase.zze(paramActivity);
      }
      paramActivity = zzDb.zzf(paramActivity);
      return paramActivity;
    }
    catch (zza paramActivity)
    {
      zzb.zzaH(paramActivity.getMessage());
    }
    return null;
  }
  
  private zzft zzf(Activity paramActivity)
  {
    try
    {
      zzd localzzd = com.google.android.gms.dynamic.zze.zzy(paramActivity);
      paramActivity = zzft.zza.zzQ(((zzfu)zzas(paramActivity)).zzf(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzb.zzd("Could not create remote InAppPurchaseManager.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzb.zzd("Could not create remote InAppPurchaseManager.", paramActivity);
    }
    return null;
  }
  
  protected zzfu zzU(IBinder paramIBinder)
  {
    return zzfu.zza.zzR(paramIBinder);
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
 * Qualified Name:     com.google.android.gms.internal.zzfy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */