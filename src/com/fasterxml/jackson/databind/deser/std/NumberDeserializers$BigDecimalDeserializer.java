package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.math.BigDecimal;

@JacksonStdImpl
public class NumberDeserializers$BigDecimalDeserializer
  extends StdScalarDeserializer<BigDecimal>
{
  public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();
  
  public NumberDeserializers$BigDecimalDeserializer()
  {
    super(BigDecimal.class);
  }
  
  public BigDecimal deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    BigDecimal localBigDecimal1;
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 4: 
    case 5: 
    default: 
      throw paramDeserializationContext.mappingException(_valueClass, paramJsonParser.getCurrentToken());
    case 7: 
    case 8: 
      localBigDecimal1 = paramJsonParser.getDecimalValue();
    }
    do
    {
      return localBigDecimal1;
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return null;
      }
      try
      {
        localBigDecimal1 = new BigDecimal(paramJsonParser);
        return localBigDecimal1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, _valueClass, "not a valid representation");
      }
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
        break;
      }
      paramJsonParser.nextToken();
      BigDecimal localBigDecimal2 = deserialize(paramJsonParser, paramDeserializationContext);
    } while (paramJsonParser.nextToken() == JsonToken.END_ARRAY);
    throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'BigDecimal' value but there was more than a single value in the array");
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */