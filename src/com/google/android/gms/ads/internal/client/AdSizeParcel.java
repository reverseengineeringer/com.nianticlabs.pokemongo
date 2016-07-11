package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public class AdSizeParcel
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  public final String zzte;
  public final boolean zztf;
  public final AdSizeParcel[] zztg;
  public final boolean zzth;
  public final boolean zzti;
  
  public AdSizeParcel()
  {
    this(4, "interstitial_mb", 0, 0, true, 0, 0, null, false, false);
  }
  
  AdSizeParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, AdSizeParcel[] paramArrayOfAdSizeParcel, boolean paramBoolean2, boolean paramBoolean3)
  {
    versionCode = paramInt1;
    zzte = paramString;
    height = paramInt2;
    heightPixels = paramInt3;
    zztf = paramBoolean1;
    width = paramInt4;
    widthPixels = paramInt5;
    zztg = paramArrayOfAdSizeParcel;
    zzth = paramBoolean2;
    zzti = paramBoolean3;
  }
  
  public AdSizeParcel(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public AdSizeParcel(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    versionCode = 4;
    zztf = false;
    zzti = localAdSize.isFluid();
    int j;
    label66:
    int k;
    label78:
    DisplayMetrics localDisplayMetrics;
    label129:
    int m;
    int i;
    if (zzti)
    {
      width = AdSize.BANNER.getWidth();
      height = AdSize.BANNER.getHeight();
      if (width != -1) {
        break label312;
      }
      j = 1;
      if (height != -2) {
        break label318;
      }
      k = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (j == 0) {
        break label336;
      }
      if ((!zzl.zzcF().zzS(paramContext)) || (!zzl.zzcF().zzT(paramContext))) {
        break label324;
      }
      widthPixels = (zza(localDisplayMetrics) - zzl.zzcF().zzU(paramContext));
      double d = widthPixels / density;
      m = (int)d;
      i = m;
      if (d - (int)d >= 0.01D) {
        i = m + 1;
      }
      label168:
      if (k == 0) {
        break label361;
      }
      m = zzc(localDisplayMetrics);
      label180:
      heightPixels = zzl.zzcF().zza(localDisplayMetrics, m);
      if ((j == 0) && (k == 0)) {
        break label370;
      }
      zzte = (i + "x" + m + "_as");
    }
    for (;;)
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label398;
      }
      zztg = new AdSizeParcel[paramArrayOfAdSize.length];
      i = 0;
      while (i < paramArrayOfAdSize.length)
      {
        zztg[i] = new AdSizeParcel(paramContext, paramArrayOfAdSize[i]);
        i += 1;
      }
      width = localAdSize.getWidth();
      height = localAdSize.getHeight();
      break;
      label312:
      j = 0;
      break label66;
      label318:
      k = 0;
      break label78;
      label324:
      widthPixels = zza(localDisplayMetrics);
      break label129;
      label336:
      i = width;
      widthPixels = zzl.zzcF().zza(localDisplayMetrics, width);
      break label168;
      label361:
      m = height;
      break label180;
      label370:
      if (zzti) {
        zzte = "320x50_mb";
      } else {
        zzte = localAdSize.toString();
      }
    }
    label398:
    zztg = null;
    zzth = false;
  }
  
  public AdSizeParcel(AdSizeParcel paramAdSizeParcel, AdSizeParcel[] paramArrayOfAdSizeParcel)
  {
    this(4, zzte, height, heightPixels, zztf, width, widthPixels, paramArrayOfAdSizeParcel, zzth, zzti);
  }
  
  public static int zza(DisplayMetrics paramDisplayMetrics)
  {
    return widthPixels;
  }
  
  public static int zzb(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(zzc(paramDisplayMetrics) * density);
  }
  
  private static int zzc(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(heightPixels / density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public static AdSizeParcel zzcC()
  {
    return new AdSizeParcel(4, "reward_mb", 0, 0, false, 0, 0, null, false, false);
  }
  
  public static AdSizeParcel zzs(Context paramContext)
  {
    return new AdSizeParcel(4, "320x50_mb", 0, 0, false, 0, 0, null, true, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public AdSize zzcD()
  {
    return com.google.android.gms.ads.zza.zza(width, height, zzte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdSizeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */