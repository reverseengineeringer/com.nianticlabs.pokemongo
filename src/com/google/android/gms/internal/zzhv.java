package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public class zzhv
{
  final String zzHP;
  long zzId = -1L;
  long zzIe = -1L;
  int zzIf = -1;
  int zzIg = 0;
  int zzIh = 0;
  private final Object zzpd = new Object();
  
  public zzhv(String paramString)
  {
    zzHP = paramString;
  }
  
  public static boolean zzF(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == getPackageManagergetActivityInfo0theme) {
        return true;
      }
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzb.zzaH("Fail to fetch AdActivity theme");
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public void zzb(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    synchronized (zzpd)
    {
      if (zzIe == -1L)
      {
        zzIe = paramLong;
        zzId = zzIe;
        if ((extras == null) || (extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        zzId = paramLong;
      }
    }
    zzIf += 1;
  }
  
  public Bundle zze(Context paramContext, String paramString)
  {
    synchronized (zzpd)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", zzHP);
      localBundle.putLong("basets", zzIe);
      localBundle.putLong("currts", zzId);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", zzIf);
      localBundle.putInt("pclick", zzIg);
      localBundle.putInt("pimp", zzIh);
      localBundle.putBoolean("support_transparent_background", zzF(paramContext));
      return localBundle;
    }
  }
  
  public void zzgf()
  {
    synchronized (zzpd)
    {
      zzIh += 1;
      return;
    }
  }
  
  public void zzgg()
  {
    synchronized (zzpd)
    {
      zzIg += 1;
      return;
    }
  }
  
  public long zzgx()
  {
    return zzIe;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */