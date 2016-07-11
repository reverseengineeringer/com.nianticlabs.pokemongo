package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$ByteDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Byte>
{
  static final ByteDeserializer primitiveInstance = new ByteDeserializer(Byte.TYPE, Byte.valueOf((byte)0));
  private static final long serialVersionUID = 1L;
  static final ByteDeserializer wrapperInstance = new ByteDeserializer(Byte.class, null);
  
  public NumberDeserializers$ByteDeserializer(Class<Byte> paramClass, Byte paramByte)
  {
    super(paramClass, paramByte);
  }
  
  public Byte deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return _parseByte(paramJsonParser, paramDeserializationContext);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.ByteDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */