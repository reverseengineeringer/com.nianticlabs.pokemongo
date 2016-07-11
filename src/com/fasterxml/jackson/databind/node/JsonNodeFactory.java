package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.util.RawValue;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNodeFactory
  implements Serializable, JsonNodeCreator
{
  private static final JsonNodeFactory decimalsAsIs = new JsonNodeFactory(true);
  private static final JsonNodeFactory decimalsNormalized = new JsonNodeFactory(false);
  public static final JsonNodeFactory instance = decimalsNormalized;
  private static final long serialVersionUID = 1L;
  private final boolean _cfgBigDecimalExact;
  
  protected JsonNodeFactory()
  {
    this(false);
  }
  
  public JsonNodeFactory(boolean paramBoolean)
  {
    _cfgBigDecimalExact = paramBoolean;
  }
  
  public static JsonNodeFactory withExactBigDecimals(boolean paramBoolean)
  {
    if (paramBoolean) {
      return decimalsAsIs;
    }
    return decimalsNormalized;
  }
  
  protected boolean _inIntRange(long paramLong)
  {
    return (int)paramLong == paramLong;
  }
  
  public ArrayNode arrayNode()
  {
    return new ArrayNode(this);
  }
  
  public BinaryNode binaryNode(byte[] paramArrayOfByte)
  {
    return BinaryNode.valueOf(paramArrayOfByte);
  }
  
  public BinaryNode binaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return BinaryNode.valueOf(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public BooleanNode booleanNode(boolean paramBoolean)
  {
    if (paramBoolean) {
      return BooleanNode.getTrue();
    }
    return BooleanNode.getFalse();
  }
  
  public NullNode nullNode()
  {
    return NullNode.getInstance();
  }
  
  public NumericNode numberNode(byte paramByte)
  {
    return IntNode.valueOf(paramByte);
  }
  
  public NumericNode numberNode(double paramDouble)
  {
    return DoubleNode.valueOf(paramDouble);
  }
  
  public NumericNode numberNode(float paramFloat)
  {
    return FloatNode.valueOf(paramFloat);
  }
  
  public NumericNode numberNode(int paramInt)
  {
    return IntNode.valueOf(paramInt);
  }
  
  public NumericNode numberNode(long paramLong)
  {
    return LongNode.valueOf(paramLong);
  }
  
  public NumericNode numberNode(BigDecimal paramBigDecimal)
  {
    if (_cfgBigDecimalExact) {
      return DecimalNode.valueOf(paramBigDecimal);
    }
    if (paramBigDecimal.compareTo(BigDecimal.ZERO) == 0) {
      return DecimalNode.ZERO;
    }
    return DecimalNode.valueOf(paramBigDecimal.stripTrailingZeros());
  }
  
  public NumericNode numberNode(BigInteger paramBigInteger)
  {
    return BigIntegerNode.valueOf(paramBigInteger);
  }
  
  public NumericNode numberNode(short paramShort)
  {
    return ShortNode.valueOf(paramShort);
  }
  
  public ValueNode numberNode(Byte paramByte)
  {
    if (paramByte == null) {
      return nullNode();
    }
    return IntNode.valueOf(paramByte.intValue());
  }
  
  public ValueNode numberNode(Double paramDouble)
  {
    if (paramDouble == null) {
      return nullNode();
    }
    return DoubleNode.valueOf(paramDouble.doubleValue());
  }
  
  public ValueNode numberNode(Float paramFloat)
  {
    if (paramFloat == null) {
      return nullNode();
    }
    return FloatNode.valueOf(paramFloat.floatValue());
  }
  
  public ValueNode numberNode(Integer paramInteger)
  {
    if (paramInteger == null) {
      return nullNode();
    }
    return IntNode.valueOf(paramInteger.intValue());
  }
  
  public ValueNode numberNode(Long paramLong)
  {
    if (paramLong == null) {
      return nullNode();
    }
    return LongNode.valueOf(paramLong.longValue());
  }
  
  public ValueNode numberNode(Short paramShort)
  {
    if (paramShort == null) {
      return nullNode();
    }
    return ShortNode.valueOf(paramShort.shortValue());
  }
  
  public ObjectNode objectNode()
  {
    return new ObjectNode(this);
  }
  
  public ValueNode pojoNode(Object paramObject)
  {
    return new POJONode(paramObject);
  }
  
  public ValueNode rawValueNode(RawValue paramRawValue)
  {
    return new POJONode(paramRawValue);
  }
  
  public TextNode textNode(String paramString)
  {
    return TextNode.valueOf(paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.JsonNodeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */