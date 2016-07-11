package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<ConnectionResult>
{
  static void zza(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramConnectionResult.getErrorCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramConnectionResult.getResolution(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramConnectionResult.getErrorMessage(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public ConnectionResult zzac(Parcel paramParcel)
  {
    String str = null;
    int j = 0;
    int m = zza.zzap(paramParcel);
    PendingIntent localPendingIntent = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        k = zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        str = zza.zzp(paramParcel, k);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ConnectionResult(i, j, localPendingIntent, str);
  }
  
  public ConnectionResult[] zzbh(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */