package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<LocationSettingsRequest>
{
  static void zza(LocationSettingsRequest paramLocationSettingsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLocationSettingsRequest.zztd(), false);
    zzb.zzc(paramParcel, 1000, paramLocationSettingsRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramLocationSettingsRequest.zzwx());
    zzb.zza(paramParcel, 3, paramLocationSettingsRequest.zzwy());
    zzb.zza(paramParcel, 4, paramLocationSettingsRequest.zzwz());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LocationSettingsRequest zzeC(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LocationSettingsRequest(i, localArrayList, bool3, bool2, bool1);
  }
  
  public LocationSettingsRequest[] zzgS(int paramInt)
  {
    return new LocationSettingsRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */