package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzk;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class zzlf
  implements zzlj
{
  private final zzli zzabr;
  
  public zzlf(zzli paramzzli)
  {
    zzabr = paramzzli;
  }
  
  private <A extends Api.zzb> void zza(zzli.zzf<A> paramzzf)
    throws DeadObjectException
  {
    zzabr.zzb(paramzzf);
    Api.zzb localzzb = zzabr.zza(paramzzf.zznx());
    if ((!localzzb.isConnected()) && (zzabr.zzach.containsKey(paramzzf.zznx())))
    {
      paramzzf.zzv(new Status(17));
      return;
    }
    paramzzf.zzb(localzzb);
  }
  
  public void begin()
  {
    while (!zzabr.zzaca.isEmpty()) {
      try
      {
        zza((zzli.zzf)zzabr.zzaca.remove());
      }
      catch (DeadObjectException localDeadObjectException)
      {
        Log.w("GACConnected", "Service died while flushing queue", localDeadObjectException);
      }
    }
  }
  
  public void connect() {}
  
  public void disconnect()
  {
    zzabr.zzach.clear();
    zzabr.zznY();
    zzabr.zzg(null);
    zzabr.zzabZ.zzpk();
  }
  
  public String getName()
  {
    return "CONNECTED";
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    if (paramInt == 1) {
      zzabr.zzoe();
    }
    Iterator localIterator = zzabr.zzacm.iterator();
    while (localIterator.hasNext()) {
      ((zzli.zzf)localIterator.next()).zzw(new Status(8, "The connection to Google Play services was lost"));
    }
    zzabr.zzg(null);
    zzabr.zzabZ.zzbG(paramInt);
    zzabr.zzabZ.zzpk();
    if (paramInt == 2) {
      zzabr.connect();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zza(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      zzabr.zza(new zzli.zzb(this)
      {
        public void zznO()
        {
          onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */