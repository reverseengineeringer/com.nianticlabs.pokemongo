package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze
  implements Parcelable.Creator<LocationResult>
{
  static void zza(LocationResult paramLocationResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLocationResult.getLocations(), false);
    zzb.zzc(paramParcel, 1000, paramLocationResult.getVersionCode());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LocationResult zzeB(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    Object localObject = LocationResult.zzaEJ;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localObject = zza.zzc(paramParcel, k, Location.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LocationResult(i, (List)localObject);
  }
  
  public LocationResult[] zzgR(int paramInt)
  {
    return new LocationResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */