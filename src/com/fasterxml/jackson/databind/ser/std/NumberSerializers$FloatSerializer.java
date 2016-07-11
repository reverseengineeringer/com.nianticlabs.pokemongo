package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$FloatSerializer
  extends NumberSerializers.Base<Object>
{
  private static final Float EMPTY = Float.valueOf(0.0F);
  static final FloatSerializer instance = new FloatSerializer();
  
  public NumberSerializers$FloatSerializer()
  {
    super(Float.class, JsonParser.NumberType.FLOAT, "number");
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, Object paramObject)
  {
    return EMPTY.equals(paramObject);
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeNumber(((Float)paramObject).floatValue());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.NumberSerializers.FloatSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */