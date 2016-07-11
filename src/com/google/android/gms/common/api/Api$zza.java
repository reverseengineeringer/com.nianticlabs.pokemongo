package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import java.util.Collections;
import java.util.List;

public abstract class Api$zza<T extends Api.zzb, O>
{
  public int getPriority()
  {
    return Integer.MAX_VALUE;
  }
  
  public abstract T zza(Context paramContext, Looper paramLooper, zzf paramzzf, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public List<Scope> zzm(O paramO)
  {
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */