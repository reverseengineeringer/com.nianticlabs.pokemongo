package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Set;

public final class NearbyAlertRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final int mVersionCode;
  private final int zzaEi;
  private final int zzaGd;
  @Deprecated
  private final PlaceFilter zzaGe;
  private final NearbyAlertFilter zzaGf;
  private final boolean zzaGg;
  private final int zzaGh;
  
  NearbyAlertRequest(int paramInt1, int paramInt2, int paramInt3, PlaceFilter paramPlaceFilter, NearbyAlertFilter paramNearbyAlertFilter, boolean paramBoolean, int paramInt4)
  {
    mVersionCode = paramInt1;
    zzaEi = paramInt2;
    zzaGd = paramInt3;
    zzaGg = paramBoolean;
    if (paramNearbyAlertFilter != null) {
      zzaGf = paramNearbyAlertFilter;
    }
    for (;;)
    {
      zzaGe = null;
      zzaGh = paramInt4;
      return;
      if (paramPlaceFilter != null)
      {
        if (zza(paramPlaceFilter)) {
          zzaGf = NearbyAlertFilter.zza(paramPlaceFilter.getPlaceIds(), paramPlaceFilter.getPlaceTypes(), paramPlaceFilter.zzwS());
        } else {
          zzaGf = null;
        }
      }
      else {
        zzaGf = null;
      }
    }
  }
  
  @Deprecated
  private static boolean zza(PlaceFilter paramPlaceFilter)
  {
    return ((paramPlaceFilter.getPlaceTypes() != null) && (!paramPlaceFilter.getPlaceTypes().isEmpty())) || ((paramPlaceFilter.getPlaceIds() != null) && (!paramPlaceFilter.getPlaceIds().isEmpty())) || ((paramPlaceFilter.zzwS() != null) && (!paramPlaceFilter.zzwS().isEmpty()));
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertRequest)) {
        return false;
      }
      paramObject = (NearbyAlertRequest)paramObject;
    } while ((zzaEi == zzaEi) && (zzaGd == zzaGd) && (zzw.equal(zzaGe, zzaGe)) && (zzw.equal(zzaGf, zzaGf)));
    return false;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(zzaEi), Integer.valueOf(zzaGd) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("transitionTypes", Integer.valueOf(zzaEi)).zzg("loiteringTimeMillis", Integer.valueOf(zzaGd)).zzg("nearbyAlertFilter", zzaGf).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public int zzwK()
  {
    return zzaEi;
  }
  
  public int zzwN()
  {
    return zzaGd;
  }
  
  @Deprecated
  public PlaceFilter zzwO()
  {
    return null;
  }
  
  public NearbyAlertFilter zzwP()
  {
    return zzaGf;
  }
  
  public boolean zzwQ()
  {
    return zzaGg;
  }
  
  public int zzwR()
  {
    return zzaGh;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.NearbyAlertRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */