package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ShortBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$ShortDeser
  extends PrimitiveArrayDeserializers<short[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$ShortDeser()
  {
    super(short[].class);
  }
  
  private final short[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(_valueClass);
    }
    return new short[] { _parseShortPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public short[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.ShortBuilder localShortBuilder = paramDeserializationContext.getArrayBuilders().getShortBuilder();
    Object localObject = (short[])localShortBuilder.resetAndStart();
    int j = 0;
    for (;;)
    {
      try
      {
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          int i = _parseShortPrimitive(paramJsonParser, paramDeserializationContext);
          if (j >= localObject.length)
          {
            short[] arrayOfShort = (short[])localShortBuilder.appendCompletedChunk(localObject, j);
            j = 0;
            localObject = arrayOfShort;
            int k = j + 1;
            localObject[j] = i;
            j = k;
          }
        }
        else
        {
          return (short[])localShortBuilder.completeAndClearBuffer(localObject, j);
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localShortBuilder.bufferedSize() + j);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.ShortDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */