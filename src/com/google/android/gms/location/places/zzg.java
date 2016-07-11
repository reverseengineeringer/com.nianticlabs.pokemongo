package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<PlaceFilter>
{
  static void zza(PlaceFilter paramPlaceFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, zzaFX, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 3, zzaGl);
    zzb.zzc(paramParcel, 4, zzaGa, false);
    zzb.zzb(paramParcel, 6, zzaFZ, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlaceFilter zzeO(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList2 = null;
    ArrayList localArrayList3 = null;
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
        localArrayList3 = zza.zzC(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 4: 
        localArrayList1 = zza.zzc(paramParcel, k, UserDataType.CREATOR);
        break;
      case 6: 
        localArrayList2 = zza.zzD(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceFilter(i, localArrayList3, bool, localArrayList2, localArrayList1);
  }
  
  public PlaceFilter[] zzhj(int paramInt)
  {
    return new PlaceFilter[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */