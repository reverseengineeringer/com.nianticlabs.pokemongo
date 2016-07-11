package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlacePhotoMetadataResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
  final int mVersionCode;
  private final Status zzSC;
  final DataHolder zzaGq;
  private final PlacePhotoMetadataBuffer zzaGr;
  
  PlacePhotoMetadataResult(int paramInt, Status paramStatus, DataHolder paramDataHolder)
  {
    mVersionCode = paramInt;
    zzSC = paramStatus;
    zzaGq = paramDataHolder;
    if (paramDataHolder == null)
    {
      zzaGr = null;
      return;
    }
    zzaGr = new PlacePhotoMetadataBuffer(zzaGq);
  }
  
  public PlacePhotoMetadataResult(Status paramStatus, DataHolder paramDataHolder)
  {
    this(0, paramStatus, paramDataHolder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PlacePhotoMetadataBuffer getPhotoMetadata()
  {
    return zzaGr;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacePhotoMetadataResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */