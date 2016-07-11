package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgr
public class zzit<T>
  implements zzis<T>
{
  protected final BlockingQueue<zzit<T>.zza> zzJM = new LinkedBlockingQueue();
  protected T zzJN;
  private final Object zzpd = new Object();
  protected int zzys = 0;
  
  public int getStatus()
  {
    return zzys;
  }
  
  public void reject()
  {
    synchronized (zzpd)
    {
      if (zzys != 0) {
        throw new UnsupportedOperationException();
      }
    }
    zzys = -1;
    Iterator localIterator = zzJM.iterator();
    while (localIterator.hasNext()) {
      nextzzJP.run();
    }
    zzJM.clear();
  }
  
  public void zza(zzis.zzc<T> paramzzc, zzis.zza paramzza)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzys == 1)
        {
          paramzzc.zzc(zzJN);
          return;
        }
        if (zzys == -1) {
          paramzza.run();
        }
      }
      if (zzys == 0) {
        zzJM.add(new zza(paramzzc, paramzza));
      }
    }
  }
  
  public void zzg(T paramT)
  {
    synchronized (zzpd)
    {
      if (zzys != 0) {
        throw new UnsupportedOperationException();
      }
    }
    zzJN = paramT;
    zzys = 1;
    Iterator localIterator = zzJM.iterator();
    while (localIterator.hasNext()) {
      nextzzJO.zzc(paramT);
    }
    zzJM.clear();
  }
  
  class zza
  {
    public final zzis.zzc<T> zzJO;
    public final zzis.zza zzJP;
    
    public zza(zzis.zza paramzza)
    {
      zzJO = paramzza;
      zzis.zza localzza;
      zzJP = localzza;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */