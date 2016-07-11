package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$ShortSerializer
  extends NumberSerializers.Base<Short>
{
  private static final Short EMPTY = Short.valueOf();
  static final ShortSerializer instance = new ShortSerializer();
  
  public NumberSerializers$ShortSerializer()
  {
    super(Short.class, JsonParser.NumberType.INT, "number");
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, Short paramShort)
  {
    return EMPTY.equals(paramShort);
  }
  
  public void serialize(Short paramShort, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeNumber(paramShort.shortValue());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.NumberSerializers.ShortSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */