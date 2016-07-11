package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;

final class PropertySerializerMap$Single
  extends PropertySerializerMap
{
  private final JsonSerializer<Object> _serializer;
  private final Class<?> _type;
  
  public PropertySerializerMap$Single(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramPropertySerializerMap);
    _type = paramClass;
    _serializer = paramJsonSerializer;
  }
  
  public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    return new PropertySerializerMap.Double(this, _type, _serializer, paramClass, paramJsonSerializer);
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> paramClass)
  {
    if (paramClass == _type) {
      return _serializer;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Single
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */