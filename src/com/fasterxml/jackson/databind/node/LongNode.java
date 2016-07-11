package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class LongNode
  extends NumericNode
{
  protected final long _value;
  
  public LongNode(long paramLong)
  {
    _value = paramLong;
  }
  
  public static LongNode valueOf(long paramLong)
  {
    return new LongNode(paramLong);
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return _value != 0L;
  }
  
  public String asText()
  {
    return NumberOutput.toString(_value);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public BigInteger bigIntegerValue()
  {
    return BigInteger.valueOf(_value);
  }
  
  public boolean canConvertToInt()
  {
    return (_value >= -2147483648L) && (_value <= 2147483647L);
  }
  
  public boolean canConvertToLong()
  {
    return true;
  }
  
  public BigDecimal decimalValue()
  {
    return BigDecimal.valueOf(_value);
  }
  
  public double doubleValue()
  {
    return _value;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof LongNode)) {
        break;
      }
    } while (_value == _value);
    return false;
    return false;
  }
  
  public float floatValue()
  {
    return (float)_value;
  }
  
  public int hashCode()
  {
    return (int)_value ^ (int)(_value >> 32);
  }
  
  public int intValue()
  {
    return (int)_value;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public boolean isLong()
  {
    return true;
  }
  
  public long longValue()
  {
    return _value;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.LONG;
  }
  
  public Number numberValue()
  {
    return Long.valueOf(_value);
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(_value);
  }
  
  public short shortValue()
  {
    return (short)(int)_value;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.LongNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */