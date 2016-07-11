package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzgr
public class zzio<T>
  implements zziq<T>
{
  private final zzir zzJA;
  private final T zzJy;
  
  public zzio(T paramT)
  {
    zzJy = paramT;
    zzJA = new zzir();
    zzJA.zzgV();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public T get()
  {
    return (T)zzJy;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return (T)zzJy;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public void zzc(Runnable paramRunnable)
  {
    zzJA.zzc(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */