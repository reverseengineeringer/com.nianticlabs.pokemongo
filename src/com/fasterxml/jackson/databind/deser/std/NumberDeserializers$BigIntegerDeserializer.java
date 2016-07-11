package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberDeserializers$BigIntegerDeserializer
  extends StdScalarDeserializer<BigInteger>
{
  public static final BigIntegerDeserializer instance = new BigIntegerDeserializer();
  
  public NumberDeserializers$BigIntegerDeserializer()
  {
    super(BigInteger.class);
  }
  
  public BigInteger deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    BigInteger localBigInteger;
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 4: 
    case 5: 
    default: 
    case 7: 
      for (;;)
      {
        throw paramDeserializationContext.mappingException(_valueClass, paramJsonParser.getCurrentToken());
        switch (NumberDeserializers.1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
        {
        }
      }
      localBigInteger = paramJsonParser.getBigIntegerValue();
    case 8: 
    case 3: 
      do
      {
        return localBigInteger;
        if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
          _failDoubleToIntCoercion(paramJsonParser, paramDeserializationContext, "java.math.BigInteger");
        }
        return paramJsonParser.getDecimalValue().toBigInteger();
        if (!paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
          break;
        }
        paramJsonParser.nextToken();
        localBigInteger = deserialize(paramJsonParser, paramDeserializationContext);
      } while (paramJsonParser.nextToken() == JsonToken.END_ARRAY);
      throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'BigInteger' value but there was more than a single value in the array");
    }
    paramJsonParser = paramJsonParser.getText().trim();
    if (paramJsonParser.length() == 0) {
      return null;
    }
    try
    {
      localBigInteger = new BigInteger(paramJsonParser);
      return localBigInteger;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw paramDeserializationContext.weirdStringException(paramJsonParser, _valueClass, "not a valid representation");
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigIntegerDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */