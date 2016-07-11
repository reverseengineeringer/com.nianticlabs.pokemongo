package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter
  extends zza
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int mVersionCode;
  final List<Integer> zzaFX;
  private final Set<Integer> zzaFY;
  final List<String> zzaFZ;
  final List<UserDataType> zzaGa;
  private final Set<String> zzaGb;
  private final Set<UserDataType> zzaGc;
  final boolean zzaGl;
  
  public PlaceFilter()
  {
    this(false, null);
  }
  
  PlaceFilter(int paramInt, List<Integer> paramList, boolean paramBoolean, List<String> paramList1, List<UserDataType> paramList2)
  {
    mVersionCode = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      zzaFX = paramList;
      zzaGl = paramBoolean;
      if (paramList2 != null) {
        break label97;
      }
      paramList = Collections.emptyList();
      label36:
      zzaGa = paramList;
      if (paramList1 != null) {
        break label106;
      }
    }
    label97:
    label106:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList1))
    {
      zzaFZ = paramList;
      zzaFY = zzs(zzaFX);
      zzaGc = zzs(zzaGa);
      zzaGb = zzs(zzaFZ);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList2);
      break label36;
    }
  }
  
  public PlaceFilter(Collection<Integer> paramCollection, boolean paramBoolean, Collection<String> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    this(0, zzf(paramCollection), paramBoolean, zzf(paramCollection1), zzf(paramCollection2));
  }
  
  public PlaceFilter(boolean paramBoolean, Collection<String> paramCollection)
  {
    this(null, paramBoolean, paramCollection, null);
  }
  
  @Deprecated
  public static PlaceFilter zzwT()
  {
    return new zza(null).zzwU();
  }
  
  public int describeContents()
  {
    zzg localzzg = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceFilter)) {
        return false;
      }
      paramObject = (PlaceFilter)paramObject;
    } while ((zzaFY.equals(zzaFY)) && (zzaGl == zzaGl) && (zzaGc.equals(zzaGc)) && (zzaGb.equals(zzaGb)));
    return false;
  }
  
  public Set<String> getPlaceIds()
  {
    return zzaGb;
  }
  
  public Set<Integer> getPlaceTypes()
  {
    return zzaFY;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaFY, Boolean.valueOf(zzaGl), zzaGc, zzaGb });
  }
  
  public boolean isRestrictedToPlacesOpenNow()
  {
    return zzaGl;
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this);
    if (!zzaFY.isEmpty()) {
      localzza.zzg("types", zzaFY);
    }
    localzza.zzg("requireOpenNow", Boolean.valueOf(zzaGl));
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
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public Set<UserDataType> zzwS()
  {
    return zzaGc;
  }
  
  @Deprecated
  public static final class zza
  {
    private boolean zzaGl = false;
    private Collection<Integer> zzaGm = null;
    private Collection<UserDataType> zzaGn = null;
    private String[] zzaGo = null;
    
    public PlaceFilter zzwU()
    {
      List localList = null;
      ArrayList localArrayList1;
      if (zzaGm != null)
      {
        localArrayList1 = new ArrayList(zzaGm);
        if (zzaGn == null) {
          break label75;
        }
      }
      label75:
      for (ArrayList localArrayList2 = new ArrayList(zzaGn);; localArrayList2 = null)
      {
        if (zzaGo != null) {
          localList = Arrays.asList(zzaGo);
        }
        return new PlaceFilter(localArrayList1, zzaGl, localList, localArrayList2);
        localArrayList1 = null;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */