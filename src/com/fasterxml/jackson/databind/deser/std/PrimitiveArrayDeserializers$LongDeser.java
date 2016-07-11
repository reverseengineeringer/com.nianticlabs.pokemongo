package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.LongBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$LongDeser
  extends PrimitiveArrayDeserializers<long[]>
{
  public static final LongDeser instance = new LongDeser();
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$LongDeser()
  {
    super(long[].class);
  }
  
  private final long[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(_valueClass);
    }
    return new long[] { _parseLongPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public long[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.LongBuilder localLongBuilder = paramDeserializationContext.getArrayBuilders().getLongBuilder();
    Object localObject = (long[])localLongBuilder.resetAndStart();
    int i = 0;
    for (;;)
    {
      try
      {
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          long l = _parseLongPrimitive(paramJsonParser, paramDeserializationContext);
          if (i >= localObject.length)
          {
            long[] arrayOfLong = (long[])localLongBuilder.appendCompletedChunk(localObject, i);
            i = 0;
            localObject = arrayOfLong;
            int j = i + 1;
            localObject[i] = l;
            i = j;
          }
        }
        else
        {
          return (long[])localLongBuilder.completeAndClearBuffer(localObject, i);
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localLongBuilder.bufferedSize() + i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.LongDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */