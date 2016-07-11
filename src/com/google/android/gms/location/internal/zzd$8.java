package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;

class zzd$8
  extends zzd.zza
{
  zzd$8(zzd paramzzd, GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener)
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
    paramzzl.zza(zzaFe, local1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */