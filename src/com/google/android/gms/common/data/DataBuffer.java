package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract interface DataBuffer<T>
  extends Releasable, Iterable<T>
{
  @Deprecated
  public abstract void close();
  
  public abstract T get(int paramInt);
  
  public abstract int getCount();
  
  @Deprecated
  public abstract boolean isClosed();
  
  public abstract Iterator<T> iterator();
  
  public abstract void release();
  
  public abstract Iterator<T> singleRefIterator();
  
  public abstract Bundle zzor();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.DataBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */