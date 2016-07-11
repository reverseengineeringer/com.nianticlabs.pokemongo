package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zzd$4
  extends zzd.zza
{
  zzd$4(zzd paramzzd, GoogleApiClient paramGoogleApiClient, Location paramLocation)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    paramzzl.zzc(zzaFk);
    zzb(Status.zzabb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */