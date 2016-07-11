package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Deprecated
public final class PlaceFilter$zza
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceFilter.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */