package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

class zzq$1
  extends LocationServices.zza<LocationSettingsResult>
{
  zzq$1(zzq paramzzq, GoogleApiClient paramGoogleApiClient, LocationSettingsRequest paramLocationSettingsRequest, String paramString)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    paramzzl.zza(zzaFP, this, zzaFQ);
  }
  
  public LocationSettingsResult zzaK(Status paramStatus)
  {
    return new LocationSettingsResult(paramStatus);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */