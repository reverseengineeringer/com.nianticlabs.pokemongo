package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public class zzlh
  implements zzlj
{
  private final zzli zzabr;
  
  public zzlh(zzli paramzzli)
  {
    zzabr = paramzzli;
  }
  
  public void begin()
  {
    zzabr.zznZ();
    zzabr.zzaci = Collections.emptySet();
  }
  
  public void connect()
  {
    zzabr.zzoa();
  }
  
  public void disconnect()
  {
    Iterator localIterator = zzabr.zzaca.iterator();
    while (localIterator.hasNext())
    {
      zzli.zzf localzzf = (zzli.zzf)localIterator.next();
      localzzf.zza(null);
      localzzf.cancel();
    }
    zzabr.zzaca.clear();
    zzabr.zzach.clear();
    zzabr.zznY();
  }
  
  public String getName()
  {
    return "DISCONNECTED";
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt) {}
  
  public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T paramT)
  {
    zzabr.zzaca.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */