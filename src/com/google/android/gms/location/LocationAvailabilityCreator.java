package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LocationAvailabilityCreator
  implements Parcelable.Creator<LocationAvailability>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void zza(LocationAvailability paramLocationAvailability, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, zzaEA);
    zzb.zzc(paramParcel, 1000, paramLocationAvailability.getVersionCode());
    zzb.zzc(paramParcel, 2, zzaEB);
    zzb.zza(paramParcel, 3, zzaEC);
    zzb.zzc(paramParcel, 4, zzaED);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LocationAvailability createFromParcel(Parcel paramParcel)
  {
    int i = 1;
    int n = zza.zzap(paramParcel);
    int m = 0;
    int k = 1000;
    long l = 0L;
    int j = 1;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 3: 
        l = zza.zzi(paramParcel, i1);
        break;
      case 4: 
        k = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new LocationAvailability(m, k, j, i, l);
  }
  
  public LocationAvailability[] newArray(int paramInt)
  {
    return new LocationAvailability[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationAvailabilityCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */