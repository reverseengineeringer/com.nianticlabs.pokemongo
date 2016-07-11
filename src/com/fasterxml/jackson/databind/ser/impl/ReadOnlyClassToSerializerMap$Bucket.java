package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.TypeKey;

final class ReadOnlyClassToSerializerMap$Bucket
{
  protected final Class<?> _class;
  protected final boolean _isTyped;
  protected final JavaType _type;
  public final Bucket next;
  public final JsonSerializer<Object> value;
  
  public ReadOnlyClassToSerializerMap$Bucket(Bucket paramBucket, TypeKey paramTypeKey, JsonSerializer<Object> paramJsonSerializer)
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */