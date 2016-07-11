package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import java.util.Arrays;

final class PropertySerializerMap$Multi
  extends PropertySerializerMap
{
  private static final int MAX_ENTRIES = 8;
  private final PropertySerializerMap.TypeAndSerializer[] _entries;
  
  public PropertySerializerMap$Multi(PropertySerializerMap paramPropertySerializerMap, PropertySerializerMap.TypeAndSerializer[] paramArrayOfTypeAndSerializer)
  {
    super(paramPropertySerializerMap);
    _entries = paramArrayOfTypeAndSerializer;
  }
  
  public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    int i = _entries.length;
    if (i == 8)
    {
      localObject = this;
      if (_resetWhenFull) {
        localObject = new PropertySerializerMap.Single(this, paramClass, paramJsonSerializer);
      }
      return (PropertySerializerMap)localObject;
    }
    Object localObject = (PropertySerializerMap.TypeAndSerializer[])Arrays.copyOf(_entries, i + 1);
    localObject[i] = new PropertySerializerMap.TypeAndSerializer(paramClass, paramJsonSerializer);
    return new Multi(this, (PropertySerializerMap.TypeAndSerializer[])localObject);
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> paramClass)
  {
    int i = 0;
    int j = _entries.length;
    while (i < j)
    {
      PropertySerializerMap.TypeAndSerializer localTypeAndSerializer = _entries[i];
      if (type == paramClass) {
        return serializer;
      }
      i += 1;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Multi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */