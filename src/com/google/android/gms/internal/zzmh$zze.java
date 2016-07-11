package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;

final class zzmh$zze
  implements Collection<V>
{
  zzmh$zze(zzmh paramzzmh) {}
  
  public boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    zzagL.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    return zzagL.colIndexOfValue(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return zzagL.colGetSize() == 0;
  }
  
  public Iterator<V> iterator()
  {
    return new zzmh.zza(zzagL, 1);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = zzagL.colIndexOfValue(paramObject);
    if (i >= 0)
    {
      zzagL.colRemoveAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    int i = 0;
    int j = zzagL.colGetSize();
    boolean bool = false;
    while (i < j)
    {
      int m = i;
      int k = j;
      if (paramCollection.contains(zzagL.colGetEntry(i, 1)))
      {
        zzagL.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int i = 0;
    int j = zzagL.colGetSize();
    boolean bool = false;
    while (i < j)
    {
      int m = i;
      int k = j;
      if (!paramCollection.contains(zzagL.colGetEntry(i, 1)))
      {
        zzagL.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public int size()
  {
    return zzagL.colGetSize();
  }
  
  public Object[] toArray()
  {
    return zzagL.toArrayHelper(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return zzagL.toArrayHelper(paramArrayOfT, 1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */