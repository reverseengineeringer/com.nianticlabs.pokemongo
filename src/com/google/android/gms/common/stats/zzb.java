package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb
{
  private static final Object zzafW = new Object();
  private static Integer zzahE;
  private static zzb zzahy;
  private final List<String> zzahA;
  private final List<String> zzahB;
  private final List<String> zzahC;
  private zze zzahD;
  private zze zzahF;
  private final List<String> zzahz;
  
  private zzb()
  {
    if (getLogLevel() == zzd.LOG_LEVEL_OFF)
    {
      zzahz = Collections.EMPTY_LIST;
      zzahA = Collections.EMPTY_LIST;
      zzahB = Collections.EMPTY_LIST;
      zzahC = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzc.zza.zzahI.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      zzahz = ((List)localObject);
      localObject = (String)zzc.zza.zzahJ.get();
      if (localObject != null) {
        break label200;
      }
      localObject = Collections.EMPTY_LIST;
      label83:
      zzahA = ((List)localObject);
      localObject = (String)zzc.zza.zzahK.get();
      if (localObject != null) {
        break label213;
      }
      localObject = Collections.EMPTY_LIST;
      label106:
      zzahB = ((List)localObject);
      localObject = (String)zzc.zza.zzahL.get();
      if (localObject != null) {
        break label226;
      }
    }
    label200:
    label213:
    label226:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      zzahC = ((List)localObject);
      zzahD = new zze(1024, ((Long)zzc.zza.zzahM.get()).longValue());
      zzahF = new zze(1024, ((Long)zzc.zza.zzahM.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label83;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label106;
    }
  }
  
  private static int getLogLevel()
  {
    if (zzahE == null) {}
    for (;;)
    {
      try
      {
        if (!zzmm.zzjA()) {
          continue;
        }
        i = ((Integer)zzc.zza.zzahH.get()).intValue();
        zzahE = Integer.valueOf(i);
      }
      catch (SecurityException localSecurityException)
      {
        int i;
        zzahE = Integer.valueOf(zzd.LOG_LEVEL_OFF);
        continue;
      }
      return zzahE.intValue();
      i = zzd.LOG_LEVEL_OFF;
    }
  }
  
  private void zza(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    long l2 = System.currentTimeMillis();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((getLogLevel() & zzd.zzahR) != 0)
    {
      localObject1 = localObject2;
      if (paramInt != 13) {
        localObject1 = zzmy.zzl(3, 5);
      }
    }
    long l1 = 0L;
    if ((getLogLevel() & zzd.zzahT) != 0) {
      l1 = Debug.getNativeHeapAllocatedSize();
    }
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 14)) {}
    for (paramString1 = new ConnectionEvent(l2, paramInt, null, null, null, null, (String)localObject1, paramString1, SystemClock.elapsedRealtime(), l1);; paramString1 = new ConnectionEvent(l2, paramInt, paramString2, paramString3, paramString4, paramString5, (String)localObject1, paramString1, SystemClock.elapsedRealtime(), l1))
    {
      paramContext.startService(new Intent().setComponent(zzd.zzahN).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    Object localObject2 = null;
    if ((!zzqi()) || (zzahD == null)) {}
    do
    {
      return;
      if ((paramInt != 4) && (paramInt != 1)) {
        break;
      }
    } while (!zzahD.zzcy(paramString1));
    Object localObject1 = null;
    String str = null;
    paramIntent = (Intent)localObject2;
    for (;;)
    {
      zza(paramContext, paramString1, paramInt, paramIntent, paramString2, str, (String)localObject1);
      return;
      localObject1 = zzd(paramContext, paramIntent);
      if (localObject1 == null)
      {
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] { paramString2, paramIntent.toUri(0) }));
        return;
      }
      str = processName;
      localObject1 = name;
      paramIntent = zzmy.zzaq(paramContext);
      if (!zzb(paramIntent, paramString2, str, (String)localObject1)) {
        break;
      }
      zzahD.zzcx(paramString1);
    }
  }
  
  private String zzb(ServiceConnection paramServiceConnection)
  {
    return String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
  }
  
  private boolean zzb(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = getLogLevel();
    return (!zzahz.contains(paramString1)) && (!zzahA.contains(paramString2)) && (!zzahB.contains(paramString3)) && (!zzahC.contains(paramString4)) && ((!paramString3.equals(paramString1)) || ((i & zzd.zzahS) == 0));
  }
  
  private boolean zzc(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if ((paramIntent == null) || ((com.google.android.gms.common.internal.zzd.zzaeK) && ("com.google.android.gms".equals(paramIntent.getPackageName())))) {
      return false;
    }
    return zzmm.zzl(paramContext, paramIntent.getPackageName());
  }
  
  private static ServiceInfo zzd(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zzmy.zzl(3, 20) }));
      return null;
    }
    if (paramContext.size() > 1)
    {
      Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zzmy.zzl(3, 20) }));
      paramIntent = paramContext.iterator();
      if (paramIntent.hasNext())
      {
        Log.w("ConnectionTracker", nextserviceInfo.name);
        return null;
      }
    }
    return get0serviceInfo;
  }
  
  public static zzb zzqh()
  {
    synchronized (zzafW)
    {
      if (zzahy == null) {
        zzahy = new zzb();
      }
      return zzahy;
    }
  }
  
  private boolean zzqi()
  {
    if (!com.google.android.gms.common.internal.zzd.zzaeK) {}
    while (getLogLevel() == zzd.LOG_LEVEL_OFF) {
      return false;
    }
    return true;
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    zza(paramContext, zzb(paramServiceConnection), null, null, 1);
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent)
  {
    zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 3);
  }
  
  public boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zzc(paramContext, paramIntent))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    boolean bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool) {
      zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 2);
    }
    return bool;
  }
  
  public void zzb(Context paramContext, ServiceConnection paramServiceConnection)
  {
    zza(paramContext, zzb(paramServiceConnection), null, null, 4);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */