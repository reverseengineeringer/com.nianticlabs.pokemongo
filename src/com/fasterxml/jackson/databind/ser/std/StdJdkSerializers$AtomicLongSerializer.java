package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

public class StdJdkSerializers$AtomicLongSerializer
  extends StdScalarSerializer<AtomicLong>
{
  public StdJdkSerializers$AtomicLongSerializer()
  {
    super(AtomicLong.class, false);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectIntegerFormat(paramJavaType);
    if (paramJsonFormatVisitorWrapper != null) {
      paramJsonFormatVisitorWrapper.numberType(JsonParser.NumberType.LONG);
    }
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("integer", true);
  }
  
  public void serialize(AtomicLong paramAtomicLong, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeNumber(paramAtomicLong.get());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdJdkSerializers.AtomicLongSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */