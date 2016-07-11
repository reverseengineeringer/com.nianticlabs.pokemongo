package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zzd;

class zzj$1
  extends zzl.zzd<zzk>
{
  zzj$1(zzj paramzzj, Api.zzc paramzzc, GoogleApiClient paramGoogleApiClient, PlaceFilter paramPlaceFilter)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected void zza(zzk paramzzk)
    throws RemoteException
  {
    paramzzk.zza(new zzl(this, paramzzk.getContext()), zzaHf);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzj.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */