package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class zzb
{
  public static void e(String paramString)
  {
    if (zzN(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void v(String paramString)
  {
    if (zzN(2)) {
      Log.v("Ads", paramString);
    }
  }
  
  public static boolean zzN(int paramInt)
  {
    return ((paramInt >= 5) || (Log.isLoggable("Ads", paramInt))) && ((paramInt != 2) || (zzgU()));
  }
  
  public static void zza(String paramString, Throwable paramThrowable)
  {
    if (zzN(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzaF(String paramString)
  {
    if (zzN(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void zzaG(String paramString)
  {
    if (zzN(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void zzaH(String paramString)
  {
    if (zzN(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void zzb(String paramString, Throwable paramThrowable)
  {
    if (zzN(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzc(String paramString, Throwable paramThrowable)
  {
    if (zzN(4)) {
      Log.i("Ads", paramString, paramThrowable);
    }
  }
  
  public static void zzd(String paramString, Throwable paramThrowable)
  {
    if (zzN(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static boolean zzgU()
  {
    return ((Boolean)zzby.zzvl.get()).booleanValue();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */