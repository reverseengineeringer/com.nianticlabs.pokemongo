package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzma<R extends Result>
  extends zzlb.zza<R, zzmb>
{
  public zzma(GoogleApiClient paramGoogleApiClient)
  {
    super(zzlx.zzRk, paramGoogleApiClient);
  }
  
  static abstract class zza
    extends zzma<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */