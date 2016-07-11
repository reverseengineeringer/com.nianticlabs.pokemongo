package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

@Deprecated
public class zzqc
  implements zzqd.zza
{
  private final zzqd zzaRC;
  private boolean zzaRD;
  
  public zzqc(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null);
  }
  
  public zzqc(Context paramContext, int paramInt, String paramString)
  {
    this(paramContext, paramInt, paramString, null, true);
  }
  
  public zzqc(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramContext != paramContext.getApplicationContext()) {}
    for (String str = paramContext.getClass().getName();; str = "OneTimePlayLogger")
    {
      zzaRC = new zzqd(paramContext, paramInt, paramString1, paramString2, this, paramBoolean, str);
      zzaRD = true;
      return;
    }
  }
  
  private void zzBq()
  {
    if (!zzaRD) {
      throw new IllegalStateException("Cannot reuse one-time logger after sending.");
    }
  }
  
  public void send()
  {
    zzBq();
    zzaRC.start();
    zzaRD = false;
  }
  
  public void zzBr()
  {
    zzaRC.stop();
  }
  
  public void zzBs()
  {
    Log.w("OneTimePlayLogger", "logger connection failed");
  }
  
  public void zza(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    zzBq();
    zzaRC.zzb(paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public void zzf(PendingIntent paramPendingIntent)
  {
    Log.w("OneTimePlayLogger", "logger connection failed: " + paramPendingIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */