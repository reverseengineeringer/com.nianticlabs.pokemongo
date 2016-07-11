package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FloatNode
  extends NumericNode
{
  protected final float _value;
  
  public FloatNode(float paramFloat)
  {
    _value = paramFloat;
  }
  
  public static FloatNode valueOf(float paramFloat)
  {
    return new FloatNode(paramFloat);
  }
  
  public String asText()
  {
    return Float.toString(_value);
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
    return (_value >= -2.14748365E9F) && (_value <= 2.14748365E9F);
  }
  
  public boolean canConvertToLong()
  {
    return (_value >= -9.223372E18F) && (_value <= 9.223372E18F);
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
    float f;
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof FloatNode)) {
        break;
      }
      f = _value;
    } while (Float.compare(_value, f) == 0);
    return false;
    return false;
  }
  
  public float floatValue()
  {
    return _value;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(_value);
  }
  
  public int intValue()
  {
    return (int)_value;
  }
  
  public boolean isFloat()
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
    return JsonParser.NumberType.FLOAT;
  }
  
  public Number numberValue()
  {
    return Float.valueOf(_value);
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeNumber(_value);
  }
  
  public short shortValue()
  {
    return (short)(int)_value;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.FloatNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */