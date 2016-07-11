package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzgr
public final class zzex
  implements NativeMediationAdRequest
{
  private final Date zzaT;
  private final Set<String> zzaV;
  private final boolean zzaW;
  private final Location zzaX;
  private final NativeAdOptionsParcel zzoY;
  private final List<String> zzoZ;
  private final int zzsR;
  private final int zzzI;
  
  public zzex(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean, int paramInt2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
  {
    zzaT = paramDate;
    zzsR = paramInt1;
    zzaV = paramSet;
    zzaX = paramLocation;
    zzaW = paramBoolean;
    zzzI = paramInt2;
    zzoY = paramNativeAdOptionsParcel;
    zzoZ = paramList;
  }
  
  public Date getBirthday()
  {
    return zzaT;
  }
  
  public int getGender()
  {
    return zzsR;
  }
  
  public Set<String> getKeywords()
  {
    return zzaV;
  }
  
  public Location getLocation()
  {
    return zzaX;
  }
  
  public NativeAdOptions getNativeAdOptions()
  {
    if (zzoY == null) {
      return null;
    }
    return new NativeAdOptions.Builder().setReturnUrlsForImageAssets(zzoY.zzwR).setImageOrientation(zzoY.zzwS).setRequestMultipleImages(zzoY.zzwT).build();
  }
  
  public boolean isAppInstallAdRequested()
  {
    return (zzoZ != null) && (zzoZ.contains("2"));
  }
  
  public boolean isContentAdRequested()
  {
    return (zzoZ != null) && (zzoZ.contains("1"));
  }
  
  public boolean isTesting()
  {
    return zzaW;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return zzzI;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */