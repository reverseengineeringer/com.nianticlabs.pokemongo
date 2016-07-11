package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;

@zzgr
public class zzbx
{
  private boolean zzpA = false;
  private final Object zzpd = new Object();
  private SharedPreferences zzuj = null;
  
  public void initialize(Context paramContext)
  {
    synchronized (zzpd)
    {
      if (zzpA) {
        return;
      }
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        return;
      }
    }
    zzuj = zzp.zzbC().zzv(paramContext);
    zzpA = true;
  }
  
  public <T> T zzd(zzbu<T> paramzzbu)
  {
    synchronized (zzpd)
    {
      if (!zzpA)
      {
        paramzzbu = paramzzbu.zzde();
        return paramzzbu;
      }
      return (T)paramzzbu.zza(zzuj);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */