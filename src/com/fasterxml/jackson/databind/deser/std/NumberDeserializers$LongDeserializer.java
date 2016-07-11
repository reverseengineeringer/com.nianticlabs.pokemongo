package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberDeserializers$LongDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Long>
{
  static final LongDeserializer primitiveInstance = new LongDeserializer(Long.TYPE, Long.valueOf(0L));
  private static final long serialVersionUID = 1L;
  static final LongDeserializer wrapperInstance = new LongDeserializer(Long.class, null);
  
  public NumberDeserializers$LongDeserializer(Class<Long> paramClass, Long paramLong)
  {
    super(paramClass, paramLong);
  }
  
  public Long deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return Long.valueOf(paramJsonParser.getLongValue());
    }
    return _parseLong(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.LongDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */