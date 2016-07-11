package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<AdRequestInfoParcel>
{
  static void zza(AdRequestInfoParcel paramAdRequestInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzEm, false);
    zzb.zza(paramParcel, 3, zzEn, paramInt, false);
    zzb.zza(paramParcel, 4, zzqn, paramInt, false);
    zzb.zza(paramParcel, 5, zzqh, false);
    zzb.zza(paramParcel, 6, applicationInfo, paramInt, false);
    zzb.zza(paramParcel, 7, zzEo, paramInt, false);
    zzb.zza(paramParcel, 8, zzEp, false);
    zzb.zza(paramParcel, 9, zzEq, false);
    zzb.zza(paramParcel, 10, zzEr, false);
    zzb.zza(paramParcel, 11, zzqj, paramInt, false);
    zzb.zza(paramParcel, 12, zzEs, false);
    zzb.zzc(paramParcel, 13, zzEt);
    zzb.zzb(paramParcel, 14, zzqD, false);
    zzb.zza(paramParcel, 15, zzEu, false);
    zzb.zza(paramParcel, 17, zzEw, paramInt, false);
    zzb.zza(paramParcel, 16, zzEv);
    zzb.zzc(paramParcel, 19, zzEy);
    zzb.zzc(paramParcel, 18, zzEx);
    zzb.zza(paramParcel, 21, zzEA, false);
    zzb.zza(paramParcel, 20, zzEz);
    zzb.zza(paramParcel, 25, zzEB);
    zzb.zzb(paramParcel, 27, zzED, false);
    zzb.zza(paramParcel, 26, zzEC, false);
    zzb.zza(paramParcel, 29, zzqB, paramInt, false);
    zzb.zza(paramParcel, 28, zzqg, false);
    zzb.zza(paramParcel, 31, zzEF);
    zzb.zzb(paramParcel, 30, zzEE, false);
    zzb.zza(paramParcel, 32, zzEG, paramInt, false);
    zzb.zza(paramParcel, 33, zzEH, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdRequestInfoParcel[] zzD(int paramInt)
  {
    return new AdRequestInfoParcel[paramInt];
  }
  
  public AdRequestInfoParcel zzi(Parcel paramParcel)
  {
    int n = zza.zzap(paramParcel);
    int m = 0;
    Bundle localBundle3 = null;
    AdRequestParcel localAdRequestParcel = null;
    AdSizeParcel localAdSizeParcel = null;
    String str8 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    VersionInfoParcel localVersionInfoParcel = null;
    Bundle localBundle2 = null;
    int k = 0;
    ArrayList localArrayList3 = null;
    Bundle localBundle1 = null;
    boolean bool = false;
    Messenger localMessenger = null;
    int j = 0;
    int i = 0;
    float f = 0.0F;
    String str4 = null;
    long l2 = 0L;
    String str3 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    NativeAdOptionsParcel localNativeAdOptionsParcel = null;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    CapabilityParcel localCapabilityParcel = null;
    String str1 = null;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      case 22: 
      case 23: 
      case 24: 
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        localBundle3 = zza.zzr(paramParcel, i1);
        break;
      case 3: 
        localAdRequestParcel = (AdRequestParcel)zza.zza(paramParcel, i1, AdRequestParcel.CREATOR);
        break;
      case 4: 
        localAdSizeParcel = (AdSizeParcel)zza.zza(paramParcel, i1, AdSizeParcel.CREATOR);
        break;
      case 5: 
        str8 = zza.zzp(paramParcel, i1);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)zza.zza(paramParcel, i1, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)zza.zza(paramParcel, i1, PackageInfo.CREATOR);
        break;
      case 8: 
        str7 = zza.zzp(paramParcel, i1);
        break;
      case 9: 
        str6 = zza.zzp(paramParcel, i1);
        break;
      case 10: 
        str5 = zza.zzp(paramParcel, i1);
        break;
      case 11: 
        localVersionInfoParcel = (VersionInfoParcel)zza.zza(paramParcel, i1, VersionInfoParcel.CREATOR);
        break;
      case 12: 
        localBundle2 = zza.zzr(paramParcel, i1);
        break;
      case 13: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 14: 
        localArrayList3 = zza.zzD(paramParcel, i1);
        break;
      case 15: 
        localBundle1 = zza.zzr(paramParcel, i1);
        break;
      case 17: 
        localMessenger = (Messenger)zza.zza(paramParcel, i1, Messenger.CREATOR);
        break;
      case 16: 
        bool = zza.zzc(paramParcel, i1);
        break;
      case 19: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 18: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 21: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 20: 
        f = zza.zzl(paramParcel, i1);
        break;
      case 25: 
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 27: 
        localArrayList2 = zza.zzD(paramParcel, i1);
        break;
      case 26: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 29: 
        localNativeAdOptionsParcel = (NativeAdOptionsParcel)zza.zza(paramParcel, i1, NativeAdOptionsParcel.CREATOR);
        break;
      case 28: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 31: 
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 30: 
        localArrayList1 = zza.zzD(paramParcel, i1);
        break;
      case 32: 
        localCapabilityParcel = (CapabilityParcel)zza.zza(paramParcel, i1, CapabilityParcel.CREATOR);
        break;
      case 33: 
        str1 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new AdRequestInfoParcel(m, localBundle3, localAdRequestParcel, localAdSizeParcel, str8, localApplicationInfo, localPackageInfo, str7, str6, str5, localVersionInfoParcel, localBundle2, k, localArrayList3, localBundle1, bool, localMessenger, j, i, f, str4, l2, str3, localArrayList2, str2, localNativeAdOptionsParcel, localArrayList1, l1, localCapabilityParcel, str1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */