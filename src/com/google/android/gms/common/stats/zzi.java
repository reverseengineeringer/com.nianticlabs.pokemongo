package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmr;
import java.util.List;

public class zzi
{
  private static String TAG = "WakeLockTracker";
  private static Integer zzahE;
  private static zzi zzaii = new zzi();
  
  private static int getLogLevel()
  {
    try
    {
      if (zzmm.zzjA()) {
        return ((Integer)zzc.zzb.zzahH.get()).intValue();
      }
      int i = zzd.LOG_LEVEL_OFF;
      return i;
    }
    catch (SecurityException localSecurityException) {}
    return zzd.LOG_LEVEL_OFF;
  }
  
  private static boolean zzam(Context paramContext)
  {
    if (zzahE == null) {
      zzahE = Integer.valueOf(getLogLevel());
    }
    return zzahE.intValue() != zzd.LOG_LEVEL_OFF;
  }
  
  public static zzi zzqr()
  {
    return zzaii;
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, List<String> paramList)
  {
    zza(paramContext, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramList, 0L);
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, List<String> paramList, long paramLong)
  {
    if (!zzam(paramContext)) {}
    long l;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        Log.e(TAG, "missing wakeLock key. " + paramString1);
        return;
      }
      l = System.currentTimeMillis();
    } while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    paramString1 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, paramList, paramString1, SystemClock.elapsedRealtime(), zzmr.zzao(paramContext), paramString3, paramContext.getPackageName(), zzmr.zzap(paramContext), paramLong);
    try
    {
      paramContext.startService(new Intent().setComponent(zzd.zzahN).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
    catch (Exception paramContext)
    {
      Log.wtf(TAG, paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */