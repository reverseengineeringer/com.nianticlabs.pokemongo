package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class CompactStringObjectMap
  implements Serializable
{
  private static final CompactStringObjectMap EMPTY = new CompactStringObjectMap(1, 0, new Object[4]);
  private static final long serialVersionUID = 1L;
  private final Object[] _hashArea;
  private final int _hashMask;
  private final int _spillCount;
  
  private CompactStringObjectMap(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    _hashMask = paramInt1;
    _spillCount = paramInt2;
    _hashArea = paramArrayOfObject;
  }
  
  private final Object _find2(String paramString, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return null;
      int i = _hashMask + 1;
      paramInt = (paramInt >> 1) + i << 1;
      paramObject = _hashArea[paramInt];
      if (paramString.equals(paramObject)) {
        return _hashArea[(paramInt + 1)];
      }
      if (paramObject != null)
      {
        i = (i >> 1) + i << 1;
        int j = _spillCount;
        paramInt = i;
        while (paramInt < i + j)
        {
          paramObject = _hashArea[paramInt];
          if ((paramObject == paramString) || (paramString.equals(paramObject))) {
            return _hashArea[(paramInt + 1)];
          }
          paramInt += 2;
        }
      }
    }
  }
  
  public static <T> CompactStringObjectMap construct(Map<String, T> paramMap)
  {
    if (paramMap.isEmpty()) {
      return EMPTY;
    }
    int n = findSize(paramMap.size());
    int i1 = n - 1;
    Object localObject = new Object[((n >> 1) + n) * 2];
    int k = 0;
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map<String, T>)localObject;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      int i2 = str.hashCode() & i1;
      int m = i2 + i2;
      localObject = paramMap;
      int i = m;
      int j = k;
      if (paramMap[m] != null)
      {
        m = (i2 >> 1) + n << 1;
        localObject = paramMap;
        i = m;
        j = k;
        if (paramMap[m] != null)
        {
          m = ((n >> 1) + n << 1) + k;
          k += 2;
          localObject = paramMap;
          i = m;
          j = k;
          if (m >= paramMap.length)
          {
            localObject = Arrays.copyOf(paramMap, paramMap.length + 4);
            j = k;
            i = m;
          }
        }
      }
      localObject[i] = str;
      localObject[(i + 1)] = localEntry.getValue();
      paramMap = (Map<String, T>)localObject;
      k = j;
    }
    return new CompactStringObjectMap(i1, k, paramMap);
  }
  
  private static final int findSize(int paramInt)
  {
    int j;
    if (paramInt <= 5)
    {
      j = 8;
      return j;
    }
    if (paramInt <= 12) {
      return 16;
    }
    int i = 32;
    for (;;)
    {
      j = i;
      if (i >= paramInt + (paramInt >> 2)) {
        break;
      }
      i += i;
    }
  }
  
  public Object find(String paramString)
  {
    int i = paramString.hashCode() & _hashMask;
    int j = i << 1;
    Object localObject = _hashArea[j];
    if ((localObject == paramString) || (paramString.equals(localObject))) {
      return _hashArea[(j + 1)];
    }
    return _find2(paramString, i, localObject);
  }
  
  public List<String> keys()
  {
    int j = _hashArea.length;
    ArrayList localArrayList = new ArrayList(j >> 2);
    int i = 0;
    while (i < j)
    {
      Object localObject = _hashArea[i];
      if (localObject != null) {
        localArrayList.add((String)localObject);
      }
      i += 2;
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.CompactStringObjectMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */