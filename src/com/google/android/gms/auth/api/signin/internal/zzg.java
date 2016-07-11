package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzg
  extends zzj<zze>
{
  private final com.google.android.gms.auth.api.signin.zzg zzTq;
  
  public zzg(Context paramContext, Looper paramLooper, zzf paramzzf, com.google.android.gms.auth.api.signin.zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 87, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzTq = ((com.google.android.gms.auth.api.signin.zzg)zzx.zzw(paramzzg));
  }
  
  protected zze zzax(IBinder paramIBinder)
  {
    return zze.zza.zzaz(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */