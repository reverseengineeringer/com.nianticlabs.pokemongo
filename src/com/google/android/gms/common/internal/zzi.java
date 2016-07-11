package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<GetServiceRequest>
{
  static void zza(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, version);
    zzb.zzc(paramParcel, 2, zzafq);
    zzb.zzc(paramParcel, 3, zzafr);
    zzb.zza(paramParcel, 4, zzafs, false);
    zzb.zza(paramParcel, 5, zzaft, false);
    zzb.zza(paramParcel, 6, zzafu, paramInt, false);
    zzb.zza(paramParcel, 7, zzafv, false);
    zzb.zza(paramParcel, 8, zzafw, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetServiceRequest zzak(Parcel paramParcel)
  {
    int i = 0;
    Account localAccount = null;
    int m = zza.zzap(paramParcel);
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        i = zza.zzg(paramParcel, n);
        break;
      case 4: 
        str = zza.zzp(paramParcel, n);
        break;
      case 5: 
        localIBinder = zza.zzq(paramParcel, n);
        break;
      case 6: 
        arrayOfScope = (Scope[])zza.zzb(paramParcel, n, Scope.CREATOR);
        break;
      case 7: 
        localBundle = zza.zzr(paramParcel, n);
        break;
      case 8: 
        localAccount = (Account)zza.zza(paramParcel, n, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new GetServiceRequest(k, j, i, str, localIBinder, arrayOfScope, localBundle, localAccount);
  }
  
  public GetServiceRequest[] zzbD(int paramInt)
  {
    return new GetServiceRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */