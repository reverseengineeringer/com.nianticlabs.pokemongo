package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<PlacePhotoResult>
{
  static void zza(PlacePhotoResult paramPlacePhotoResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlacePhotoResult.getStatus(), paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaGs, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlacePhotoResult zzeQ(Parcel paramParcel)
  {
    BitmapTeleporter localBitmapTeleporter = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localBitmapTeleporter = (BitmapTeleporter)zza.zza(paramParcel, k, BitmapTeleporter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlacePhotoResult(i, localStatus, localBitmapTeleporter);
  }
  
  public PlacePhotoResult[] zzhm(int paramInt)
  {
    return new PlacePhotoResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */