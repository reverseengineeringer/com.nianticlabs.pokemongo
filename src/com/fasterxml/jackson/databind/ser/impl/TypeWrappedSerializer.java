package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public final class TypeWrappedSerializer
  extends JsonSerializer<Object>
{
  protected final JsonSerializer<Object> _serializer;
  protected final TypeSerializer _typeSerializer;
  
  public TypeWrappedSerializer(TypeSerializer paramTypeSerializer, JsonSerializer<?> paramJsonSerializer)
  {
    _typeSerializer = paramTypeSerializer;
    _serializer = paramJsonSerializer;
  }
  
  public Class<Object> handledType()
  {
    return Object.class;
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    _serializer.serializeWithType(paramObject, paramJsonGenerator, paramSerializerProvider, _typeSerializer);
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    _serializer.serializeWithType(paramObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
  }
  
  public TypeSerializer typeSerializer()
  {
    return _typeSerializer;
  }
  
  public JsonSerializer<Object> valueSerializer()
  {
    return _serializer;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */