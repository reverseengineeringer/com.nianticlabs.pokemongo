package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzl$zzd<A extends Api.zzb>
  extends zzl.zzb<PlaceLikelihoodBuffer, A>
{
  public zzl$zzd(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected PlaceLikelihoodBuffer zzaQ(Status paramStatus)
  {
    return new PlaceLikelihoodBuffer(DataHolder.zzbu(paramStatus.getStatusCode()), 100, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */