package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$DoubleDeser
  extends PrimitiveArrayDeserializers<double[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$DoubleDeser()
  {
    super(double[].class);
  }
  
  private final double[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(_valueClass);
    }
    return new double[] { _parseDoublePrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public double[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.DoubleBuilder localDoubleBuilder = paramDeserializationContext.getArrayBuilders().getDoubleBuilder();
    Object localObject = (double[])localDoubleBuilder.resetAndStart();
    int i = 0;
    for (;;)
    {
      try
      {
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          double d = _parseDoublePrimitive(paramJsonParser, paramDeserializationContext);
          if (i >= localObject.length)
          {
            double[] arrayOfDouble = (double[])localDoubleBuilder.appendCompletedChunk(localObject, i);
            i = 0;
            localObject = arrayOfDouble;
            int j = i + 1;
            localObject[i] = d;
            i = j;
          }
        }
        else
        {
          return (double[])localDoubleBuilder.completeAndClearBuffer(localObject, i);
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localObject, localDoubleBuilder.bufferedSize() + i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.DoubleDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */