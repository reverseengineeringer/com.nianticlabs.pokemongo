package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberDeserializers$NumberDeserializer
  extends StdScalarDeserializer<Object>
{
  public static final NumberDeserializer instance = new NumberDeserializer();
  
  public NumberDeserializers$NumberDeserializer()
  {
    super(Number.class);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1;
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 4: 
    case 5: 
    default: 
      throw paramDeserializationContext.mappingException(_valueClass, paramJsonParser.getCurrentToken());
    case 7: 
      if (paramDeserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
        localObject1 = _coerceIntegral(paramJsonParser, paramDeserializationContext);
      }
      break;
    }
    label240:
    do
    {
      return localObject1;
      return paramJsonParser.getNumberValue();
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return getEmptyValue(paramDeserializationContext);
      }
      if (_hasTextualNull(paramJsonParser)) {
        return getNullValue(paramDeserializationContext);
      }
      if (_isPosInf(paramJsonParser)) {
        return Double.valueOf(Double.POSITIVE_INFINITY);
      }
      if (_isNegInf(paramJsonParser)) {
        return Double.valueOf(Double.NEGATIVE_INFINITY);
      }
      if (_isNaN(paramJsonParser)) {
        return Double.valueOf(NaN.0D);
      }
      try
      {
        if (_isIntNumber(paramJsonParser)) {
          break label240;
        }
        if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS))
        {
          localObject1 = new BigDecimal(paramJsonParser);
          return localObject1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, _valueClass, "not a valid number");
      }
      return new Double(paramJsonParser);
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
        return new BigInteger(paramJsonParser);
      }
      long l = Long.parseLong(paramJsonParser);
      if ((!paramDeserializationContext.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS)) && (l <= 2147483647L) && (l >= -2147483648L)) {
        return Integer.valueOf((int)l);
      }
      return Long.valueOf(l);
      if (!paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
        break;
      }
      paramJsonParser.nextToken();
      Object localObject2 = deserialize(paramJsonParser, paramDeserializationContext);
    } while (paramJsonParser.nextToken() == JsonToken.END_ARRAY);
    throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _valueClass.getName() + "' value but there was more than a single value in the array");
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    default: 
      return paramTypeDeserializer.deserializeTypedFromScalar(paramJsonParser, paramDeserializationContext);
    }
    return deserialize(paramJsonParser, paramDeserializationContext);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */