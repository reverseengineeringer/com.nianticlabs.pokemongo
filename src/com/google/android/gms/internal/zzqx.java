package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.internal.zzx;

public final class zzqx
  implements Api.ApiOptions.Optional
{
  public static final zzqx zzaUZ = new zza().zzCi();
  private final boolean zzTi;
  private final boolean zzTk;
  private final String zzTl;
  private final boolean zzaVa;
  private final GoogleApiClient.ServerAuthCodeCallbacks zzaVb;
  private final boolean zzaVc;
  
  private zzqx(boolean paramBoolean1, boolean paramBoolean2, String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks, boolean paramBoolean3, boolean paramBoolean4)
  {
    zzaVa = paramBoolean1;
    zzTi = paramBoolean2;
    zzTl = paramString;
    zzaVb = paramServerAuthCodeCallbacks;
    zzaVc = paramBoolean3;
    zzTk = paramBoolean4;
  }
  
  public boolean zzCf()
  {
    return zzaVa;
  }
  
  public GoogleApiClient.ServerAuthCodeCallbacks zzCg()
  {
    return zzaVb;
  }
  
  public boolean zzCh()
  {
    return zzaVc;
  }
  
  public boolean zzlY()
  {
    return zzTi;
  }
  
  public boolean zzma()
  {
    return zzTk;
  }
  
  public String zzmb()
  {
    return zzTl;
  }
  
  public static final class zza
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */