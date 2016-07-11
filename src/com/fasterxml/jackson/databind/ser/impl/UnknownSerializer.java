package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class UnknownSerializer
  extends StdSerializer<Object>
{
  public UnknownSerializer()
  {
    super(Object.class);
  }
  
  public UnknownSerializer(Class<?> paramClass)
  {
    super(paramClass, false);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    paramJsonFormatVisitorWrapper.expectAnyFormat(paramJavaType);
  }
  
  protected void failForEmpty(Object paramObject)
    throws JsonMappingException
  {
    throw new JsonMappingException("No serializer found for class " + paramObject.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) )");
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    return null;
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, Object paramObject)
  {
    return true;
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if (paramSerializerProvider.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
      failForEmpty(paramObject);
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeEndObject();
  }
  
  public final void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    if (paramSerializerProvider.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
      failForEmpty(paramObject);
    }
    paramTypeSerializer.writeTypePrefixForObject(paramObject, paramJsonGenerator);
    paramTypeSerializer.writeTypeSuffixForObject(paramObject, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.UnknownSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */