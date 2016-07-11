package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class zzlg$zzf
  extends zzlg.zzi
{
  private final ArrayList<Api.zzb> zzabX;
  
  public zzlg$zzf(ArrayList<Api.zzb> paramArrayList)
  {
    super(paramArrayList, null);
    ArrayList localArrayList;
    zzabX = localArrayList;
  }
  
  public void zznO()
  {
    Set localSet = zzdzzabL).zzaci;
    if (localSet.isEmpty()) {
      localSet = zzlg.zzh(zzabL);
    }
    for (;;)
    {
      Iterator localIterator = zzabX.iterator();
      while (localIterator.hasNext()) {
        ((Api.zzb)localIterator.next()).zza(zzlg.zzg(zzabL), localSet);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */