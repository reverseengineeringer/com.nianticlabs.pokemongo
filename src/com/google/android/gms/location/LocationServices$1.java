package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.location.internal.zzl;

final class LocationServices$1
  extends Api.zza<zzl, Api.ApiOptions.NoOptions>
{
  public zzl zzm(Context paramContext, Looper paramLooper, zzf paramzzf, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzl(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, "locationServices", paramzzf);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationServices.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */