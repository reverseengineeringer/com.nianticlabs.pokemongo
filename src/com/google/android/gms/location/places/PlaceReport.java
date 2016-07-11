package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class PlaceReport
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
  private final String mTag;
  final int mVersionCode;
  private final String zzaGt;
  private final String zzaGu;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    zzaGt = paramString1;
    mTag = paramString2;
    zzaGu = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzi(paramString1, paramString2, "unknown");
  }
  
  private static boolean zzdy(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static PlaceReport zzi(String paramString1, String paramString2, String paramString3)
  {
    zzx.zzw(paramString1);
    zzx.zzcr(paramString2);
    zzx.zzcr(paramString3);
    zzx.zzb(zzdy(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!zzw.equal(zzaGt, zzaGt)) || (!zzw.equal(mTag, mTag)) || (!zzw.equal(zzaGu, zzaGu)));
    return true;
  }
  
  public String getPlaceId()
  {
    return zzaGt;
  }
  
  public String getSource()
  {
    return zzaGu;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaGt, mTag, zzaGu });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this);
    localzza.zzg("placeId", zzaGt);
    localzza.zzg("tag", mTag);
    if (!"unknown".equals(zzaGu)) {
      localzza.zzg("source", zzaGu);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */