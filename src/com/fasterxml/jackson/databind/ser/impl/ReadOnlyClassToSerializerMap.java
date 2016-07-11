package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.TypeKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ReadOnlyClassToSerializerMap
{
  private final Bucket[] _buckets;
  private final int _mask;
  private final int _size;
  
  public ReadOnlyClassToSerializerMap(Map<TypeKey, JsonSerializer<Object>> paramMap)
  {
    int i = findSize(paramMap.size());
    _size = i;
    _mask = (i - 1);
    Bucket[] arrayOfBucket = new Bucket[i];
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      TypeKey localTypeKey = (TypeKey)localEntry.getKey();
      i = localTypeKey.hashCode() & _mask;
      arrayOfBucket[i] = new Bucket(arrayOfBucket[i], localTypeKey, (JsonSerializer)localEntry.getValue());
    }
    _buckets = arrayOfBucket;
  }
  
  private static final int findSize(int paramInt)
  {
    if (paramInt <= 64) {
      paramInt += paramInt;
    }
    int i;
    for (;;)
    {
      i = 8;
      while (i < paramInt) {
        i += i;
      }
      paramInt += (paramInt >> 2);
    }
    return i;
  }
  
  public static ReadOnlyClassToSerializerMap from(HashMap<TypeKey, JsonSerializer<Object>> paramHashMap)
  {
    return new ReadOnlyClassToSerializerMap(paramHashMap);
  }
  
  public int size()
  {
    return _size;
  }
  
  public JsonSerializer<Object> typedValueSerializer(JavaType paramJavaType)
  {
    Bucket localBucket2 = _buckets[(TypeKey.typedHash(paramJavaType) & _mask)];
    if (localBucket2 == null) {
      return null;
    }
    Bucket localBucket1 = localBucket2;
    if (localBucket2.matchesTyped(paramJavaType)) {
      return value;
    }
    do
    {
      localBucket2 = next;
      if (localBucket2 == null) {
        break;
      }
      localBucket1 = localBucket2;
    } while (!localBucket2.matchesTyped(paramJavaType));
    return value;
  }
  
  public JsonSerializer<Object> typedValueSerializer(Class<?> paramClass)
  {
    Bucket localBucket2 = _buckets[(TypeKey.typedHash(paramClass) & _mask)];
    if (localBucket2 == null) {
      return null;
    }
    Bucket localBucket1 = localBucket2;
    if (localBucket2.matchesTyped(paramClass)) {
      return value;
    }
    do
    {
      localBucket2 = next;
      if (localBucket2 == null) {
        break;
      }
      localBucket1 = localBucket2;
    } while (!localBucket2.matchesTyped(paramClass));
    return value;
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType paramJavaType)
  {
    Bucket localBucket2 = _buckets[(TypeKey.untypedHash(paramJavaType) & _mask)];
    if (localBucket2 == null) {
      return null;
    }
    Bucket localBucket1 = localBucket2;
    if (localBucket2.matchesUntyped(paramJavaType)) {
      return value;
    }
    do
    {
      localBucket2 = next;
      if (localBucket2 == null) {
        break;
      }
      localBucket1 = localBucket2;
    } while (!localBucket2.matchesUntyped(paramJavaType));
    return value;
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> paramClass)
  {
    Bucket localBucket2 = _buckets[(TypeKey.untypedHash(paramClass) & _mask)];
    if (localBucket2 == null) {
      return null;
    }
    Bucket localBucket1 = localBucket2;
    if (localBucket2.matchesUntyped(paramClass)) {
      return value;
    }
    do
    {
      localBucket2 = next;
      if (localBucket2 == null) {
        break;
      }
      localBucket1 = localBucket2;
    } while (!localBucket2.matchesUntyped(paramClass));
    return value;
  }
  
  private static final class Bucket
  {
    protected final Class<?> _class;
    protected final boolean _isTyped;
    protected final JavaType _type;
    public final Bucket next;
    public final JsonSerializer<Object> value;
    
    public Bucket(Bucket paramBucket, TypeKey paramTypeKey, JsonSerializer<Object> paramJsonSerializer)
    {
      next = paramBucket;
      value = paramJsonSerializer;
      _isTyped = paramTypeKey.isTyped();
      _class = paramTypeKey.getRawType();
      _type = paramTypeKey.getType();
    }
    
    public boolean matchesTyped(JavaType paramJavaType)
    {
      return (_isTyped) && (paramJavaType.equals(_type));
    }
    
    public boolean matchesTyped(Class<?> paramClass)
    {
      return (_class == paramClass) && (_isTyped);
    }
    
    public boolean matchesUntyped(JavaType paramJavaType)
    {
      return (!_isTyped) && (paramJavaType.equals(_type));
    }
    
    public boolean matchesUntyped(Class<?> paramClass)
    {
      return (_class == paramClass) && (!_isTyped);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */