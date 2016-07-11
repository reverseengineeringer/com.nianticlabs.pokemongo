package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zzf;

class zzj$2
  extends zzl.zzf<zzk>
{
  zzj$2(zzj paramzzj, Api.zzc paramzzc, GoogleApiClient paramGoogleApiClient, PlaceReport paramPlaceReport)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected void zza(zzk paramzzk)
    throws RemoteException
  {
    paramzzk.zza(new zzl(this), zzaHh);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzj.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */