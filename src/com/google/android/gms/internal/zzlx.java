package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public final class zzlx
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Common.API", zzRl, zzRk);
  public static final Api.zzc<zzmb> zzRk = new Api.zzc();
  private static final Api.zza<zzmb, Api.ApiOptions.NoOptions> zzRl = new Api.zza()
  {
    public zzmb zze(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzmb(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final zzly zzagw = new zzlz();
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */