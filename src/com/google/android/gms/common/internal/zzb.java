package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class zzb
{
  public static void zzZ(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void zza(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void zzci(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzcj(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzs(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null reference");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */