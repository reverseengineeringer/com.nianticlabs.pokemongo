package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$DoubleSerializer
  extends NumberSerializers.Base<Object>
{
  private static final Double EMPTY = Double.valueOf(0.0D);
  static final DoubleSerializer instance = new DoubleSerializer();
  
  public NumberSerializers$DoubleSerializer()
  {
    super(Double.class, JsonParser.NumberType.DOUBLE, "number");
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, Object paramObject)
  {
    return EMPTY.equals(paramObject);
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeNumber(((Double)paramObject).doubleValue());
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */