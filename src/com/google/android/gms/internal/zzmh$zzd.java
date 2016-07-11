package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzmh$zzd
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int mEnd;
  boolean mEntryValid = false;
  int mIndex;
  
  zzmh$zzd(zzmh paramzzmh)
  {
    mEnd = (paramzzmh.colGetSize() - 1);
    mIndex = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    if ((zzmf.equal(((Map.Entry)paramObject).getKey(), zzagL.colGetEntry(mIndex, 0))) && (zzmf.equal(((Map.Entry)paramObject).getValue(), zzagL.colGetEntry(mIndex, 1)))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public K getKey()
  {
    if (!mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return (K)zzagL.colGetEntry(mIndex, 0);
  }
  
  public V getValue()
  {
    if (!mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return (V)zzagL.colGetEntry(mIndex, 1);
  }
  
  public boolean hasNext()
  {
    return mIndex < mEnd;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = zzagL.colGetEntry(mIndex, 0);
    Object localObject2 = zzagL.colGetEntry(mIndex, 1);
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label69;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label69:
      j = localObject2.hashCode();
    }
  }
  
  public Map.Entry<K, V> next()
  {
    mIndex += 1;
    mEntryValid = true;
    return this;
  }
  
  public void remove()
  {
    if (!mEntryValid) {
      throw new IllegalStateException();
    }
    zzagL.colRemoveAt(mIndex);
    mIndex -= 1;
    mEnd -= 1;
    mEntryValid = false;
  }
  
  public V setValue(V paramV)
  {
    if (!mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return (V)zzagL.colSetValue(mIndex, paramV);
  }
  
  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */