package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzgr
public final class zzfa
{
  public static int zza(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.zzzU[paramErrorCode.ordinal()])
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static AdSize zzb(AdSizeParcel paramAdSizeParcel)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < arrayOfAdSize.length)
    {
      if ((arrayOfAdSize[i].getWidth() == width) && (arrayOfAdSize[i].getHeight() == height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(zza.zza(width, height, zzte));
  }
  
  public static MediationAdRequest zzh(AdRequestParcel paramAdRequestParcel)
  {
    if (zzsD != null) {}
    for (HashSet localHashSet = new HashSet(zzsD);; localHashSet = null) {
      return new MediationAdRequest(new Date(zzsB), zzr(zzsC), localHashSet, zzsE, zzsJ);
    }
  }
  
  public static AdRequest.Gender zzr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.UNKNOWN;
    case 2: 
      return AdRequest.Gender.FEMALE;
    }
    return AdRequest.Gender.MALE;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */