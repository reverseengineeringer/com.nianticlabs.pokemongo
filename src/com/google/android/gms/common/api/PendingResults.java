package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzln;
import com.google.android.gms.internal.zzlo;

public final class PendingResults
{
  public static PendingResult<Status> canceledPendingResult()
  {
    zzlo localzzlo = new zzlo(Looper.getMainLooper());
    localzzlo.cancel();
    return localzzlo;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    zzx.zzb(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Status code must be CommonStatusCodes.CANCELED");
      paramR = new zza(paramR);
      paramR.cancel();
      return paramR;
    }
  }
  
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    zzx.zzb(paramR, "Result must not be null");
    zzc localzzc = new zzc(null);
    localzzc.zzb(paramR);
    return new zzln(localzzc);
  }
  
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    zzx.zzb(paramStatus, "Result must not be null");
    zzlo localzzlo = new zzlo(Looper.getMainLooper());
    localzzlo.zzb(paramStatus);
    return localzzlo;
  }
  
  public static <R extends Result> PendingResult<R> zza(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Status code must not be SUCCESS");
      paramGoogleApiClient = new zzb(paramGoogleApiClient, paramR);
      paramGoogleApiClient.zzb(paramR);
      return paramGoogleApiClient;
    }
  }
  
  public static PendingResult<Status> zza(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(paramStatus, "Result must not be null");
    paramGoogleApiClient = new zzlo(paramGoogleApiClient);
    paramGoogleApiClient.zzb(paramStatus);
    return paramGoogleApiClient;
  }
  
  private static final class zza<R extends Result>
    extends zzlc<R>
  {
    private final R zzaaW;
    
    public zza(R paramR)
    {
      super();
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
  
  private static final class zzb<R extends Result>
    extends zzlc<R>
  {
    private final R zzaaX;
    
    public zzb(GoogleApiClient paramGoogleApiClient, R paramR)
    {
      super();
      zzaaX = paramR;
    }
    
    protected R zzb(Status paramStatus)
    {
      return zzaaX;
    }
  }
  
  private static final class zzc<R extends Result>
    extends zzlc<R>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected R zzb(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */