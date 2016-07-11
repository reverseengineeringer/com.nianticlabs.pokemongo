package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final boolean zzaFW;
  final List<Integer> zzaFX;
  private final Set<Integer> zzaFY;
  
  AutocompleteFilter(int paramInt, boolean paramBoolean, Collection<Integer> paramCollection)
  {
    mVersionCode = paramInt;
    zzaFW = paramBoolean;
    if (paramCollection == null) {}
    for (paramCollection = Collections.emptyList();; paramCollection = new ArrayList(paramCollection))
    {
      zzaFX = paramCollection;
      if (!zzaFX.isEmpty()) {
        break;
      }
      zzaFY = Collections.emptySet();
      return;
    }
    zzaFY = Collections.unmodifiableSet(new HashSet(zzaFX));
  }
  
  public static AutocompleteFilter create(Collection<Integer> paramCollection)
  {
    return zza(true, paramCollection);
  }
  
  public static AutocompleteFilter zza(boolean paramBoolean, Collection<Integer> paramCollection)
  {
    return new AutocompleteFilter(0, paramBoolean, paramCollection);
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompleteFilter)) {
        return false;
      }
      paramObject = (AutocompleteFilter)paramObject;
    } while ((zzaFY.equals(zzaFY)) && (zzaFW == zzaFW));
    return false;
  }
  
  public Set<Integer> getPlaceTypes()
  {
    return zzaFY;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(zzaFW), zzaFY });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this);
    if (!zzaFW) {
      localzza.zzg("restrictedToPlaces", Boolean.valueOf(zzaFW));
    }
    localzza.zzg("placeTypes", zzaFY);
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzwM()
  {
    return zzaFW;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AutocompleteFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */