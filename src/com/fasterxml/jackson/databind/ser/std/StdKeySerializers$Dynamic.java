package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;

public class StdKeySerializers$Dynamic
  extends StdSerializer<Object>
{
  protected transient PropertySerializerMap _dynamicSerializers = PropertySerializerMap.emptyForProperties();
  
  public StdKeySerializers$Dynamic()
  {
    super(String.class, false);
  }
  
  protected JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    paramClass = paramPropertySerializerMap.findAndAddKeySerializer(paramClass, paramSerializerProvider, null);
    if (paramPropertySerializerMap != map) {
      _dynamicSerializers = map;
    }
    return serializer;
  }
  
  Object readResolve()
  {
    _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    return this;
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    Class localClass = paramObject.getClass();
    PropertySerializerMap localPropertySerializerMap = _dynamicSerializers;
    JsonSerializer localJsonSerializer2 = localPropertySerializerMap.serializerFor(localClass);
    JsonSerializer localJsonSerializer1 = localJsonSerializer2;
    if (localJsonSerializer2 == null) {
      localJsonSerializer1 = _findAndAddDynamic(localPropertySerializerMap, localClass, paramSerializerProvider);
    }
    localJsonSerializer1.serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */