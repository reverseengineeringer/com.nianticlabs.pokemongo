package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class zzj$zze
  implements ServiceConnection
{
  private final int zzafN;
  
  public zzj$zze(zzj paramzzj, int paramInt)
  {
    zzafN = paramInt;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zzx.zzb(paramIBinder, "Expecting a valid IBinder");
    zzj.zza(zzafK, zzs.zza.zzaK(paramIBinder));
    zzafK.zzbF(zzafN);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzafK.mHandler.sendMessage(zzafK.mHandler.obtainMessage(4, zzafN, 1));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */