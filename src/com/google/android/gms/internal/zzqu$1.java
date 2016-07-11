package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

final class zzqu$1
  extends Api.zza<zzi, zzqx>
{
  public zzi zza(Context paramContext, Looper paramLooper, zzf paramzzf, zzqx paramzzqx, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramzzqx == null) {
      paramzzqx = zzqx.zzaUZ;
    }
    for (;;)
    {
      return new zzi(paramContext, paramLooper, true, paramzzf, paramzzqx, paramConnectionCallbacks, paramOnConnectionFailedListener, Executors.newSingleThreadExecutor());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqu.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */