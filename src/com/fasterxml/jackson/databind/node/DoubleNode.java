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

public class DoubleNode
  extends NumericNode
{
  protected final double _value;
  
  public DoubleNode(double paramDouble)
  {
    _value = paramDouble;
  }
  
  public static DoubleNode valueOf(double paramDouble)
  {
    return new DoubleNode(paramDouble);
  }
  
  public String asText()
  {
    return NumberOutput.toString(_value);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public BigInteger bigIntegerValue()
  {
    return decimalValue().toBigInteger();
  }
  
  public boolean canConvertToInt()
  {
    return (_value >= -2.147483648E9D) && (_value <= 2.147483647E9D);
  }
  
  public boolean canConvertToLong()
  {
    return (_value >= -9.223372036854776E18D) && (_value <= 9.223372036854776E18D);
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
    double d;
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof DoubleNode)) {
        break;
      }
      d = _value;
    } while (Double.compare(_value, d) == 0);
    return false;
    return false;
  }
  
  public float floatValue()
  {
    return (float)_value;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(_value);
    return (int)l ^ (int)(l >> 32);
  }
  
  public int intValue()
  {
    return (int)_value;
  }
  
  public boolean isDouble()
  {
    return true;
  }
  
  public boolean isFloatingPointNumber()
  {
    return true;
  }
  
  public long longValue()
  {
    return _value;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.DOUBLE;
  }
  
  public Number numberValue()
  {
    return Double.valueOf(_value);
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
 * Qualified Name:     com.fasterxml.jackson.databind.node.DoubleNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */