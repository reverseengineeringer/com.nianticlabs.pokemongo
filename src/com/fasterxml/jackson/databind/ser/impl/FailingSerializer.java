package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class FailingSerializer
  extends StdSerializer<Object>
{
  protected final String _msg;
  
  public FailingSerializer(String paramString)
  {
    super(Object.class);
    _msg = paramString;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType) {}
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    return null;
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    throw new JsonGenerationException(_msg);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.FailingSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */