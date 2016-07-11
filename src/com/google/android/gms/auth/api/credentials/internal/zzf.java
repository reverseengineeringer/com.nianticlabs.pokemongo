package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<DeleteRequest>
{
  static void zza(DeleteRequest paramDeleteRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDeleteRequest.getCredential(), paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzI(paramParcel, i);
  }
  
  public DeleteRequest zzJ(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    Credential localCredential = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localCredential = (Credential)zza.zza(paramParcel, k, Credential.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DeleteRequest(i, localCredential);
  }
  
  public DeleteRequest[] zzaA(int paramInt)
  {
    return new DeleteRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */