package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T>
  extends zzb<T>
{
  private T zzadF;
  
  public zzg(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + zzadj);
    }
    zzadj += 1;
    if (zzadj == 0)
    {
      zzadF = zzadi.get(0);
      if (!(zzadF instanceof zzc)) {
        throw new IllegalStateException("DataBuffer reference of type " + zzadF.getClass() + " is not movable");
      }
    }
    else
    {
      ((zzc)zzadF).zzbr(zzadj);
    }
    return (T)zzadF;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */