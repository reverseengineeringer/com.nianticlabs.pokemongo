package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<AccountChangeEventsResponse>
{
  static void zza(AccountChangeEventsResponse paramAccountChangeEventsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zzc(paramParcel, 2, zzoQ, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AccountChangeEventsResponse zzB(Parcel paramParcel)
  {
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
        localArrayList = zza.zzc(paramParcel, k, AccountChangeEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountChangeEventsResponse(i, localArrayList);
  }
  
  public AccountChangeEventsResponse[] zzas(int paramInt)
  {
    return new AccountChangeEventsResponse[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */