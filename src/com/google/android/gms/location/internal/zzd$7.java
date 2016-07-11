package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

class zzd$7
  extends zzd.zza
{
  zzd$7(zzd paramzzd, GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
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
    paramzzl.zza(zzaFd, zzaEY, local1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */