package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Locale;

@zzgr
public final class zzgy
{
  public final int zzEx;
  public final int zzEy;
  public final float zzEz;
  public final boolean zzGA;
  public final String zzGB;
  public final String zzGC;
  public final int zzGD;
  public final int zzGE;
  public final int zzGF;
  public final int zzGG;
  public final int zzGH;
  public final int zzGI;
  public final double zzGJ;
  public final boolean zzGK;
  public final boolean zzGL;
  public final int zzGM;
  public final String zzGN;
  public final int zzGs;
  public final boolean zzGt;
  public final boolean zzGu;
  public final String zzGv;
  public final String zzGw;
  public final boolean zzGx;
  public final boolean zzGy;
  public final boolean zzGz;
  
  zzgy(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat, int paramInt8, int paramInt9, double paramDouble, boolean paramBoolean7, boolean paramBoolean8, int paramInt10, String paramString5)
  {
    zzGs = paramInt1;
    zzGt = paramBoolean1;
    zzGu = paramBoolean2;
    zzGv = paramString1;
    zzGw = paramString2;
    zzGx = paramBoolean3;
    zzGy = paramBoolean4;
    zzGz = paramBoolean5;
    zzGA = paramBoolean6;
    zzGB = paramString3;
    zzGC = paramString4;
    zzGD = paramInt2;
    zzGE = paramInt3;
    zzGF = paramInt4;
    zzGG = paramInt5;
    zzGH = paramInt6;
    zzGI = paramInt7;
    zzEz = paramFloat;
    zzEx = paramInt8;
    zzEy = paramInt9;
    zzGJ = paramDouble;
    zzGK = paramBoolean7;
    zzGL = paramBoolean8;
    zzGM = paramInt10;
    zzGN = paramString5;
  }
  
  public static final class zza
  {
    private int zzEx;
    private int zzEy;
    private float zzEz;
    private boolean zzGA;
    private String zzGB;
    private String zzGC;
    private int zzGD;
    private int zzGE;
    private int zzGF;
    private int zzGG;
    private int zzGH;
    private int zzGI;
    private double zzGJ;
    private boolean zzGK;
    private boolean zzGL;
    private int zzGM;
    private String zzGN;
    private int zzGs;
    private boolean zzGt;
    private boolean zzGu;
    private String zzGv;
    private String zzGw;
    private boolean zzGx;
    private boolean zzGy;
    private boolean zzGz;
    
    public zza(Context paramContext)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      zzz(paramContext);
      zza(paramContext, localPackageManager);
      zzA(paramContext);
      Locale localLocale = Locale.getDefault();
      boolean bool1;
      if (zza(localPackageManager, "geo:0,0?q=donuts") != null)
      {
        bool1 = true;
        zzGt = bool1;
        if (zza(localPackageManager, "http://www.google.com") == null) {
          break label128;
        }
        bool1 = bool2;
        label63:
        zzGu = bool1;
        zzGw = localLocale.getCountry();
        zzGx = zzl.zzcF().zzgS();
        zzGy = GooglePlayServicesUtil.zzag(paramContext);
        zzGB = localLocale.getLanguage();
        zzGC = zza(localPackageManager);
        paramContext = paramContext.getResources();
        if (paramContext != null) {
          break label133;
        }
      }
      label128:
      label133:
      do
      {
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label63;
        paramContext = paramContext.getDisplayMetrics();
      } while (paramContext == null);
      zzEz = density;
      zzEx = widthPixels;
      zzEy = heightPixels;
    }
    
    public zza(Context paramContext, zzgy paramzzgy)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      zzz(paramContext);
      zza(paramContext, localPackageManager);
      zzA(paramContext);
      zzB(paramContext);
      zzGt = zzGt;
      zzGu = zzGu;
      zzGw = zzGw;
      zzGx = zzGx;
      zzGy = zzGy;
      zzGB = zzGB;
      zzGC = zzGC;
      zzEz = zzEz;
      zzEx = zzEx;
      zzEy = zzEy;
    }
    
    private void zzA(Context paramContext)
    {
      boolean bool = false;
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext != null)
      {
        int i = paramContext.getIntExtra("status", -1);
        int j = paramContext.getIntExtra("level", -1);
        int k = paramContext.getIntExtra("scale", -1);
        zzGJ = (j / k);
        if ((i == 2) || (i == 5)) {
          bool = true;
        }
        zzGK = bool;
        return;
      }
      zzGJ = -1.0D;
      zzGK = false;
    }
    
    private void zzB(Context paramContext)
    {
      zzGN = Build.FINGERPRINT;
    }
    
    private static ResolveInfo zza(PackageManager paramPackageManager, String paramString)
    {
      return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
    }
    
    private static String zza(PackageManager paramPackageManager)
    {
      Object localObject = zza(paramPackageManager, "market://details?id=com.google.android.gms.ads");
      if (localObject == null) {}
      for (;;)
      {
        return null;
        localObject = activityInfo;
        if (localObject != null) {
          try
          {
            paramPackageManager = paramPackageManager.getPackageInfo(packageName, 0);
            if (paramPackageManager != null)
            {
              paramPackageManager = versionCode + "." + packageName;
              return paramPackageManager;
            }
          }
          catch (PackageManager.NameNotFoundException paramPackageManager) {}
        }
      }
      return null;
    }
    
    private void zza(Context paramContext, PackageManager paramPackageManager)
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      zzGv = localTelephonyManager.getNetworkOperator();
      zzGF = localTelephonyManager.getNetworkType();
      zzGG = localTelephonyManager.getPhoneType();
      zzGE = -2;
      zzGL = false;
      zzGM = -1;
      if (zzp.zzbv().zza(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if (paramContext == null) {
          break label127;
        }
        zzGE = paramContext.getType();
        zzGM = paramContext.getDetailedState().ordinal();
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          zzGL = localConnectivityManager.isActiveNetworkMetered();
        }
        return;
        label127:
        zzGE = -1;
      }
    }
    
    private void zzz(Context paramContext)
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      zzGs = paramContext.getMode();
      zzGz = paramContext.isMusicActive();
      zzGA = paramContext.isSpeakerphoneOn();
      zzGD = paramContext.getStreamVolume(3);
      zzGH = paramContext.getRingerMode();
      zzGI = paramContext.getStreamVolume(2);
    }
    
    public zzgy zzfX()
    {
      return new zzgy(zzGs, zzGt, zzGu, zzGv, zzGw, zzGx, zzGy, zzGz, zzGA, zzGB, zzGC, zzGD, zzGE, zzGF, zzGG, zzGH, zzGI, zzEz, zzEx, zzEy, zzGJ, zzGK, zzGL, zzGM, zzGN);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */