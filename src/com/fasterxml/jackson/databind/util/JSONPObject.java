package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class JSONPObject
  implements JsonSerializable
{
  protected final String _function;
  protected final JavaType _serializationType;
  protected final Object _value;
  
  public JSONPObject(String paramString, Object paramObject)
  {
    this(paramString, paramObject, (JavaType)null);
  }
  
  public JSONPObject(String paramString, Object paramObject, JavaType paramJavaType)
  {
    _function = paramString;
    _value = paramObject;
    _serializationType = paramJavaType;
  }
  
  public String getFunction()
  {
    return _function;
  }
  
  public JavaType getSerializationType()
  {
    return _serializationType;
  }
  
  public Object getValue()
  {
    return _value;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeRaw(_function);
    paramJsonGenerator.writeRaw('(');
    if (_value == null) {
      paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      paramJsonGenerator.writeRaw(')');
      return;
      if (_serializationType != null) {
        paramSerializerProvider.findTypedValueSerializer(_serializationType, true, null).serialize(_value, paramJsonGenerator, paramSerializerProvider);
      } else {
        paramSerializerProvider.findTypedValueSerializer(_value.getClass(), true, null).serialize(_value, paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    serialize(paramJsonGenerator, paramSerializerProvider);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.JSONPObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */