package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$BooleanDeser
  extends PrimitiveArrayDeserializers<boolean[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$BooleanDeser()
  {
    super(boolean[].class);
  }
  
  private final boolean[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(_valueClass);
    }
    return new boolean[] { _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public boolean[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.BooleanBuilder localBooleanBuilder = paramDeserializationContext.getArrayBuilders().getBooleanBuilder();
    Object localObject = (boolean[])localBooleanBuilder.resetAndStart();
    int i = 0;
    for (;;)
    {
      try
      {
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          boolean bool = _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext);
          if (i >= localObject.length)
          {
            boolean[] arrayOfBoolean = (boolean[])localBooleanBuilder.appendCompletedChunk(localObject, i);
            i = 0;
            localObject = arrayOfBoolean;
            int j = i + 1;
            localObject[i] = bool;
            i = j;
          }
        }
        else
        {
          return (boolean[])localBooleanBuilder.completeAndClearBuffer(localObject, i);
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localBooleanBuilder.bufferedSize() + i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.BooleanDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */