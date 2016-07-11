package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.fasterxml.jackson.databind.util.TypeKey;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class SerializerCache
{
  private final AtomicReference<ReadOnlyClassToSerializerMap> _readOnlyMap = new AtomicReference();
  private final HashMap<TypeKey, JsonSerializer<Object>> _sharedMap = new HashMap(64);
  
  private final ReadOnlyClassToSerializerMap _makeReadOnlyLookupMap()
  {
    try
    {
      ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap2 = (ReadOnlyClassToSerializerMap)_readOnlyMap.get();
      ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap1 = localReadOnlyClassToSerializerMap2;
      if (localReadOnlyClassToSerializerMap2 == null)
      {
        localReadOnlyClassToSerializerMap1 = ReadOnlyClassToSerializerMap.from(_sharedMap);
        _readOnlyMap.set(localReadOnlyClassToSerializerMap1);
      }
      return localReadOnlyClassToSerializerMap1;
    }
    finally {}
  }
  
  public void addAndResolveNonTypedSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    try
    {
      if (_sharedMap.put(new TypeKey(paramJavaType, false), paramJsonSerializer) == null) {
        _readOnlyMap.set(null);
      }
      if ((paramJsonSerializer instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)paramJsonSerializer).resolve(paramSerializerProvider);
      }
      return;
    }
    finally {}
  }
  
  public void addAndResolveNonTypedSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    try
    {
      if (_sharedMap.put(new TypeKey(paramClass, false), paramJsonSerializer) == null) {
        _readOnlyMap.set(null);
      }
      if ((paramJsonSerializer instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)paramJsonSerializer).resolve(paramSerializerProvider);
      }
      return;
    }
    finally {}
  }
  
  public void addTypedSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer)
  {
    try
    {
      if (_sharedMap.put(new TypeKey(paramJavaType, true), paramJsonSerializer) == null) {
        _readOnlyMap.set(null);
      }
      return;
    }
    finally {}
  }
  
  public void addTypedSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    try
    {
      if (_sharedMap.put(new TypeKey(paramClass, true), paramJsonSerializer) == null) {
        _readOnlyMap.set(null);
      }
      return;
    }
    finally {}
  }
  
  public void flush()
  {
    try
    {
      _sharedMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ReadOnlyClassToSerializerMap getReadOnlyLookupMap()
  {
    ReadOnlyClassToSerializerMap localReadOnlyClassToSerializerMap = (ReadOnlyClassToSerializerMap)_readOnlyMap.get();
    if (localReadOnlyClassToSerializerMap != null) {
      return localReadOnlyClassToSerializerMap;
    }
    return _makeReadOnlyLookupMap();
  }
  
  public int size()
  {
    try
    {
      int i = _sharedMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public JsonSerializer<Object> typedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      paramJavaType = (JsonSerializer)_sharedMap.get(new TypeKey(paramJavaType, true));
      return paramJavaType;
    }
    finally {}
  }
  
  public JsonSerializer<Object> typedValueSerializer(Class<?> paramClass)
  {
    try
    {
      paramClass = (JsonSerializer)_sharedMap.get(new TypeKey(paramClass, true));
      return paramClass;
    }
    finally {}
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType paramJavaType)
  {
    try
    {
      paramJavaType = (JsonSerializer)_sharedMap.get(new TypeKey(paramJavaType, false));
      return paramJavaType;
    }
    finally {}
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> paramClass)
  {
    try
    {
      paramClass = (JsonSerializer)_sharedMap.get(new TypeKey(paramClass, false));
      return paramClass;
    }
    finally {}
  }
  
  @Deprecated
  public static final class TypeKey
    extends TypeKey
  {
    public TypeKey(JavaType paramJavaType, boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public TypeKey(Class<?> paramClass, boolean paramBoolean)
    {
      super(paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.SerializerCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */