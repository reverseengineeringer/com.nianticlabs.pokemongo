package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<UserAddressRequest>
{
  static void zza(UserAddressRequest paramUserAddressRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramUserAddressRequest.getVersionCode());
    zzb.zzc(paramParcel, 2, zzaDh, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public UserAddressRequest zzev(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k, CountrySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UserAddressRequest(i, localArrayList);
  }
  
  public UserAddressRequest[] zzgF(int paramInt)
  {
    return new UserAddressRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */