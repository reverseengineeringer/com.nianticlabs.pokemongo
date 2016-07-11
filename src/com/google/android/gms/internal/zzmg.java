package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class zzmg<K, V>
{
  private int size;
  private final LinkedHashMap<K, V> zzagB;
  private int zzagC;
  private int zzagD;
  private int zzagE;
  private int zzagF;
  private int zzagG;
  private int zzagH;
  
  public zzmg(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    zzagC = paramInt;
    zzagB = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int zzc(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = zzagB.get(paramK);
      if (localObject1 != null)
      {
        zzagG += 1;
        return (V)localObject1;
      }
      zzagH += 1;
      localObject1 = create(paramK);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      zzagE += 1;
      Object localObject2 = zzagB.put(paramK, localObject1);
      if (localObject2 != null) {
        zzagB.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        return (V)localObject2;
        size += zzc(paramK, localObject1);
      }
      trimToSize(zzagC);
    }
    finally {}
    return (V)localObject1;
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      zzagD += 1;
      size += zzc(paramK, paramV);
      Object localObject = zzagB.put(paramK, paramV);
      if (localObject != null) {
        size -= zzc(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(zzagC);
      return (V)localObject;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = zzagG + zzagH;
      if (j != 0) {
        i = zzagG * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(zzagC), Integer.valueOf(zzagG), Integer.valueOf(zzagH), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  public void trimToSize(int paramInt)
  {
    Object localObject3;
    Object localObject2;
    try
    {
      if ((size < 0) || ((zzagB.isEmpty()) && (size != 0))) {
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      if ((size <= paramInt) || (zzagB.isEmpty())) {
        return;
      }
      localObject3 = (Map.Entry)zzagB.entrySet().iterator().next();
      localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      zzagB.remove(localObject2);
      size -= zzc(localObject2, localObject3);
      zzagF += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */