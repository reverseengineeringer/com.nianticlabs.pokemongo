package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

abstract class BaseNodeDeserializer<T extends JsonNode>
  extends StdDeserializer<T>
{
  public BaseNodeDeserializer(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected final JsonNode _fromEmbedded(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
    throws IOException
  {
    paramJsonParser = paramJsonParser.getEmbeddedObject();
    if (paramJsonParser == null) {
      return paramJsonNodeFactory.nullNode();
    }
    if (paramJsonParser.getClass() == byte[].class) {
      return paramJsonNodeFactory.binaryNode((byte[])paramJsonParser);
    }
    if ((paramJsonParser instanceof RawValue)) {
      return paramJsonNodeFactory.rawValueNode((RawValue)paramJsonParser);
    }
    if ((paramJsonParser instanceof JsonNode)) {
      return (JsonNode)paramJsonParser;
    }
    return paramJsonNodeFactory.pojoNode(paramJsonParser);
  }
  
  protected final JsonNode _fromFloat(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
    throws IOException
  {
    if ((paramJsonParser.getNumberType() == JsonParser.NumberType.BIG_DECIMAL) || (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS))) {
      return paramJsonNodeFactory.numberNode(paramJsonParser.getDecimalValue());
    }
    return paramJsonNodeFactory.numberNode(paramJsonParser.getDoubleValue());
  }
  
  protected final JsonNode _fromInt(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
    throws IOException
  {
    int i = paramDeserializationContext.getDeserializationFeatures();
    if ((F_MASK_INT_COERCIONS & i) != 0) {
      if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(i)) {
        paramDeserializationContext = JsonParser.NumberType.BIG_INTEGER;
      }
    }
    while (paramDeserializationContext == JsonParser.NumberType.INT)
    {
      return paramJsonNodeFactory.numberNode(paramJsonParser.getIntValue());
      if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(i))
      {
        paramDeserializationContext = JsonParser.NumberType.LONG;
      }
      else
      {
        paramDeserializationContext = paramJsonParser.getNumberType();
        continue;
        paramDeserializationContext = paramJsonParser.getNumberType();
      }
    }
    if (paramDeserializationContext == JsonParser.NumberType.LONG) {
      return paramJsonNodeFactory.numberNode(paramJsonParser.getLongValue());
    }
    return paramJsonNodeFactory.numberNode(paramJsonParser.getBigIntegerValue());
  }
  
  protected void _handleDuplicateField(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory, String paramString, ObjectNode paramObjectNode, JsonNode paramJsonNode1, JsonNode paramJsonNode2)
    throws JsonProcessingException
  {
    if (paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
      _reportProblem(paramJsonParser, "Duplicate field '" + paramString + "' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled");
    }
  }
  
  protected void _reportProblem(JsonParser paramJsonParser, String paramString)
    throws JsonMappingException
  {
    throw new JsonMappingException(paramString, paramJsonParser.getTokenLocation());
  }
  
  protected final JsonNode deserializeAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
    throws IOException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 4: 
    default: 
      throw paramDeserializationContext.mappingException(handledType());
    case 1: 
    case 2: 
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 3: 
      return deserializeArray(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 5: 
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 12: 
      return _fromEmbedded(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 6: 
      return paramJsonNodeFactory.textNode(paramJsonParser.getText());
    case 7: 
      return _fromInt(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 8: 
      return _fromFloat(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 9: 
      return paramJsonNodeFactory.booleanNode(true);
    case 10: 
      return paramJsonNodeFactory.booleanNode(false);
    }
    return paramJsonNodeFactory.nullNode();
  }
  
  protected final ArrayNode deserializeArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
    throws IOException
  {
    ArrayNode localArrayNode = paramJsonNodeFactory.arrayNode();
    for (;;)
    {
      JsonToken localJsonToken = paramJsonParser.nextToken();
      if (localJsonToken == null) {
        throw paramDeserializationContext.mappingException("Unexpected end-of-input when binding data into ArrayNode");
      }
      switch (localJsonToken.id())
      {
      case 2: 
      case 5: 
      case 8: 
      default: 
        localArrayNode.add(deserializeAny(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 1: 
        localArrayNode.add(deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 3: 
        localArrayNode.add(deserializeArray(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 12: 
        localArrayNode.add(_fromEmbedded(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
      case 6: 
        localArrayNode.add(paramJsonNodeFactory.textNode(paramJsonParser.getText()));
        break;
      case 7: 
        localArrayNode.add(_fromInt(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 9: 
        localArrayNode.add(paramJsonNodeFactory.booleanNode(true));
        break;
      case 10: 
        localArrayNode.add(paramJsonNodeFactory.booleanNode(false));
        break;
      case 11: 
        localArrayNode.add(paramJsonNodeFactory.nullNode());
      }
    }
    return localArrayNode;
  }
  
  protected final ObjectNode deserializeObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
    throws IOException
  {
    ObjectNode localObjectNode = paramJsonNodeFactory.objectNode();
    String str;
    Object localObject;
    if (paramJsonParser.isExpectedStartObjectToken())
    {
      str = paramJsonParser.nextFieldName();
      if (str == null) {
        break label155;
      }
      switch (paramJsonParser.nextToken().id())
      {
      case 2: 
      case 4: 
      case 5: 
      case 8: 
      default: 
        localObject = deserializeAny(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
      }
    }
    for (;;)
    {
      JsonNode localJsonNode = localObjectNode.replace(str, (JsonNode)localObject);
      if (localJsonNode != null) {
        _handleDuplicateField(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory, str, localObjectNode, localJsonNode, (JsonNode)localObject);
      }
      str = paramJsonParser.nextFieldName();
      break;
      localObject = paramJsonParser.getCurrentToken();
      if (localObject == JsonToken.END_OBJECT) {
        label155:
        return localObjectNode;
      }
      if (localObject != JsonToken.FIELD_NAME) {
        throw paramDeserializationContext.mappingException(handledType(), paramJsonParser.getCurrentToken());
      }
      str = paramJsonParser.getCurrentName();
      break;
      localObject = deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
      continue;
      localObject = deserializeArray(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
      continue;
      localObject = _fromEmbedded(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
      continue;
      localObject = paramJsonNodeFactory.textNode(paramJsonParser.getText());
      continue;
      localObject = _fromInt(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
      continue;
      localObject = paramJsonNodeFactory.booleanNode(true);
      continue;
      localObject = paramJsonNodeFactory.booleanNode(false);
      continue;
      localObject = paramJsonNodeFactory.nullNode();
    }
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
  
  public boolean isCachable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */