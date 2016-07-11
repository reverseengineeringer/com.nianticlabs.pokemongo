package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy
  implements Parcelable.Creator<ResolveAccountRequest>
{
  static void zza(ResolveAccountRequest paramResolveAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramResolveAccountRequest.getAccount(), paramInt, false);
    zzb.zzc(paramParcel, 3, paramResolveAccountRequest.getSessionId());
    zzb.zzI(paramParcel, i);
  }
  
  public ResolveAccountRequest zzal(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzap(paramParcel);
    Account localAccount = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = zza.zzg(paramParcel, m);
        continue;
        localAccount = (Account)zza.zza(paramParcel, m, Account.CREATOR);
        continue;
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ResolveAccountRequest(j, localAccount, i);
  }
  
  public ResolveAccountRequest[] zzbJ(int paramInt)
  {
    return new ResolveAccountRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */