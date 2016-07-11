package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;

final class PropertySerializerMap$Double
  extends PropertySerializerMap
{
  private final JsonSerializer<Object> _serializer1;
  private final JsonSerializer<Object> _serializer2;
  private final Class<?> _type1;
  private final Class<?> _type2;
  
  public PropertySerializerMap$Double(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass1, JsonSerializer<Object> paramJsonSerializer1, Class<?> paramClass2, JsonSerializer<Object> paramJsonSerializer2)
  {
    super(paramPropertySerializerMap);
    _type1 = paramClass1;
    _serializer1 = paramJsonSerializer1;
    _type2 = paramClass2;
    _serializer2 = paramJsonSerializer2;
  }
  
  public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    return new PropertySerializerMap.Multi(this, new PropertySerializerMap.TypeAndSerializer[] { new PropertySerializerMap.TypeAndSerializer(_type1, _serializer1), new PropertySerializerMap.TypeAndSerializer(_type2, _serializer2), new PropertySerializerMap.TypeAndSerializer(paramClass, paramJsonSerializer) });
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> paramClass)
  {
    if (paramClass == _type1) {
      return _serializer1;
    }
    if (paramClass == _type2) {
      return _serializer2;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Double
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */