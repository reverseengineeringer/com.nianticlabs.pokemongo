package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.zzb;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm$zzb
{
  private int mState;
  private IBinder zzaeJ;
  private ComponentName zzagb;
  private final zza zzagc;
  private final Set<ServiceConnection> zzagd;
  private boolean zzage;
  private final zzm.zza zzagf;
  
  public zzm$zzb(zzm paramzzm, zzm.zza paramzza)
  {
    zzagf = paramzza;
    zzagc = new zza();
    zzagd = new HashSet();
    mState = 2;
  }
  
  public IBinder getBinder()
  {
    return zzaeJ;
  }
  
  public ComponentName getComponentName()
  {
    return zzagb;
  }
  
  public int getState()
  {
    return mState;
  }
  
  public boolean isBound()
  {
    return zzage;
  }
  
  public void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    zzm.zzc(zzagg).zza(zzm.zzb(zzagg), paramServiceConnection, paramString, zzagf.zzpm());
    zzagd.add(paramServiceConnection);
  }
  
  public boolean zza(ServiceConnection paramServiceConnection)
  {
    return zzagd.contains(paramServiceConnection);
  }
  
  public void zzb(ServiceConnection paramServiceConnection, String paramString)
  {
    zzm.zzc(zzagg).zzb(zzm.zzb(zzagg), paramServiceConnection);
    zzagd.remove(paramServiceConnection);
  }
  
  public void zzcm(String paramString)
  {
    mState = 3;
    zzage = zzm.zzc(zzagg).zza(zzm.zzb(zzagg), paramString, zzagf.zzpm(), zzagc, 129);
    if (!zzage) {
      mState = 2;
    }
    try
    {
      zzm.zzc(zzagg).zza(zzm.zzb(zzagg), zzagc);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public void zzcn(String paramString)
  {
    zzm.zzc(zzagg).zza(zzm.zzb(zzagg), zzagc);
    zzage = false;
    mState = 2;
  }
  
  public boolean zzpn()
  {
    return zzagd.isEmpty();
  }
  
  public class zza
    implements ServiceConnection
  {
    public zza() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      synchronized (zzm.zza(zzagg))
      {
        zzm.zzb.zza(zzm.zzb.this, paramIBinder);
        zzm.zzb.zza(zzm.zzb.this, paramComponentName);
        Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
      }
      zzm.zzb.zza(zzm.zzb.this, 1);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (zzm.zza(zzagg))
      {
        zzm.zzb.zza(zzm.zzb.this, null);
        zzm.zzb.zza(zzm.zzb.this, paramComponentName);
        Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
      }
      zzm.zzb.zza(zzm.zzb.this, 2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */