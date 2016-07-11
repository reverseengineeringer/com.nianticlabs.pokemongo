package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzl$zzc<A extends Api.zzb>
  extends zzl.zzb<PlaceBuffer, A>
{
  public zzl$zzc(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected PlaceBuffer zzaP(Status paramStatus)
  {
    return new PlaceBuffer(DataHolder.zzbu(paramStatus.getStatusCode()), null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */