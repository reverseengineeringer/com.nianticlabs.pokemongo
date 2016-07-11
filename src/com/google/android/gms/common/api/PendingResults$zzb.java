package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzlc;

final class PendingResults$zzb<R extends Result>
  extends zzlc<R>
{
  private final R zzaaX;
  
  public PendingResults$zzb(GoogleApiClient paramGoogleApiClient, R paramR)
  {
    super(paramGoogleApiClient);
    zzaaX = paramR;
  }
  
  protected R zzb(Status paramStatus)
  {
    return zzaaX;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.PendingResults.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */