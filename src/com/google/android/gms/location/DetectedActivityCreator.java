package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class DetectedActivityCreator
  implements Parcelable.Creator<DetectedActivity>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void zza(DetectedActivity paramDetectedActivity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, zzaEg);
    zzb.zzc(paramParcel, 1000, paramDetectedActivity.getVersionCode());
    zzb.zzc(paramParcel, 2, zzaEh);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DetectedActivity createFromParcel(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzap(paramParcel);
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        j = zza.zzg(paramParcel, n);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new DetectedActivity(i, j, k);
  }
  
  public DetectedActivity[] newArray(int paramInt)
  {
    return new DetectedActivity[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.DetectedActivityCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */