package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.GeofencingRequest;

class zzf$1
  extends zzf.zza
{
  zzf$1(zzf paramzzf, GoogleApiClient paramGoogleApiClient, GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    paramzzl.zza(zzaFs, zzarN, this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzf.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */