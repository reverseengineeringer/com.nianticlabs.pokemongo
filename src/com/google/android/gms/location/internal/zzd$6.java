package com.google.android.gms.location.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

class zzd$6
  extends zzd.zza
{
  zzd$6(zzd paramzzd, GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper)
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
    paramzzl.zza(LocationRequestInternal.zzb(zzaFd), zzaFh, zzaFl, local1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */