package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.internal.zzx;

public final class zzqx$zza
{
  private String zzaSe;
  private boolean zzaVd;
  private boolean zzaVe;
  private GoogleApiClient.ServerAuthCodeCallbacks zzaVf;
  private boolean zzaVg;
  private boolean zzaVh;
  
  private String zzet(String paramString)
  {
    zzx.zzw(paramString);
    if ((zzaSe == null) || (zzaSe.equals(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "two different server client ids provided");
      return paramString;
    }
  }
  
  public zzqx zzCi()
  {
    return new zzqx(zzaVd, zzaVe, zzaSe, zzaVf, zzaVg, zzaVh, null);
  }
  
  public zza zza(String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks)
  {
    zzaVd = true;
    zzaVe = true;
    zzaSe = zzet(paramString);
    zzaVf = ((GoogleApiClient.ServerAuthCodeCallbacks)zzx.zzw(paramServerAuthCodeCallbacks));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqx.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */