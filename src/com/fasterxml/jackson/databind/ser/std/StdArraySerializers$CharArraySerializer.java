package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class StdArraySerializers$CharArraySerializer
  extends StdSerializer<char[]>
{
  public StdArraySerializers$CharArraySerializer()
  {
    super(char[].class);
  }
  
  private final void _writeArrayContents(JsonGenerator paramJsonGenerator, char[] paramArrayOfChar)
    throws IOException, JsonGenerationException
  {
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      paramJsonGenerator.writeString(paramArrayOfChar, i, 1);
      i += 1;
    }
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper != null)
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectArrayFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.itemsFormat(JsonFormatTypes.STRING);
      }
    }
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    paramSerializerProvider = createSchemaNode("array", true);
    paramType = createSchemaNode("string");
    paramType.put("type", "string");
    return paramSerializerProvider.set("items", paramType);
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, char[] paramArrayOfChar)
  {
    return (paramArrayOfChar == null) || (paramArrayOfChar.length == 0);
  }
  
  public void serialize(char[] paramArrayOfChar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
    {
      paramJsonGenerator.writeStartArray(paramArrayOfChar.length);
      _writeArrayContents(paramJsonGenerator, paramArrayOfChar);
      paramJsonGenerator.writeEndArray();
      return;
    }
    paramJsonGenerator.writeString(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void serializeWithType(char[] paramArrayOfChar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonGenerationException
  {
    if (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
    {
      paramTypeSerializer.writeTypePrefixForArray(paramArrayOfChar, paramJsonGenerator);
      _writeArrayContents(paramJsonGenerator, paramArrayOfChar);
      paramTypeSerializer.writeTypeSuffixForArray(paramArrayOfChar, paramJsonGenerator);
      return;
    }
    paramTypeSerializer.writeTypePrefixForScalar(paramArrayOfChar, paramJsonGenerator);
    paramJsonGenerator.writeString(paramArrayOfChar, 0, paramArrayOfChar.length);
    paramTypeSerializer.writeTypeSuffixForScalar(paramArrayOfChar, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdArraySerializers.CharArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */