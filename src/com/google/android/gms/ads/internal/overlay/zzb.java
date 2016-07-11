package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AdLauncherIntentInfoParcel>
{
  static void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, intentAction, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, url, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, mimeType, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, packageName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzAL, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, zzAM, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, zzAN, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public AdLauncherIntentInfoParcel zzf(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str7 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str6 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public AdLauncherIntentInfoParcel[] zzs(int paramInt)
  {
    return new AdLauncherIntentInfoParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */