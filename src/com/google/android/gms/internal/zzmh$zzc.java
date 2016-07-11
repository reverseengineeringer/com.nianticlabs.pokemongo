package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class zzmh$zzc
  implements Set<K>
{
  zzmh$zzc(zzmh paramzzmh) {}
  
  public boolean add(K paramK)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends K> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    zzagL.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    return zzagL.colIndexOfKey(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return zzmh.containsAllHelper(zzagL.colGetMap(), paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return zzmh.equalsSetHelper(this, paramObject);
  }
  
  public int hashCode()
  {
    int i = zzagL.colGetSize() - 1;
    int j = 0;
    if (i >= 0)
    {
      Object localObject = zzagL.colGetEntry(i, 0);
      if (localObject == null) {}
      for (int k = 0;; k = localObject.hashCode())
      {
        j += k;
        i -= 1;
        break;
      }
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return zzagL.colGetSize() == 0;
  }
  
  public Iterator<K> iterator()
  {
    return new zzmh.zza(zzagL, 0);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = zzagL.colIndexOfKey(paramObject);
    if (i >= 0)
    {
      zzagL.colRemoveAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return zzmh.removeAllHelper(zzagL.colGetMap(), paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return zzmh.retainAllHelper(zzagL.colGetMap(), paramCollection);
  }
  
  public int size()
  {
    return zzagL.colGetSize();
  }
  
  public Object[] toArray()
  {
    return zzagL.toArrayHelper(0);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return zzagL.toArrayHelper(paramArrayOfT, 0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */