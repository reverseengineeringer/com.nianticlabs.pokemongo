package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract interface JsonNodeCreator
{
  public abstract ArrayNode arrayNode();
  
  public abstract ValueNode binaryNode(byte[] paramArrayOfByte);
  
  public abstract ValueNode binaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract ValueNode booleanNode(boolean paramBoolean);
  
  public abstract ValueNode nullNode();
  
  public abstract ValueNode numberNode(byte paramByte);
  
  public abstract ValueNode numberNode(double paramDouble);
  
  public abstract ValueNode numberNode(float paramFloat);
  
  public abstract ValueNode numberNode(int paramInt);
  
  public abstract ValueNode numberNode(long paramLong);
  
  public abstract ValueNode numberNode(Byte paramByte);
  
  public abstract ValueNode numberNode(Double paramDouble);
  
  public abstract ValueNode numberNode(Float paramFloat);
  
  public abstract ValueNode numberNode(Integer paramInteger);
  
  public abstract ValueNode numberNode(Long paramLong);
  
  public abstract ValueNode numberNode(Short paramShort);
  
  public abstract ValueNode numberNode(BigDecimal paramBigDecimal);
  
  public abstract ValueNode numberNode(BigInteger paramBigInteger);
  
  public abstract ValueNode numberNode(short paramShort);
  
  public abstract ObjectNode objectNode();
  
  public abstract ValueNode pojoNode(Object paramObject);
  
  public abstract ValueNode rawValueNode(RawValue paramRawValue);
  
  public abstract ValueNode textNode(String paramString);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.JsonNodeCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */