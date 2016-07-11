package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgr
public class zzdu
  implements Iterable<zzdt>
{
  private final List<zzdt> zzyb = new LinkedList();
  
  private zzdt zzc(zziz paramzziz)
  {
    Iterator localIterator = zzp.zzbI().iterator();
    while (localIterator.hasNext())
    {
      zzdt localzzdt = (zzdt)localIterator.next();
      if (zzoM == paramzziz) {
        return localzzdt;
      }
    }
    return null;
  }
  
  public Iterator<zzdt> iterator()
  {
    return zzyb.iterator();
  }
  
  public void zza(zzdt paramzzdt)
  {
    zzyb.add(paramzzdt);
  }
  
  public boolean zza(zziz paramzziz)
  {
    paramzziz = zzc(paramzziz);
    if (paramzziz != null)
    {
      zzxY.abort();
      return true;
    }
    return false;
  }
  
  public void zzb(zzdt paramzzdt)
  {
    zzyb.remove(paramzzdt);
  }
  
  public boolean zzb(zziz paramzziz)
  {
    return zzc(paramzziz) != null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */