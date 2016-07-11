package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class StdKeySerializer
  extends StdSerializer<Object>
{
  public StdKeySerializer()
  {
    super(Object.class);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    paramJsonFormatVisitorWrapper.expectStringFormat(paramJavaType);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    return createSchemaNode("string");
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    Class localClass = paramObject.getClass();
    if (localClass == String.class) {
      paramObject = (String)paramObject;
    }
    for (;;)
    {
      paramJsonGenerator.writeFieldName((String)paramObject);
      return;
      if (localClass.isEnum())
      {
        paramObject = (Enum)paramObject;
        if (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
          paramObject = ((Enum)paramObject).toString();
        } else {
          paramObject = ((Enum)paramObject).name();
        }
      }
      else
      {
        if ((paramObject instanceof Date))
        {
          paramSerializerProvider.defaultSerializeDateKey((Date)paramObject, paramJsonGenerator);
          return;
        }
        if (localClass == Class.class) {
          paramObject = ((Class)paramObject).getName();
        } else {
          paramObject = paramObject.toString();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */