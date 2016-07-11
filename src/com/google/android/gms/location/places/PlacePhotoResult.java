package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlacePhotoResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzi();
  private final Bitmap mBitmap;
  final int mVersionCode;
  private final Status zzSC;
  final BitmapTeleporter zzaGs;
  
  PlacePhotoResult(int paramInt, Status paramStatus, BitmapTeleporter paramBitmapTeleporter)
  {
    mVersionCode = paramInt;
    zzSC = paramStatus;
    zzaGs = paramBitmapTeleporter;
    if (zzaGs != null)
    {
      mBitmap = paramBitmapTeleporter.zzos();
      return;
    }
    mBitmap = null;
  }
  
  public PlacePhotoResult(Status paramStatus, BitmapTeleporter paramBitmapTeleporter)
  {
    mVersionCode = 0;
    zzSC = paramStatus;
    zzaGs = paramBitmapTeleporter;
    if (zzaGs != null)
    {
      mBitmap = paramBitmapTeleporter.zzos();
      return;
    }
    mBitmap = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap()
  {
    return mBitmap;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", zzSC).zzg("bitmap", mBitmap).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacePhotoResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */