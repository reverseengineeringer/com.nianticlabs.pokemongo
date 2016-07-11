package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.internal.zzb;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

final class Auth$6
  extends Api.zza<zzb, GoogleSignInConfig>
{
  public zzb zza(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleSignInConfig paramGoogleSignInConfig, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzb(paramContext, paramLooper, paramzzf, paramGoogleSignInConfig, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */