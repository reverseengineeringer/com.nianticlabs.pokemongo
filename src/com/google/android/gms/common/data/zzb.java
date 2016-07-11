package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zzadi;
  protected int zzadj;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    zzadi = ((DataBuffer)zzx.zzw(paramDataBuffer));
    zzadj = -1;
  }
  
  public boolean hasNext()
  {
    return zzadj < zzadi.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + zzadj);
    }
    DataBuffer localDataBuffer = zzadi;
    int i = zzadj + 1;
    zzadj = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */