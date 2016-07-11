package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;
import java.util.ArrayList;
import java.util.Iterator;

public class zzf
  extends zzj<zza>
{
  private final String zzQe;
  private final zzd zzaRZ;
  private final zzb zzaSa;
  private boolean zzaSb;
  private final Object zzpd;
  
  public zzf(Context paramContext, Looper paramLooper, zzd paramzzd, com.google.android.gms.common.internal.zzf paramzzf)
  {
    super(paramContext, paramLooper, 24, paramzzf, paramzzd, paramzzd);
    zzQe = paramContext.getPackageName();
    zzaRZ = ((zzd)zzx.zzw(paramzzd));
    zzaRZ.zza(this);
    zzaSa = new zzb();
    zzpd = new Object();
    zzaSb = true;
  }
  
  private void zzBv()
  {
    boolean bool;
    if (!zzaSb)
    {
      bool = true;
      com.google.android.gms.common.internal.zzb.zzZ(bool);
      if (!zzaSa.isEmpty()) {
        Object localObject = null;
      }
    }
    label122:
    label195:
    label228:
    for (;;)
    {
      ArrayList localArrayList;
      zzb.zza localzza;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = zzaSa.zzBt().iterator();
        if (!localIterator.hasNext()) {
          break label195;
        }
        localzza = (zzb.zza)localIterator.next();
        if (zzaRO == null) {
          break label122;
        }
        ((zza)zzpc()).zza(zzQe, zzaRM, zzse.zzf(zzaRO));
        continue;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
      }
      bool = false;
      break;
      if (zzaRM.equals(localRemoteException))
      {
        localArrayList.add(zzaRN);
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          ((zza)zzpc()).zza(zzQe, localRemoteException, localArrayList);
          localArrayList.clear();
        }
        PlayLoggerContext localPlayLoggerContext = zzaRM;
        localArrayList.add(zzaRN);
        break label228;
        if (!localArrayList.isEmpty()) {
          ((zza)zzpc()).zza(zzQe, localPlayLoggerContext, localArrayList);
        }
        zzaSa.clear();
        return;
      }
    }
  }
  
  private void zzc(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    zzaSa.zza(paramPlayLoggerContext, paramLogEvent);
  }
  
  private void zzd(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    try
    {
      zzBv();
      ((zza)zzpc()).zza(zzQe, paramPlayLoggerContext, paramLogEvent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
      zzc(paramPlayLoggerContext, paramLogEvent);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
      zzc(paramPlayLoggerContext, paramLogEvent);
    }
  }
  
  public void start()
  {
    synchronized (zzpd)
    {
      if ((isConnecting()) || (isConnected())) {
        return;
      }
      zzaRZ.zzao(true);
      zzoZ();
      return;
    }
  }
  
  public void stop()
  {
    synchronized (zzpd)
    {
      zzaRZ.zzao(false);
      disconnect();
      return;
    }
  }
  
  void zzap(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      boolean bool = zzaSb;
      zzaSb = paramBoolean;
      if ((bool) && (!zzaSb)) {
        zzBv();
      }
      return;
    }
  }
  
  public void zzb(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    synchronized (zzpd)
    {
      if (zzaSb)
      {
        zzc(paramPlayLoggerContext, paramLogEvent);
        return;
      }
      zzd(paramPlayLoggerContext, paramLogEvent);
    }
  }
  
  protected zza zzdA(IBinder paramIBinder)
  {
    return zza.zza.zzdz(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.playlog.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.playlog.internal.IPlayLogService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */