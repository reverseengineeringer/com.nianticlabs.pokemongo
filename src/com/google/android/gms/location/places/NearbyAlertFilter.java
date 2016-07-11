package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter
  extends zza
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersionCode;
  final List<Integer> zzaFX;
  private final Set<Integer> zzaFY;
  final List<String> zzaFZ;
  final List<UserDataType> zzaGa;
  private final Set<String> zzaGb;
  private final Set<UserDataType> zzaGc;
  
  NearbyAlertFilter(int paramInt, List<String> paramList, List<Integer> paramList1, List<UserDataType> paramList2)
  {
    mVersionCode = paramInt;
    if (paramList1 == null)
    {
      paramList1 = Collections.emptyList();
      zzaFX = paramList1;
      if (paramList2 != null) {
        break label91;
      }
      paramList1 = Collections.emptyList();
      label31:
      zzaGa = paramList1;
      if (paramList != null) {
        break label100;
      }
    }
    label91:
    label100:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      zzaFZ = paramList;
      zzaFY = zzs(zzaFX);
      zzaGc = zzs(zzaGa);
      zzaGb = zzs(zzaFZ);
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
      paramList1 = Collections.unmodifiableList(paramList2);
      break label31;
    }
  }
  
  @Deprecated
  public static NearbyAlertFilter zza(Collection<String> paramCollection, Collection<Integer> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    if (((paramCollection == null) || (paramCollection.isEmpty())) && ((paramCollection1 == null) || (paramCollection1.isEmpty())) && ((paramCollection2 == null) || (paramCollection2.isEmpty()))) {
      throw new IllegalArgumentException("NearbyAlertFilters must contain at least onePlaceId, PlaceType, or UserDataType to match results with.");
    }
    return new NearbyAlertFilter(0, zzf(paramCollection), zzf(paramCollection1), zzf(paramCollection2));
  }
  
  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertFilter)) {
        return false;
      }
      paramObject = (NearbyAlertFilter)paramObject;
    } while ((zzaFY.equals(zzaFY)) && (zzaGc.equals(zzaGc)) && (zzaGb.equals(zzaGb)));
    return false;
  }
  
  public Set<String> getPlaceIds()
  {
    return zzaGb;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaFY, zzaGc, zzaGb });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this);
    if (!zzaFY.isEmpty()) {
      localzza.zzg("types", zzaFY);
    }
    if (!zzaGb.isEmpty()) {
      localzza.zzg("placeIds", zzaGb);
    }
    if (!zzaGc.isEmpty()) {
      localzza.zzg("requestedUserDataTypes", zzaGc);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.NearbyAlertFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */