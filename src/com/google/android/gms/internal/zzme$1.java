package com.google.android.gms.internal;

import java.util.Map;

class zzme$1
  extends zzmh<K, V>
{
  zzme$1(zzme paramzzme) {}
  
  protected void colClear()
  {
    zzagA.clear();
  }
  
  protected Object colGetEntry(int paramInt1, int paramInt2)
  {
    return zzagA.mArray[((paramInt1 << 1) + paramInt2)];
  }
  
  protected Map<K, V> colGetMap()
  {
    return zzagA;
  }
  
  protected int colGetSize()
  {
    return zzagA.mSize;
  }
  
  protected int colIndexOfKey(Object paramObject)
  {
    if (paramObject == null) {
      return zzagA.indexOfNull();
    }
    return zzagA.indexOf(paramObject, paramObject.hashCode());
  }
  
  protected int colIndexOfValue(Object paramObject)
  {
    return zzagA.indexOfValue(paramObject);
  }
  
  protected void colPut(K paramK, V paramV)
  {
    zzagA.put(paramK, paramV);
  }
  
  protected void colRemoveAt(int paramInt)
  {
    zzagA.removeAt(paramInt);
  }
  
  protected V colSetValue(int paramInt, V paramV)
  {
    return (V)zzagA.setValueAt(paramInt, paramV);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzme.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */