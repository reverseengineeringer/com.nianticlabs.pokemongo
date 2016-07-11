package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

final class zzqu$2
  extends Api.zza<zzi, Api.ApiOptions.NoOptions>
{
  public zzi zzt(Context paramContext, Looper paramLooper, zzf paramzzf, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzi(paramContext, paramLooper, false, paramzzf, zzqx.zzaUZ, paramConnectionCallbacks, paramOnConnectionFailedListener, Executors.newSingleThreadExecutor());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqu.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */