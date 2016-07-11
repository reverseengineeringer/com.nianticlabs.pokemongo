package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz
  implements Parcelable.Creator<ResolveAccountResponse>
{
  static void zza(ResolveAccountResponse paramResolveAccountResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzaeH, false);
    zzb.zza(paramParcel, 3, paramResolveAccountResponse.zzpr(), paramInt, false);
    zzb.zza(paramParcel, 4, paramResolveAccountResponse.zzps());
    zzb.zza(paramParcel, 5, paramResolveAccountResponse.zzpt());
    zzb.zzI(paramParcel, i);
  }
  
  public ResolveAccountResponse zzam(Parcel paramParcel)
  {
    ConnectionResult localConnectionResult = null;
    boolean bool1 = false;
    int j = zza.zzap(paramParcel);
    boolean bool2 = false;
    IBinder localIBinder = null;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localConnectionResult = (ConnectionResult)zza.zza(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ResolveAccountResponse(i, localIBinder, localConnectionResult, bool2, bool1);
  }
  
  public ResolveAccountResponse[] zzbK(int paramInt)
  {
    return new ResolveAccountResponse[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */