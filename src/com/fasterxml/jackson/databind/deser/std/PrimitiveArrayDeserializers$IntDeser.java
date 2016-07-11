package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.IntBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$IntDeser
  extends PrimitiveArrayDeserializers<int[]>
{
  public static final IntDeser instance = new IntDeser();
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$IntDeser()
  {
    super(int[].class);
  }
  
  private final int[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(_valueClass);
    }
    return new int[] { _parseIntPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public int[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.IntBuilder localIntBuilder = paramDeserializationContext.getArrayBuilders().getIntBuilder();
    Object localObject = (int[])localIntBuilder.resetAndStart();
    int i = 0;
    for (;;)
    {
      try
      {
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          int k = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
          if (i >= localObject.length)
          {
            int[] arrayOfInt = (int[])localIntBuilder.appendCompletedChunk(localObject, i);
            i = 0;
            localObject = arrayOfInt;
            int j = i + 1;
            localObject[i] = k;
            i = j;
          }
        }
        else
        {
          return (int[])localIntBuilder.completeAndClearBuffer(localObject, i);
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localIntBuilder.bufferedSize() + i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.IntDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */