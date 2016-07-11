package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder zzabq;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    zzabq = paramDataHolder;
    if (zzabq != null) {
      zzabq.zzr(this);
    }
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (zzabq == null) {
      return 0;
    }
    return zzabq.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return (zzabq == null) || (zzabq.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new zzb(this);
  }
  
  public void release()
  {
    if (zzabq != null) {
      zzabq.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }
  
  public Bundle zzor()
  {
    return zzabq.zzor();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.AbstractDataBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */