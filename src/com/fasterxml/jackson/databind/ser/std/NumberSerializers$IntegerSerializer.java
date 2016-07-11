package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$IntegerSerializer
  extends NumberSerializers.Base<Object>
{
  public NumberSerializers$IntegerSerializer()
  {
    super(Integer.class, JsonParser.NumberType.INT, "integer");
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, Object paramObject)
  {
    return EMPTY_INTEGER.equals(paramObject);
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeNumber(((Integer)paramObject).intValue());
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */