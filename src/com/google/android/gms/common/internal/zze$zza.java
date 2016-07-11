package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class zze$zza
  extends zze
{
  List<zze> zzafg;
  
  zze$zza(List<zze> paramList)
  {
    zzafg = paramList;
  }
  
  public zze zza(zze paramzze)
  {
    ArrayList localArrayList = new ArrayList(zzafg);
    localArrayList.add(zzx.zzw(paramzze));
    return new zza(localArrayList);
  }
  
  public boolean zzd(char paramChar)
  {
    Iterator localIterator = zzafg.iterator();
    while (localIterator.hasNext()) {
      if (((zze)localIterator.next()).zzd(paramChar)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zze.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */