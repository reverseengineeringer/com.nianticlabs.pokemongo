package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class zzir
{
  private final Object zzJI = new Object();
  private final List<Runnable> zzJJ = new ArrayList();
  private final List<Runnable> zzJK = new ArrayList();
  private boolean zzJL = false;
  
  private void zze(Runnable paramRunnable)
  {
    zzic.zza(paramRunnable);
  }
  
  private void zzf(Runnable paramRunnable)
  {
    zza.zzJt.post(paramRunnable);
  }
  
  public void zzc(Runnable paramRunnable)
  {
    synchronized (zzJI)
    {
      if (zzJL)
      {
        zze(paramRunnable);
        return;
      }
      zzJJ.add(paramRunnable);
    }
  }
  
  public void zzd(Runnable paramRunnable)
  {
    synchronized (zzJI)
    {
      if (zzJL)
      {
        zzf(paramRunnable);
        return;
      }
      zzJK.add(paramRunnable);
    }
  }
  
  public void zzgV()
  {
    synchronized (zzJI)
    {
      if (zzJL) {
        return;
      }
      Iterator localIterator1 = zzJJ.iterator();
      if (localIterator1.hasNext()) {
        zze((Runnable)localIterator1.next());
      }
    }
    Iterator localIterator2 = zzJK.iterator();
    while (localIterator2.hasNext()) {
      zzf((Runnable)localIterator2.next());
    }
    zzJJ.clear();
    zzJK.clear();
    zzJL = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzir
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */