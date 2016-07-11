package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzme<K, V>
  extends zzmi<K, V>
  implements Map<K, V>
{
  zzmh<K, V> zzagz;
  
  private zzmh<K, V> zzpx()
  {
    if (zzagz == null) {
      zzagz = new zzmh()
      {
        protected void colClear()
        {
          clear();
        }
        
        protected Object colGetEntry(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return mArray[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected Map<K, V> colGetMap()
        {
          return zzme.this;
        }
        
        protected int colGetSize()
        {
          return mSize;
        }
        
        protected int colIndexOfKey(Object paramAnonymousObject)
        {
          if (paramAnonymousObject == null) {
            return indexOfNull();
          }
          return indexOf(paramAnonymousObject, paramAnonymousObject.hashCode());
        }
        
        protected int colIndexOfValue(Object paramAnonymousObject)
        {
          return indexOfValue(paramAnonymousObject);
        }
        
        protected void colPut(K paramAnonymousK, V paramAnonymousV)
        {
          put(paramAnonymousK, paramAnonymousV);
        }
        
        protected void colRemoveAt(int paramAnonymousInt)
        {
          removeAt(paramAnonymousInt);
        }
        
        protected V colSetValue(int paramAnonymousInt, V paramAnonymousV)
        {
          return (V)setValueAt(paramAnonymousInt, paramAnonymousV);
        }
      };
    }
    return zzagz;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return zzpx().getEntrySet();
  }
  
  public Set<K> keySet()
  {
    return zzpx().getKeySet();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(mSize + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection<V> values()
  {
    return zzpx().getValues();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */