package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DecimalNode
  extends NumericNode
{
  private static final BigDecimal MAX_INTEGER;
  private static final BigDecimal MAX_LONG = BigDecimal.valueOf(Long.MAX_VALUE);
  private static final BigDecimal MIN_INTEGER;
  private static final BigDecimal MIN_LONG;
  public static final DecimalNode ZERO = new DecimalNode(BigDecimal.ZERO);
  protected final BigDecimal _value;
  
  static
  {
    MIN_INTEGER = BigDecimal.valueOf(-2147483648L);
    MAX_INTEGER = BigDecimal.valueOf(2147483647L);
    MIN_LONG = BigDecimal.valueOf(Long.MIN_VALUE);
  }
  
  public DecimalNode(BigDecimal paramBigDecimal)
  {
    _value = paramBigDecimal;
  }
  
  public static DecimalNode valueOf(BigDecimal paramBigDecimal)
  {
    return new DecimalNode(paramBigDecimal);
  }
  
  public String asText()
  {
    return _value.toString();
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public BigInteger bigIntegerValue()
  {
    return _value.toBigInteger();
  }
  
  public boolean canConvertToInt()
  {
    return (_value.compareTo(MIN_INTEGER) >= 0) && (_value.compareTo(MAX_INTEGER) <= 0);
  }
  
  public boolean canConvertToLong()
  {
    return (_value.compareTo(MIN_LONG) >= 0) && (_value.compareTo(MAX_LONG) <= 0);
  }
  
  public BigDecimal decimalValue()
  {
    return _value;
  }
  
  public double doubleValue()
  {
    return _value.doubleValue();
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
      if (!(paramObject instanceof DecimalNode)) {
        break;
      }
    } while (_value.compareTo(_value) == 0);
    return false;
    return false;
  }
  
  public float floatValue()
  {
    return _value.floatValue();
  }
  
  public int hashCode()
  {
    return Double.valueOf(doubleValue()).hashCode();
  }
  
  public int intValue()
  {
    return _value.intValue();
  }
  
  public boolean isBigDecimal()
  {
    return true;
  }
  
  public boolean isFloatingPointNumber()
  {
    return true;
  }
  
  public long longValue()
  {
    return _value.longValue();
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.BIG_DECIMAL;
  }
  
  public Number numberValue()
  {
    return _value;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(_value);
  }
  
  public short shortValue()
  {
    return _value.shortValue();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.DecimalNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */