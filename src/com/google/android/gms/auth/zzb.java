package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AccountChangeEventsRequest>
{
  static void zza(AccountChangeEventsRequest paramAccountChangeEventsRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersion);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, zzRu);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzRs, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzQd, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public AccountChangeEventsRequest zzA(Parcel paramParcel)
  {
    Account localAccount = null;
    int j = 0;
    int k = zza.zzap(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str = zza.zzp(paramParcel, m);
        break;
      case 4: 
        localAccount = (Account)zza.zza(paramParcel, m, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new AccountChangeEventsRequest(i, j, str, localAccount);
  }
  
  public AccountChangeEventsRequest[] zzar(int paramInt)
  {
    return new AccountChangeEventsRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */