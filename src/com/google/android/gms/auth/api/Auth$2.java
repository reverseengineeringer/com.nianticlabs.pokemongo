package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.internal.zze;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

final class Auth$2
  extends Api.zza<zze, Auth.AuthCredentialsOptions>
{
  public zze zza(Context paramContext, Looper paramLooper, zzf paramzzf, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zze(paramContext, paramLooper, paramzzf, paramAuthCredentialsOptions, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */