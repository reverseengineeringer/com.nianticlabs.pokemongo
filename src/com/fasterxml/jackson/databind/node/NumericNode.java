package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class NumericNode
  extends ValueNode
{
  public final double asDouble()
  {
    return doubleValue();
  }
  
  public final double asDouble(double paramDouble)
  {
    return doubleValue();
  }
  
  public final int asInt()
  {
    return intValue();
  }
  
  public final int asInt(int paramInt)
  {
    return intValue();
  }
  
  public final long asLong()
  {
    return longValue();
  }
  
  public final long asLong(long paramLong)
  {
    return longValue();
  }
  
  public abstract String asText();
  
  public abstract BigInteger bigIntegerValue();
  
  public abstract boolean canConvertToInt();
  
  public abstract boolean canConvertToLong();
  
  public abstract BigDecimal decimalValue();
  
  public abstract double doubleValue();
  
  public final JsonNodeType getNodeType()
  {
    return JsonNodeType.NUMBER;
  }
  
  public abstract int intValue();
  
  public abstract long longValue();
  
  public abstract JsonParser.NumberType numberType();
  
  public abstract Number numberValue();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.NumericNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */