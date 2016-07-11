package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

public class zzlq<R extends Result>
  extends zze<R>
  implements ResultCallback<R>
{
  private final Object zzabh;
  private zzb<? super R, ? extends Result> zzacY;
  private zzlq<? extends Result> zzacZ;
  private ResultCallbacks<? super R> zzada;
  private PendingResult<R> zzadb;
  
  private void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("TransformedResultImpl", "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  private void zzon()
  {
    if ((zzadb == null) || ((zzacY == null) && (zzada == null))) {
      return;
    }
    zzadb.setResultCallback(this);
  }
  
  public void onResult(R paramR)
  {
    for (;;)
    {
      synchronized (zzabh)
      {
        if (!paramR.getStatus().isSuccess()) {
          break label96;
        }
        if (zzacY != null)
        {
          PendingResult localPendingResult = zzacY.zza(paramR);
          if (localPendingResult == null)
          {
            zzx(new Status(13, "Transform returned null"));
            zzd(paramR);
            return;
          }
          zzacZ.zza(localPendingResult);
        }
      }
      if (zzada != null)
      {
        zzada.onSuccess(paramR);
        continue;
        label96:
        zzx(paramR.getStatus());
        zzd(paramR);
      }
    }
  }
  
  public void zza(PendingResult<?> paramPendingResult)
  {
    synchronized (zzabh)
    {
      zzadb = paramPendingResult;
      zzon();
      return;
    }
  }
  
  public void zzx(Status paramStatus)
  {
    synchronized (zzabh)
    {
      if (zzacY != null)
      {
        paramStatus = zzacY.zzu(paramStatus);
        zzx.zzb(paramStatus, "onFailure must not return null");
        zzacZ.zzx(paramStatus);
      }
      while (zzada == null) {
        return;
      }
      zzada.onFailure(paramStatus);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */