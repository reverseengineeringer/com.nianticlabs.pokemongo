package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ContainerNode<T extends ContainerNode<T>>
  extends BaseJsonNode
  implements JsonNodeCreator
{
  protected final JsonNodeFactory _nodeFactory;
  
  protected ContainerNode(JsonNodeFactory paramJsonNodeFactory)
  {
    _nodeFactory = paramJsonNodeFactory;
  }
  
  public final ArrayNode arrayNode()
  {
    return _nodeFactory.arrayNode();
  }
  
  public String asText()
  {
    return "";
  }
  
  public abstract JsonToken asToken();
  
  public final BinaryNode binaryNode(byte[] paramArrayOfByte)
  {
    return _nodeFactory.binaryNode(paramArrayOfByte);
  }
  
  public final BinaryNode binaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return _nodeFactory.binaryNode(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final BooleanNode booleanNode(boolean paramBoolean)
  {
    return _nodeFactory.booleanNode(paramBoolean);
  }
  
  public abstract JsonNode get(int paramInt);
  
  public abstract JsonNode get(String paramString);
  
  public final NullNode nullNode()
  {
    return _nodeFactory.nullNode();
  }
  
  public final NumericNode numberNode(byte paramByte)
  {
    return _nodeFactory.numberNode(paramByte);
  }
  
  public final NumericNode numberNode(double paramDouble)
  {
    return _nodeFactory.numberNode(paramDouble);
  }
  
  public final NumericNode numberNode(float paramFloat)
  {
    return _nodeFactory.numberNode(paramFloat);
  }
  
  public final NumericNode numberNode(int paramInt)
  {
    return _nodeFactory.numberNode(paramInt);
  }
  
  public final NumericNode numberNode(long paramLong)
  {
    return _nodeFactory.numberNode(paramLong);
  }
  
  public final NumericNode numberNode(BigDecimal paramBigDecimal)
  {
    return _nodeFactory.numberNode(paramBigDecimal);
  }
  
  public final NumericNode numberNode(BigInteger paramBigInteger)
  {
    return _nodeFactory.numberNode(paramBigInteger);
  }
  
  public final NumericNode numberNode(short paramShort)
  {
    return _nodeFactory.numberNode(paramShort);
  }
  
  public final ValueNode numberNode(Byte paramByte)
  {
    return _nodeFactory.numberNode(paramByte);
  }
  
  public final ValueNode numberNode(Double paramDouble)
  {
    return _nodeFactory.numberNode(paramDouble);
  }
  
  public final ValueNode numberNode(Float paramFloat)
  {
    return _nodeFactory.numberNode(paramFloat);
  }
  
  public final ValueNode numberNode(Integer paramInteger)
  {
    return _nodeFactory.numberNode(paramInteger);
  }
  
  public final ValueNode numberNode(Long paramLong)
  {
    return _nodeFactory.numberNode(paramLong);
  }
  
  public final ValueNode numberNode(Short paramShort)
  {
    return _nodeFactory.numberNode(paramShort);
  }
  
  public final ObjectNode objectNode()
  {
    return _nodeFactory.objectNode();
  }
  
  public final ValueNode pojoNode(Object paramObject)
  {
    return _nodeFactory.pojoNode(paramObject);
  }
  
  public final ValueNode rawValueNode(RawValue paramRawValue)
  {
    return _nodeFactory.rawValueNode(paramRawValue);
  }
  
  public abstract T removeAll();
  
  public abstract int size();
  
  public final TextNode textNode(String paramString)
  {
    return _nodeFactory.textNode(paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.ContainerNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */