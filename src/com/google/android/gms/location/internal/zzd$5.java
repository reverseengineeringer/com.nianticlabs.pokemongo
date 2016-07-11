package com.google.android.gms.location.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

class zzd$5
  extends zzd.zza
{
  zzd$5(zzd paramzzd, GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
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
    paramzzl.zza(zzaFd, zzaFe, zzaFl, local1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */