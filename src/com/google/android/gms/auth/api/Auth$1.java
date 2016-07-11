package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzki;

final class Auth$1
  extends Api.zza<zzki, Auth.zza>
{
  public zzki zza(Context paramContext, Looper paramLooper, zzf paramzzf, Auth.zza paramzza, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzki(paramContext, paramLooper, paramzzf, paramzza, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */