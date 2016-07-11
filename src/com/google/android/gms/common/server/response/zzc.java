package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<FieldMappingDictionary>
{
  static void zza(FieldMappingDictionary paramFieldMappingDictionary, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramFieldMappingDictionary.getVersionCode());
    zzb.zzc(paramParcel, 2, paramFieldMappingDictionary.zzpS(), false);
    zzb.zza(paramParcel, 3, paramFieldMappingDictionary.zzpT(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public FieldMappingDictionary zzax(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, k, FieldMappingDictionary.Entry.CREATOR);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FieldMappingDictionary(i, localArrayList, str);
  }
  
  public FieldMappingDictionary[] zzbV(int paramInt)
  {
    return new FieldMappingDictionary[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */