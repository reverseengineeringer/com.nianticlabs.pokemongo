package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class zzmh$zzb
  implements Set<Map.Entry<K, V>>
{
  zzmh$zzb(zzmh paramzzmh) {}
  
  public boolean add(Map.Entry<K, V> paramEntry)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = zzagL.colGetSize();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      zzagL.colPut(localEntry.getKey(), localEntry.getValue());
    }
    return i != zzagL.colGetSize();
  }
  
  public void clear()
  {
    zzagL.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    int i;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      i = zzagL.colIndexOfKey(((Map.Entry)paramObject).getKey());
    } while (i < 0);
    return zzmf.equal(zzagL.colGetEntry(i, 1), ((Map.Entry)paramObject).getValue());
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
  
  public boolean equals(Object paramObject)
  {
    return zzmh.equalsSetHelper(this, paramObject);
  }
  
  public int hashCode()
  {
    int j = zzagL.colGetSize() - 1;
    int i = 0;
    if (j >= 0)
    {
      Object localObject1 = zzagL.colGetEntry(j, 0);
      Object localObject2 = zzagL.colGetEntry(j, 1);
      int k;
      if (localObject1 == null)
      {
        k = 0;
        label45:
        if (localObject2 != null) {
          break label76;
        }
      }
      label76:
      for (int m = 0;; m = localObject2.hashCode())
      {
        j -= 1;
        i += (m ^ k);
        break;
        k = localObject1.hashCode();
        break label45;
      }
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return zzagL.colGetSize() == 0;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new zzmh.zzd(zzagL);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return zzagL.colGetSize();
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */