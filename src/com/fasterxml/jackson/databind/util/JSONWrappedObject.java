package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class JSONWrappedObject
  implements JsonSerializable
{
  protected final String _prefix;
  protected final JavaType _serializationType;
  protected final String _suffix;
  protected final Object _value;
  
  public JSONWrappedObject(String paramString1, String paramString2, Object paramObject)
  {
    this(paramString1, paramString2, paramObject, (JavaType)null);
  }
  
  public JSONWrappedObject(String paramString1, String paramString2, Object paramObject, JavaType paramJavaType)
  {
    _prefix = paramString1;
    _suffix = paramString2;
    _value = paramObject;
    _serializationType = paramJavaType;
  }
  
  public String getPrefix()
  {
    return _prefix;
  }
  
  public JavaType getSerializationType()
  {
    return _serializationType;
  }
  
  public String getSuffix()
  {
    return _suffix;
  }
  
  public Object getValue()
  {
    return _value;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    if (_prefix != null) {
      paramJsonGenerator.writeRaw(_prefix);
    }
    if (_value == null) {
      paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      if (_suffix != null) {
        paramJsonGenerator.writeRaw(_suffix);
      }
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
 * Qualified Name:     com.fasterxml.jackson.databind.util.JSONWrappedObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */