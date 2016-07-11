package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzl$zza<A extends Api.zzb>
  extends zzl.zzb<AutocompletePredictionBuffer, A>
{
  public zzl$zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected AutocompletePredictionBuffer zzaO(Status paramStatus)
  {
    return new AutocompletePredictionBuffer(DataHolder.zzbu(paramStatus.getStatusCode()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */