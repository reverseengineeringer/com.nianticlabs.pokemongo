package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();
  static final long zzaGv = TimeUnit.HOURS.toMillis(1L);
  private final int mPriority;
  final int mVersionCode;
  private final long zzaEE;
  private final long zzaEj;
  private final PlaceFilter zzaGw;
  
  public PlaceRequest(int paramInt1, PlaceFilter paramPlaceFilter, long paramLong1, int paramInt2, long paramLong2)
  {
    mVersionCode = paramInt1;
    zzaGw = paramPlaceFilter;
    zzaEE = paramLong1;
    mPriority = paramInt2;
    zzaEj = paramLong2;
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
      if (!(paramObject instanceof PlaceRequest)) {
        return false;
      }
      paramObject = (PlaceRequest)paramObject;
    } while ((zzw.equal(zzaGw, zzaGw)) && (zzaEE == zzaEE) && (mPriority == mPriority) && (zzaEj == zzaEj));
    return false;
  }
  
  public long getExpirationTime()
  {
    return zzaEj;
  }
  
  public long getInterval()
  {
    return zzaEE;
  }
  
  public int getPriority()
  {
    return mPriority;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaGw, Long.valueOf(zzaEE), Integer.valueOf(mPriority), Long.valueOf(zzaEj) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("filter", zzaGw).zzg("interval", Long.valueOf(zzaEE)).zzg("priority", Integer.valueOf(mPriority)).zzg("expireAt", Long.valueOf(zzaEj)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public PlaceFilter zzwO()
  {
    return zzaGw;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */