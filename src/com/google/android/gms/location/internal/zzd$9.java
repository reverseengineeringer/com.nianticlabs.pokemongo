package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

class zzd$9
  extends zzd.zza
{
  zzd$9(zzd paramzzd, GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    zzg.zza local1 = new zzg.zza()
    {
      public void zza(FusedLocationProviderResult paramAnonymousFusedLocationProviderResult)
      {
        zzb(paramAnonymousFusedLocationProviderResult.getStatus());
      }
    };
    paramzzl.zza(zzaEY, local1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */