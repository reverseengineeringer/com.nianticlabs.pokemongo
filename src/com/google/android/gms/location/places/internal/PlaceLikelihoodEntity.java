package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity
  implements SafeParcelable, PlaceLikelihood
{
  public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
  final int mVersionCode;
  final PlaceImpl zzaHA;
  final float zzaHB;
  
  PlaceLikelihoodEntity(int paramInt, PlaceImpl paramPlaceImpl, float paramFloat)
  {
    mVersionCode = paramInt;
    zzaHA = paramPlaceImpl;
    zzaHB = paramFloat;
  }
  
  public static PlaceLikelihoodEntity zza(PlaceImpl paramPlaceImpl, float paramFloat)
  {
    return new PlaceLikelihoodEntity(0, (PlaceImpl)zzx.zzw(paramPlaceImpl), paramFloat);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLikelihoodEntity)) {
        return false;
      }
      paramObject = (PlaceLikelihoodEntity)paramObject;
    } while ((zzaHA.equals(zzaHA)) && (zzaHB == zzaHB));
    return false;
  }
  
  public float getLikelihood()
  {
    return zzaHB;
  }
  
  public Place getPlace()
  {
    return zzaHA;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaHA, Float.valueOf(zzaHB) });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("place", zzaHA).zzg("likelihood", Float.valueOf(zzaHB)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public PlaceLikelihood zzxo()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceLikelihoodEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */