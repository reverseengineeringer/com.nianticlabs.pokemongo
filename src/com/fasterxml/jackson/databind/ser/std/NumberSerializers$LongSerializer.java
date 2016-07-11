package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$LongSerializer
  extends NumberSerializers.Base<Object>
{
  private static final Long EMPTY = Long.valueOf(0L);
  static final LongSerializer instance = new LongSerializer();
  
  public NumberSerializers$LongSerializer()
  {
    super(Long.class, JsonParser.NumberType.LONG, "number");
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, Object paramObject)
  {
    return EMPTY.equals(paramObject);
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeNumber(((Long)paramObject).longValue());
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.NumberSerializers.LongSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */