package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ByteBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$ByteDeser
  extends PrimitiveArrayDeserializers<byte[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$ByteDeser()
  {
    super(byte[].class);
  }
  
  private final byte[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(_valueClass);
    }
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {}
    for (int i = paramJsonParser.getByteValue();; i = 0)
    {
      return new byte[] { i };
      if (localJsonToken != JsonToken.VALUE_NULL) {
        throw paramDeserializationContext.mappingException(_valueClass.getComponentType());
      }
    }
  }
  
  public byte[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1 = paramJsonParser.getCurrentToken();
    if (localObject1 == JsonToken.VALUE_STRING) {
      return paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
    }
    if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      localObject1 = paramJsonParser.getEmbeddedObject();
      if (localObject1 == null) {
        return null;
      }
      if ((localObject1 instanceof byte[])) {
        return (byte[])localObject1;
      }
    }
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.ByteBuilder localByteBuilder = paramDeserializationContext.getArrayBuilders().getByteBuilder();
    localObject1 = (byte[])localByteBuilder.resetAndStart();
    int j = 0;
    label216:
    label221:
    label234:
    for (;;)
    {
      try
      {
        Object localObject2 = paramJsonParser.nextToken();
        if (localObject2 == JsonToken.END_ARRAY) {
          break label221;
        }
        if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT))
        {
          i = paramJsonParser.getByteValue();
          if (j < localObject1.length) {
            break label234;
          }
          localObject2 = (byte[])localByteBuilder.appendCompletedChunk(localObject1, j);
          j = 0;
          localObject1 = localObject2;
          int k = j + 1;
          localObject1[j] = i;
          j = k;
          continue;
        }
        if (localObject2 == JsonToken.VALUE_NULL) {
          break label216;
        }
      }
      catch (Exception paramJsonParser)
      {
        throw JsonMappingException.wrapWithPath(paramJsonParser, localObject1, localByteBuilder.bufferedSize() + j);
      }
      throw paramDeserializationContext.mappingException(_valueClass.getComponentType());
      int i = 0;
      continue;
      return (byte[])localByteBuilder.completeAndClearBuffer(localObject1, j);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.ByteDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */