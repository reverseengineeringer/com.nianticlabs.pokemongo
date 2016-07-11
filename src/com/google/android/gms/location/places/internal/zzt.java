package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt
  implements Parcelable.Creator<PlacesParams>
{
  static void zza(PlacesParams paramPlacesParams, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, zzaHR, false);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zza(paramParcel, 2, zzaHS, false);
    zzb.zza(paramParcel, 3, zzaHT, false);
    zzb.zza(paramParcel, 4, zzaGG, false);
    zzb.zza(paramParcel, 5, zzaHU, false);
    zzb.zzc(paramParcel, 6, zzaHV);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlacesParams zzeY(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzap(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str5 = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str4 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 6: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PlacesParams(j, str5, str4, str3, str2, str1, i);
  }
  
  public PlacesParams[] zzhw(int paramInt)
  {
    return new PlacesParams[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */