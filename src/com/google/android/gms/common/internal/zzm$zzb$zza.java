package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Iterator;
import java.util.Set;

public class zzm$zzb$zza
  implements ServiceConnection
{
  public zzm$zzb$zza(zzm.zzb paramzzb) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (zzm.zza(zzagh.zzagg))
    {
      zzm.zzb.zza(zzagh, paramIBinder);
      zzm.zzb.zza(zzagh, paramComponentName);
      Iterator localIterator = zzm.zzb.zzb(zzagh).iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    zzm.zzb.zza(zzagh, 1);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (zzm.zza(zzagh.zzagg))
    {
      zzm.zzb.zza(zzagh, null);
      zzm.zzb.zza(zzagh, paramComponentName);
      Iterator localIterator = zzm.zzb.zzb(zzagh).iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    zzm.zzb.zza(zzagh, 2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */