package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zzj$zza
  extends zzj<T>.zzc<Boolean>
{
  public final int statusCode;
  public final Bundle zzafJ;
  
  protected zzj$zza(zzj paramzzj, int paramInt, Bundle paramBundle)
  {
    super(paramzzj, Boolean.valueOf(true));
    statusCode = paramInt;
    zzafJ = paramBundle;
  }
  
  protected void zzc(Boolean paramBoolean)
  {
    Object localObject = null;
    if (paramBoolean == null) {
      zzj.zza(zzafK, 1, null);
    }
    do
    {
      return;
      switch (statusCode)
      {
      default: 
        zzj.zza(zzafK, 1, null);
        paramBoolean = (Boolean)localObject;
        if (zzafJ != null) {
          paramBoolean = (PendingIntent)zzafJ.getParcelable("pendingIntent");
        }
        zzh(new ConnectionResult(statusCode, paramBoolean));
        return;
      }
    } while (zzpf());
    zzj.zza(zzafK, 1, null);
    zzh(new ConnectionResult(8, null));
    return;
    zzj.zza(zzafK, 1, null);
    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
  }
  
  protected abstract void zzh(ConnectionResult paramConnectionResult);
  
  protected abstract boolean zzpf();
  
  protected void zzpg() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */