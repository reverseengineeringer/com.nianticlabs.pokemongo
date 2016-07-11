package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import java.util.ArrayList;
import java.util.Iterator;

class zzlg$zzh
  extends zzlg.zzi
{
  private final ArrayList<Api.zzb> zzabX;
  
  public zzlg$zzh(ArrayList<Api.zzb> paramArrayList)
  {
    super(paramArrayList, null);
    ArrayList localArrayList;
    zzabX = localArrayList;
  }
  
  public void zznO()
  {
    Iterator localIterator = zzabX.iterator();
    while (localIterator.hasNext()) {
      ((Api.zzb)localIterator.next()).zza(zzlg.zzg(zzabL));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */