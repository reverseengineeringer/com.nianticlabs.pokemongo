package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.internal.zzlc;

final class PendingResults$zza<R extends Result>
  extends zzlc<R>
{
  private final R zzaaW;
  
  public PendingResults$zza(R paramR)
  {
    super(Looper.getMainLooper());
    zzaaW = paramR;
  }
  
  protected R zzb(Status paramStatus)
  {
    if (paramStatus.getStatusCode() != zzaaW.getStatus().getStatusCode()) {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
    return zzaaW;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.PendingResults.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */