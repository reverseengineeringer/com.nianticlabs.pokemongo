package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public class FileSerializer
  extends StdScalarSerializer<File>
{
  public FileSerializer()
  {
    super(File.class);
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
  
  public void serialize(File paramFile, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeString(paramFile.getAbsolutePath());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.FileSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */