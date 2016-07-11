package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zzc;

class zzd$1
  extends zzl.zzc<zze>
{
  zzd$1(zzd paramzzd, Api.zzc paramzzc, GoogleApiClient paramGoogleApiClient, AddPlaceRequest paramAddPlaceRequest)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected void zza(zze paramzze)
    throws RemoteException
  {
    paramzze.zza(new zzl(this, paramzze.getContext()), zzaGV);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzd.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */