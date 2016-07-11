package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl
{
  private static final Object zzafW = new Object();
  private static zzl zzafX;
  
  public static zzl zzal(Context paramContext)
  {
    synchronized (zzafW)
    {
      if (zzafX == null) {
        zzafX = new zzm(paramContext.getApplicationContext());
      }
      return zzafX;
    }
  }
  
  public abstract boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2);
  
  public abstract void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract void zzb(String paramString1, ServiceConnection paramServiceConnection, String paramString2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */