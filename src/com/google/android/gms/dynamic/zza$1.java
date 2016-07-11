package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

class zza$1
  implements zzf<T>
{
  zza$1(zza paramzza) {}
  
  public void zza(T paramT)
  {
    zza.zza(zzapr, paramT);
    paramT = zza.zza(zzapr).iterator();
    while (paramT.hasNext()) {
      ((zza.zza)paramT.next()).zzb(zza.zzb(zzapr));
    }
    zza.zza(zzapr).clear();
    zza.zza(zzapr, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */