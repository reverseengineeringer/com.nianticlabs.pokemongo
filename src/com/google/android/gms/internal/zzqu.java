package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzh;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

public final class zzqu
{
  public static final Api<zzqx> API;
  public static final Api.zzc<zzi> zzRk = new Api.zzc();
  public static final Api.zza<zzi, zzqx> zzRl;
  public static final Scope zzTe;
  public static final Scope zzTf;
  static final Api.zza<zzi, Api.ApiOptions.NoOptions> zzaUX;
  public static final zzqv zzaUY = new zzh();
  public static final Api<Api.ApiOptions.NoOptions> zzaiH;
  public static final Api.zzc<zzi> zzapF = new Api.zzc();
  
  static
  {
    zzRl = new Api.zza()
    {
      public zzi zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, zzqx paramAnonymouszzqx, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymouszzqx == null) {
          paramAnonymouszzqx = zzqx.zzaUZ;
        }
        for (;;)
        {
          return new zzi(paramAnonymousContext, paramAnonymousLooper, true, paramAnonymouszzf, paramAnonymouszzqx, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
      }
    };
    zzaUX = new Api.zza()
    {
      public zzi zzt(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new zzi(paramAnonymousContext, paramAnonymousLooper, false, paramAnonymouszzf, zzqx.zzaUZ, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, Executors.newSingleThreadExecutor());
      }
    };
    zzTe = new Scope("profile");
    zzTf = new Scope("email");
    API = new Api("SignIn.API", zzRl, zzRk);
    zzaiH = new Api("SignIn.INTERNAL_API", zzaUX, zzapF);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */