package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzmb
  extends zzj<zzmd>
{
  public zzmb(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzmd zzaO(IBinder paramIBinder)
  {
    return zzmd.zza.zzaQ(paramIBinder);
  }
  
  public String zzfK()
  {
    return "com.google.android.gms.common.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */