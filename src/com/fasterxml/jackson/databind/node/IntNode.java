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

public class IntNode
  extends NumericNode
{
  private static final IntNode[] CANONICALS = new IntNode[12];
  static final int MAX_CANONICAL = 10;
  static final int MIN_CANONICAL = -1;
  protected final int _value;
  
  static
  {
    int i = 0;
    while (i < 12)
    {
      CANONICALS[i] = new IntNode(i - 1);
      i += 1;
    }
  }
  
  public IntNode(int paramInt)
  {
    _value = paramInt;
  }
  
  public static IntNode valueOf(int paramInt)
  {
    if ((paramInt > 10) || (paramInt < -1)) {
      return new IntNode(paramInt);
    }
    return CANONICALS[(paramInt + 1)];
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return _value != 0;
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
    return true;
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
      if (!(paramObject instanceof IntNode)) {
        break;
      }
    } while (_value == _value);
    return false;
    return false;
  }
  
  public float floatValue()
  {
    return _value;
  }
  
  public int hashCode()
  {
    return _value;
  }
  
  public int intValue()
  {
    return _value;
  }
  
  public boolean isInt()
  {
    return true;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public long longValue()
  {
    return _value;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.INT;
  }
  
  public Number numberValue()
  {
    return Integer.valueOf(_value);
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(_value);
  }
  
  public short shortValue()
  {
    return (short)_value;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.IntNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */