package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberDeserializers$IntegerDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Integer>
{
  static final IntegerDeserializer primitiveInstance = new IntegerDeserializer(Integer.TYPE, Integer.valueOf(0));
  private static final long serialVersionUID = 1L;
  static final IntegerDeserializer wrapperInstance = new IntegerDeserializer(Integer.class, null);
  
  public NumberDeserializers$IntegerDeserializer(Class<Integer> paramClass, Integer paramInteger)
  {
    super(paramClass, paramInteger);
  }
  
  public Integer deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return Integer.valueOf(paramJsonParser.getIntValue());
    }
    return _parseInteger(paramJsonParser, paramDeserializationContext);
  }
  
  public Integer deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    if (paramJsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return Integer.valueOf(paramJsonParser.getIntValue());
    }
    return _parseInteger(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */