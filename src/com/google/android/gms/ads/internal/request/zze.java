package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zze
  extends com.google.android.gms.common.internal.zzj<zzj>
{
  final int zzEl;
  
  public zze(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramLooper, 8, zzf.zzak(paramContext), paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzEl = paramInt;
  }
  
  protected zzj zzV(IBinder paramIBinder)
  {
    return zzj.zza.zzX(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public zzj zzfM()
    throws DeadObjectException
  {
    return (zzj)super.zzpc();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */