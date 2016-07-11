package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzb
  extends zzj<zzi>
{
  private final String zzaFa;
  protected final zzp<zzi> zzaFb = new zzp()
  {
    public void zzpb()
    {
      zzb.zza(zzb.this);
    }
    
    public zzi zzwB()
      throws DeadObjectException
    {
      return (zzi)zzb.this.zzpc();
    }
  };
  
  public zzb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, 23, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzaFa = paramString;
  }
  
  protected zzi zzbY(IBinder paramIBinder)
  {
    return zzi.zza.zzcb(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected Bundle zzly()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", zzaFa);
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */