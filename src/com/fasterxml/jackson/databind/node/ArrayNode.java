package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayNode
  extends ContainerNode<ArrayNode>
{
  private final List<JsonNode> _children = new ArrayList();
  
  public ArrayNode(JsonNodeFactory paramJsonNodeFactory)
  {
    super(paramJsonNodeFactory);
  }
  
  protected ArrayNode _add(JsonNode paramJsonNode)
  {
    _children.add(paramJsonNode);
    return this;
  }
  
  protected JsonNode _at(JsonPointer paramJsonPointer)
  {
    return get(paramJsonPointer.getMatchingIndex());
  }
  
  protected boolean _childrenEqual(ArrayNode paramArrayNode)
  {
    return _children.equals(_children);
  }
  
  protected ArrayNode _insert(int paramInt, JsonNode paramJsonNode)
  {
    if (paramInt < 0)
    {
      _children.add(0, paramJsonNode);
      return this;
    }
    if (paramInt >= _children.size())
    {
      _children.add(paramJsonNode);
      return this;
    }
    _children.add(paramInt, paramJsonNode);
    return this;
  }
  
  public ArrayNode add(double paramDouble)
  {
    return _add(numberNode(paramDouble));
  }
  
  public ArrayNode add(float paramFloat)
  {
    return _add(numberNode(paramFloat));
  }
  
  public ArrayNode add(int paramInt)
  {
    _add(numberNode(paramInt));
    return this;
  }
  
  public ArrayNode add(long paramLong)
  {
    return _add(numberNode(paramLong));
  }
  
  public ArrayNode add(JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    _add((JsonNode)localObject);
    return this;
  }
  
  public ArrayNode add(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return addNull();
    }
    return _add(booleanNode(paramBoolean.booleanValue()));
  }
  
  public ArrayNode add(Double paramDouble)
  {
    if (paramDouble == null) {
      return addNull();
    }
    return _add(numberNode(paramDouble.doubleValue()));
  }
  
  public ArrayNode add(Float paramFloat)
  {
    if (paramFloat == null) {
      return addNull();
    }
    return _add(numberNode(paramFloat.floatValue()));
  }
  
  public ArrayNode add(Integer paramInteger)
  {
    if (paramInteger == null) {
      return addNull();
    }
    return _add(numberNode(paramInteger.intValue()));
  }
  
  public ArrayNode add(Long paramLong)
  {
    if (paramLong == null) {
      return addNull();
    }
    return _add(numberNode(paramLong.longValue()));
  }
  
  public ArrayNode add(String paramString)
  {
    if (paramString == null) {
      return addNull();
    }
    return _add(textNode(paramString));
  }
  
  public ArrayNode add(BigDecimal paramBigDecimal)
  {
    if (paramBigDecimal == null) {
      return addNull();
    }
    return _add(numberNode(paramBigDecimal));
  }
  
  public ArrayNode add(boolean paramBoolean)
  {
    return _add(booleanNode(paramBoolean));
  }
  
  public ArrayNode add(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return addNull();
    }
    return _add(binaryNode(paramArrayOfByte));
  }
  
  public ArrayNode addAll(ArrayNode paramArrayNode)
  {
    _children.addAll(_children);
    return this;
  }
  
  public ArrayNode addAll(Collection<? extends JsonNode> paramCollection)
  {
    _children.addAll(paramCollection);
    return this;
  }
  
  public ArrayNode addArray()
  {
    ArrayNode localArrayNode = arrayNode();
    _add(localArrayNode);
    return localArrayNode;
  }
  
  public ArrayNode addNull()
  {
    _add(nullNode());
    return this;
  }
  
  public ObjectNode addObject()
  {
    ObjectNode localObjectNode = objectNode();
    _add(localObjectNode);
    return localObjectNode;
  }
  
  public ArrayNode addPOJO(Object paramObject)
  {
    if (paramObject == null)
    {
      addNull();
      return this;
    }
    _add(pojoNode(paramObject));
    return this;
  }
  
  public ArrayNode addRawValue(RawValue paramRawValue)
  {
    if (paramRawValue == null)
    {
      addNull();
      return this;
    }
    _add(rawValueNode(paramRawValue));
    return this;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.START_ARRAY;
  }
  
  public ArrayNode deepCopy()
  {
    ArrayNode localArrayNode = new ArrayNode(_nodeFactory);
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = (JsonNode)localIterator.next();
      _children.add(localJsonNode.deepCopy());
    }
    return localArrayNode;
  }
  
  public Iterator<JsonNode> elements()
  {
    return _children.iterator();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof ArrayNode));
    return _children.equals(_children);
  }
  
  public boolean equals(Comparator<JsonNode> paramComparator, JsonNode paramJsonNode)
  {
    if (!(paramJsonNode instanceof ArrayNode)) {}
    int j;
    do
    {
      return false;
      localObject = (ArrayNode)paramJsonNode;
      j = _children.size();
    } while (((ArrayNode)localObject).size() != j);
    paramJsonNode = _children;
    Object localObject = _children;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label87;
      }
      if (paramComparator.compare(paramJsonNode.get(i), ((List)localObject).get(i)) != 0) {
        break;
      }
      i += 1;
    }
    label87:
    return true;
  }
  
  public ObjectNode findParent(String paramString)
  {
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = ((JsonNode)localIterator.next()).findParent(paramString);
      if (localJsonNode != null) {
        return (ObjectNode)localJsonNode;
      }
    }
    return null;
  }
  
  public List<JsonNode> findParents(String paramString, List<JsonNode> paramList)
  {
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext()) {
      paramList = ((JsonNode)localIterator.next()).findParents(paramString, paramList);
    }
    return paramList;
  }
  
  public JsonNode findValue(String paramString)
  {
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = ((JsonNode)localIterator.next()).findValue(paramString);
      if (localJsonNode != null) {
        return localJsonNode;
      }
    }
    return null;
  }
  
  public List<JsonNode> findValues(String paramString, List<JsonNode> paramList)
  {
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext()) {
      paramList = ((JsonNode)localIterator.next()).findValues(paramString, paramList);
    }
    return paramList;
  }
  
  public List<String> findValuesAsText(String paramString, List<String> paramList)
  {
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext()) {
      paramList = ((JsonNode)localIterator.next()).findValuesAsText(paramString, paramList);
    }
    return paramList;
  }
  
  public JsonNode get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < _children.size())) {
      return (JsonNode)_children.get(paramInt);
    }
    return null;
  }
  
  public JsonNode get(String paramString)
  {
    return null;
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.ARRAY;
  }
  
  public int hashCode()
  {
    return _children.hashCode();
  }
  
  public ArrayNode insert(int paramInt, double paramDouble)
  {
    return _insert(paramInt, numberNode(paramDouble));
  }
  
  public ArrayNode insert(int paramInt, float paramFloat)
  {
    return _insert(paramInt, numberNode(paramFloat));
  }
  
  public ArrayNode insert(int paramInt1, int paramInt2)
  {
    _insert(paramInt1, numberNode(paramInt2));
    return this;
  }
  
  public ArrayNode insert(int paramInt, long paramLong)
  {
    return _insert(paramInt, numberNode(paramLong));
  }
  
  public ArrayNode insert(int paramInt, JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    _insert(paramInt, (JsonNode)localObject);
    return this;
  }
  
  public ArrayNode insert(int paramInt, Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, booleanNode(paramBoolean.booleanValue()));
  }
  
  public ArrayNode insert(int paramInt, Double paramDouble)
  {
    if (paramDouble == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, numberNode(paramDouble.doubleValue()));
  }
  
  public ArrayNode insert(int paramInt, Float paramFloat)
  {
    if (paramFloat == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, numberNode(paramFloat.floatValue()));
  }
  
  public ArrayNode insert(int paramInt, Integer paramInteger)
  {
    if (paramInteger == null)
    {
      insertNull(paramInt);
      return this;
    }
    _insert(paramInt, numberNode(paramInteger.intValue()));
    return this;
  }
  
  public ArrayNode insert(int paramInt, Long paramLong)
  {
    if (paramLong == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, numberNode(paramLong.longValue()));
  }
  
  public ArrayNode insert(int paramInt, String paramString)
  {
    if (paramString == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, textNode(paramString));
  }
  
  public ArrayNode insert(int paramInt, BigDecimal paramBigDecimal)
  {
    if (paramBigDecimal == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, numberNode(paramBigDecimal));
  }
  
  public ArrayNode insert(int paramInt, boolean paramBoolean)
  {
    return _insert(paramInt, booleanNode(paramBoolean));
  }
  
  public ArrayNode insert(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, binaryNode(paramArrayOfByte));
  }
  
  public ArrayNode insertArray(int paramInt)
  {
    ArrayNode localArrayNode = arrayNode();
    _insert(paramInt, localArrayNode);
    return localArrayNode;
  }
  
  public ArrayNode insertNull(int paramInt)
  {
    _insert(paramInt, nullNode());
    return this;
  }
  
  public ObjectNode insertObject(int paramInt)
  {
    ObjectNode localObjectNode = objectNode();
    _insert(paramInt, localObjectNode);
    return localObjectNode;
  }
  
  public ArrayNode insertPOJO(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return insertNull(paramInt);
    }
    return _insert(paramInt, pojoNode(paramObject));
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider)
  {
    return _children.isEmpty();
  }
  
  public JsonNode path(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < _children.size())) {
      return (JsonNode)_children.get(paramInt);
    }
    return MissingNode.getInstance();
  }
  
  public JsonNode path(String paramString)
  {
    return MissingNode.getInstance();
  }
  
  public JsonNode remove(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < _children.size())) {
      return (JsonNode)_children.remove(paramInt);
    }
    return null;
  }
  
  public ArrayNode removeAll()
  {
    _children.clear();
    return this;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    List localList = _children;
    int j = localList.size();
    paramJsonGenerator.writeStartArray(j);
    int i = 0;
    if (i < j)
    {
      JsonNode localJsonNode = (JsonNode)localList.get(i);
      if ((localJsonNode instanceof BaseJsonNode)) {
        ((BaseJsonNode)localJsonNode).serialize(paramJsonGenerator, paramSerializerProvider);
      }
      for (;;)
      {
        i += 1;
        break;
        localJsonNode.serialize(paramJsonGenerator, paramSerializerProvider);
      }
    }
    paramJsonGenerator.writeEndArray();
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    paramTypeSerializer.writeTypePrefixForArray(this, paramJsonGenerator);
    Iterator localIterator = _children.iterator();
    while (localIterator.hasNext()) {
      ((BaseJsonNode)localIterator.next()).serialize(paramJsonGenerator, paramSerializerProvider);
    }
    paramTypeSerializer.writeTypeSuffixForArray(this, paramJsonGenerator);
  }
  
  public JsonNode set(int paramInt, JsonNode paramJsonNode)
  {
    Object localObject = paramJsonNode;
    if (paramJsonNode == null) {
      localObject = nullNode();
    }
    if ((paramInt < 0) || (paramInt >= _children.size())) {
      throw new IndexOutOfBoundsException("Illegal index " + paramInt + ", array size " + size());
    }
    return (JsonNode)_children.set(paramInt, localObject);
  }
  
  public int size()
  {
    return _children.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((size() << 4) + 16);
    localStringBuilder.append('[');
    int i = 0;
    int j = _children.size();
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(((JsonNode)_children.get(i)).toString());
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.ArrayNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */