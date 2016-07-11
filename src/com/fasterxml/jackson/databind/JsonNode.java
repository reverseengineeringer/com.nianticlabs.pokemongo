package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.util.EmptyIterator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class JsonNode
  extends JsonSerializable.Base
  implements TreeNode, Iterable<JsonNode>
{
  protected abstract JsonNode _at(JsonPointer paramJsonPointer);
  
  public boolean asBoolean()
  {
    return asBoolean(false);
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public double asDouble()
  {
    return asDouble(0.0D);
  }
  
  public double asDouble(double paramDouble)
  {
    return paramDouble;
  }
  
  public int asInt()
  {
    return asInt(0);
  }
  
  public int asInt(int paramInt)
  {
    return paramInt;
  }
  
  public long asLong()
  {
    return asLong(0L);
  }
  
  public long asLong(long paramLong)
  {
    return paramLong;
  }
  
  public abstract String asText();
  
  public String asText(String paramString)
  {
    String str = asText();
    if (str == null) {
      return paramString;
    }
    return str;
  }
  
  public final JsonNode at(JsonPointer paramJsonPointer)
  {
    if (paramJsonPointer.matches()) {
      return this;
    }
    JsonNode localJsonNode = _at(paramJsonPointer);
    if (localJsonNode == null) {
      return MissingNode.getInstance();
    }
    return localJsonNode.at(paramJsonPointer.tail());
  }
  
  public final JsonNode at(String paramString)
  {
    return at(JsonPointer.compile(paramString));
  }
  
  public BigInteger bigIntegerValue()
  {
    return BigInteger.ZERO;
  }
  
  public byte[] binaryValue()
    throws IOException
  {
    return null;
  }
  
  public boolean booleanValue()
  {
    return false;
  }
  
  public boolean canConvertToInt()
  {
    return false;
  }
  
  public boolean canConvertToLong()
  {
    return false;
  }
  
  public BigDecimal decimalValue()
  {
    return BigDecimal.ZERO;
  }
  
  public abstract <T extends JsonNode> T deepCopy();
  
  public double doubleValue()
  {
    return 0.0D;
  }
  
  public Iterator<JsonNode> elements()
  {
    return EmptyIterator.instance();
  }
  
  public abstract boolean equals(Object paramObject);
  
  public boolean equals(Comparator<JsonNode> paramComparator, JsonNode paramJsonNode)
  {
    return paramComparator.compare(this, paramJsonNode) == 0;
  }
  
  public Iterator<String> fieldNames()
  {
    return EmptyIterator.instance();
  }
  
  public Iterator<Map.Entry<String, JsonNode>> fields()
  {
    return EmptyIterator.instance();
  }
  
  public abstract JsonNode findParent(String paramString);
  
  public final List<JsonNode> findParents(String paramString)
  {
    List localList = findParents(paramString, null);
    paramString = localList;
    if (localList == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  public abstract List<JsonNode> findParents(String paramString, List<JsonNode> paramList);
  
  public abstract JsonNode findPath(String paramString);
  
  public abstract JsonNode findValue(String paramString);
  
  public final List<JsonNode> findValues(String paramString)
  {
    List localList = findValues(paramString, null);
    paramString = localList;
    if (localList == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  public abstract List<JsonNode> findValues(String paramString, List<JsonNode> paramList);
  
  public final List<String> findValuesAsText(String paramString)
  {
    List localList = findValuesAsText(paramString, null);
    paramString = localList;
    if (localList == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  public abstract List<String> findValuesAsText(String paramString, List<String> paramList);
  
  public float floatValue()
  {
    return 0.0F;
  }
  
  public abstract JsonNode get(int paramInt);
  
  public JsonNode get(String paramString)
  {
    return null;
  }
  
  public abstract JsonNodeType getNodeType();
  
  public boolean has(int paramInt)
  {
    return get(paramInt) != null;
  }
  
  public boolean has(String paramString)
  {
    return get(paramString) != null;
  }
  
  public boolean hasNonNull(int paramInt)
  {
    JsonNode localJsonNode = get(paramInt);
    return (localJsonNode != null) && (!localJsonNode.isNull());
  }
  
  public boolean hasNonNull(String paramString)
  {
    paramString = get(paramString);
    return (paramString != null) && (!paramString.isNull());
  }
  
  public int intValue()
  {
    return 0;
  }
  
  public final boolean isArray()
  {
    return getNodeType() == JsonNodeType.ARRAY;
  }
  
  public boolean isBigDecimal()
  {
    return false;
  }
  
  public boolean isBigInteger()
  {
    return false;
  }
  
  public final boolean isBinary()
  {
    return getNodeType() == JsonNodeType.BINARY;
  }
  
  public final boolean isBoolean()
  {
    return getNodeType() == JsonNodeType.BOOLEAN;
  }
  
  public final boolean isContainerNode()
  {
    JsonNodeType localJsonNodeType = getNodeType();
    return (localJsonNodeType == JsonNodeType.OBJECT) || (localJsonNodeType == JsonNodeType.ARRAY);
  }
  
  public boolean isDouble()
  {
    return false;
  }
  
  public boolean isFloat()
  {
    return false;
  }
  
  public boolean isFloatingPointNumber()
  {
    return false;
  }
  
  public boolean isInt()
  {
    return false;
  }
  
  public boolean isIntegralNumber()
  {
    return false;
  }
  
  public boolean isLong()
  {
    return false;
  }
  
  public final boolean isMissingNode()
  {
    return getNodeType() == JsonNodeType.MISSING;
  }
  
  public final boolean isNull()
  {
    return getNodeType() == JsonNodeType.NULL;
  }
  
  public final boolean isNumber()
  {
    return getNodeType() == JsonNodeType.NUMBER;
  }
  
  public final boolean isObject()
  {
    return getNodeType() == JsonNodeType.OBJECT;
  }
  
  public final boolean isPojo()
  {
    return getNodeType() == JsonNodeType.POJO;
  }
  
  public boolean isShort()
  {
    return false;
  }
  
  public final boolean isTextual()
  {
    return getNodeType() == JsonNodeType.STRING;
  }
  
  public final boolean isValueNode()
  {
    switch (getNodeType())
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final Iterator<JsonNode> iterator()
  {
    return elements();
  }
  
  public long longValue()
  {
    return 0L;
  }
  
  public Number numberValue()
  {
    return null;
  }
  
  public abstract JsonNode path(int paramInt);
  
  public abstract JsonNode path(String paramString);
  
  public short shortValue()
  {
    return 0;
  }
  
  public int size()
  {
    return 0;
  }
  
  public String textValue()
  {
    return null;
  }
  
  public abstract String toString();
  
  public JsonNode with(String paramString)
  {
    throw new UnsupportedOperationException("JsonNode not of type ObjectNode (but " + getClass().getName() + "), can not call with() on it");
  }
  
  public JsonNode withArray(String paramString)
  {
    throw new UnsupportedOperationException("JsonNode not of type ObjectNode (but " + getClass().getName() + "), can not call withArray() on it");
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.JsonNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */