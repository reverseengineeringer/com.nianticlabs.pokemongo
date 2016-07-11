package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class RawSerializer<T>
  extends StdSerializer<T>
{
  public RawSerializer(Class<?> paramClass)
  {
    super(paramClass, false);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    paramJsonFormatVisitorWrapper.expectStringFormat(paramJavaType);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("string", true);
  }
  
  public void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeRawValue(paramT.toString());
  }
  
  public void serializeWithType(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    paramTypeSerializer.writeTypePrefixForScalar(paramT, paramJsonGenerator);
    serialize(paramT, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForScalar(paramT, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.RawSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */