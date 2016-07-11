package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzac<T extends IInterface>
  extends zzj<T>
{
  private final Api.zzd<T> zzagt;
  
  public zzac(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf, Api.zzd paramzzd)
  {
    super(paramContext, paramLooper, paramInt, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzagt = paramzzd;
  }
  
  protected T zzW(IBinder paramIBinder)
  {
    return zzagt.zzW(paramIBinder);
  }
  
  protected void zzc(int paramInt, T paramT)
  {
    zzagt.zza(paramInt, paramT);
  }
  
  protected String zzfK()
  {
    return zzagt.zzfK();
  }
  
  protected String zzfL()
  {
    return zzagt.zzfL();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */