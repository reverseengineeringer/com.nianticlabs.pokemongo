package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqc;

public final class zzo
{
  public static final int zzagk = 23 - " PII_LOG".length();
  private static final String zzagl = null;
  private final String zzagm;
  private final String zzagn;
  
  public zzo(String paramString)
  {
    this(paramString, zzagl);
  }
  
  public zzo(String paramString1, String paramString2)
  {
    zzx.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      zzagm = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        break;
      }
      zzagn = zzagl;
      return;
    }
    zzagn = paramString2;
  }
  
  private String zzcp(String paramString)
  {
    if (zzagn == null) {
      return paramString;
    }
    return zzagn.concat(paramString);
  }
  
  public void zza(Context paramContext, String paramString1, String paramString2, Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while ((i < arrayOfStackTraceElement.length) && (i < 2))
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      localStringBuilder.append("\n");
      i += 1;
    }
    paramContext = new zzqc(paramContext, 10);
    paramContext.zza("GMS_WTF", null, new String[] { "GMS_WTF", localStringBuilder.toString() });
    paramContext.send();
    if (zzbH(7))
    {
      Log.e(paramString1, zzcp(paramString2), paramThrowable);
      Log.wtf(paramString1, zzcp(paramString2), paramThrowable);
    }
  }
  
  public void zza(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzbH(4)) {
      Log.i(paramString1, zzcp(paramString2), paramThrowable);
    }
  }
  
  public void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzbH(5)) {
      Log.w(paramString1, zzcp(paramString2), paramThrowable);
    }
  }
  
  public boolean zzbH(int paramInt)
  {
    return Log.isLoggable(zzagm, paramInt);
  }
  
  public void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzbH(6)) {
      Log.e(paramString1, zzcp(paramString2), paramThrowable);
    }
  }
  
  public void zzx(String paramString1, String paramString2)
  {
    if (zzbH(3)) {
      Log.d(paramString1, zzcp(paramString2));
    }
  }
  
  public void zzy(String paramString1, String paramString2)
  {
    if (zzbH(5)) {
      Log.w(paramString1, zzcp(paramString2));
    }
  }
  
  public void zzz(String paramString1, String paramString2)
  {
    if (zzbH(6)) {
      Log.e(paramString1, zzcp(paramString2));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */