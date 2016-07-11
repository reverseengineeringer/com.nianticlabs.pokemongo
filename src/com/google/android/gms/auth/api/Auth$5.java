package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

final class Auth$5
  extends Api.zza<com.google.android.gms.auth.api.signin.internal.zzg, com.google.android.gms.auth.api.signin.zzg>
{
  public com.google.android.gms.auth.api.signin.internal.zzg zza(Context paramContext, Looper paramLooper, zzf paramzzf, com.google.android.gms.auth.api.signin.zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new com.google.android.gms.auth.api.signin.internal.zzg(paramContext, paramLooper, paramzzf, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */