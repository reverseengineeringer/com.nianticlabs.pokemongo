package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzgr
public final class zzib
{
  public static Future zza(Context paramContext, final int paramInt)
  {
    new zza(paramContext)
    {
      public void zzbn()
      {
        SharedPreferences.Editor localEditor = zzib.zzG(zzry).edit();
        localEditor.putInt("webview_cache_version", paramInt);
        localEditor.apply();
      }
    }.zzgz();
  }
  
  public static Future zza(Context paramContext, final zzb paramzzb)
  {
    new zza(paramContext)
    {
      public void zzbn()
      {
        SharedPreferences localSharedPreferences = zzib.zzG(zzry);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("use_https", localSharedPreferences.getBoolean("use_https", true));
        if (paramzzb != null) {
          paramzzb.zzd(localBundle);
        }
      }
    }.zzgz();
  }
  
  public static Future zza(Context paramContext, final boolean paramBoolean)
  {
    new zza(paramContext)
    {
      public void zzbn()
      {
        SharedPreferences.Editor localEditor = zzib.zzG(zzry).edit();
        localEditor.putBoolean("use_https", paramBoolean);
        localEditor.apply();
      }
    }.zzgz();
  }
  
  public static Future zzb(Context paramContext, final zzb paramzzb)
  {
    new zza(paramContext)
    {
      public void zzbn()
      {
        SharedPreferences localSharedPreferences = zzib.zzG(zzry);
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_cache_version", localSharedPreferences.getInt("webview_cache_version", 0));
        if (paramzzb != null) {
          paramzzb.zzd(localBundle);
        }
      }
    }.zzgz();
  }
  
  private static SharedPreferences zzv(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }
  
  private static abstract class zza
    extends zzhz
  {
    public void onStop() {}
  }
  
  public static abstract interface zzb
  {
    public abstract void zzd(Bundle paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzib
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */