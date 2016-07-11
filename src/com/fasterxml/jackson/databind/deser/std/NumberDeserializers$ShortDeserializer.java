package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$ShortDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Short>
{
  static final ShortDeserializer primitiveInstance = new ShortDeserializer(Short.TYPE, Short.valueOf((short)0));
  private static final long serialVersionUID = 1L;
  static final ShortDeserializer wrapperInstance = new ShortDeserializer(Short.class, null);
  
  public NumberDeserializers$ShortDeserializer(Class<Short> paramClass, Short paramShort)
  {
    super(paramClass, paramShort);
  }
  
  public Short deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    return _parseShort(paramJsonParser, paramDeserializationContext);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.ShortDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */