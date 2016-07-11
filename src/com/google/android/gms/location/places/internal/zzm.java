package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<PlaceLikelihoodEntity>
{
  static void zza(PlaceLikelihoodEntity paramPlaceLikelihoodEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, zzaHA, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaHB);
    zzb.zzI(paramParcel, i);
  }
  
  public PlaceLikelihoodEntity zzeW(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    PlaceImpl localPlaceImpl = null;
    float f = 0.0F;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localPlaceImpl = (PlaceImpl)zza.zza(paramParcel, k, PlaceImpl.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        f = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceLikelihoodEntity(i, localPlaceImpl, f);
  }
  
  public PlaceLikelihoodEntity[] zzhu(int paramInt)
  {
    return new PlaceLikelihoodEntity[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */