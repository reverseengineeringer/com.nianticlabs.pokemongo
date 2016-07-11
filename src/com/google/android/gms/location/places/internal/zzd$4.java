package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zzb;

class zzd$4
  extends zzf.zzb<zze>
{
  zzd$4(zzd paramzzd, Api.zzc paramzzc, GoogleApiClient paramGoogleApiClient, String paramString)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected void zza(zze paramzze)
    throws RemoteException
  {
    paramzze.zza(new zzf(this), zzaHa);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzd.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */