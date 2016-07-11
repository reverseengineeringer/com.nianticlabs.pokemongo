package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public abstract class zzf$zza<A extends Api.zzb>
  extends zzl.zzb<PlacePhotoResult, A>
{
  public zzf$zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected PlacePhotoResult zzaL(Status paramStatus)
  {
    return new PlacePhotoResult(paramStatus, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzf.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */