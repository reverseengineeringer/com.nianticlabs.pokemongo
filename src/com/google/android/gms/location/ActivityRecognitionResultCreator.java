package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator
  implements Parcelable.Creator<ActivityRecognitionResult>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void zza(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, zzaEb, false);
    zzb.zzc(paramParcel, 1000, paramActivityRecognitionResult.getVersionCode());
    zzb.zza(paramParcel, 2, zzaEc);
    zzb.zza(paramParcel, 3, zzaEd);
    zzb.zzc(paramParcel, 4, zzaEe);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ActivityRecognitionResult createFromParcel(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int k = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    long l2 = 0L;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, m, DetectedActivity.CREATOR);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ActivityRecognitionResult(j, localArrayList, l2, l1, i);
  }
  
  public ActivityRecognitionResult[] newArray(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResultCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */