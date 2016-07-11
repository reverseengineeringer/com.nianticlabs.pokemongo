package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LocationRequestCreator
  implements Parcelable.Creator<LocationRequest>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void zza(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mPriority);
    zzb.zzc(paramParcel, 1000, paramLocationRequest.getVersionCode());
    zzb.zza(paramParcel, 2, zzaEE);
    zzb.zza(paramParcel, 3, zzaEF);
    zzb.zza(paramParcel, 4, zzasP);
    zzb.zza(paramParcel, 5, zzaEj);
    zzb.zzc(paramParcel, 6, zzaEG);
    zzb.zza(paramParcel, 7, zzaEH);
    zzb.zza(paramParcel, 8, zzaEI);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LocationRequest createFromParcel(Parcel paramParcel)
  {
    int m = zza.zzap(paramParcel);
    int k = 0;
    int j = 102;
    long l4 = 3600000L;
    long l3 = 600000L;
    boolean bool = false;
    long l2 = Long.MAX_VALUE;
    int i = Integer.MAX_VALUE;
    float f = 0.0F;
    long l1 = 0L;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        j = zza.zzg(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l4 = zza.zzi(paramParcel, n);
        break;
      case 3: 
        l3 = zza.zzi(paramParcel, n);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 5: 
        l2 = zza.zzi(paramParcel, n);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
        break;
      case 7: 
        f = zza.zzl(paramParcel, n);
        break;
      case 8: 
        l1 = zza.zzi(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new LocationRequest(k, j, l4, l3, bool, l2, i, f, l1);
  }
  
  public LocationRequest[] newArray(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationRequestCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */