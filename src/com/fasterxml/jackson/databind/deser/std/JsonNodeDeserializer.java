package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class JsonNodeDeserializer
  extends BaseNodeDeserializer<JsonNode>
{
  private static final JsonNodeDeserializer instance = new JsonNodeDeserializer();
  
  protected JsonNodeDeserializer()
  {
    super(JsonNode.class);
  }
  
  public static JsonDeserializer<? extends JsonNode> getDeserializer(Class<?> paramClass)
  {
    if (paramClass == ObjectNode.class) {
      return ObjectDeserializer.getInstance();
    }
    if (paramClass == ArrayNode.class) {
      return ArrayDeserializer.getInstance();
    }
    return instance;
  }
  
  public JsonNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    case 2: 
    default: 
      return deserializeAny(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    case 1: 
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    }
    return deserializeArray(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
  }
  
  @Deprecated
  public JsonNode getNullValue()
  {
    return NullNode.getInstance();
  }
  
  public JsonNode getNullValue(DeserializationContext paramDeserializationContext)
  {
    return NullNode.getInstance();
  }
  
  static final class ArrayDeserializer
    extends BaseNodeDeserializer<ArrayNode>
  {
    protected static final ArrayDeserializer _instance = new ArrayDeserializer();
    private static final long serialVersionUID = 1L;
    
    protected ArrayDeserializer()
    {
      super();
    }
    
    public static ArrayDeserializer getInstance()
    {
      return _instance;
    }
    
    public ArrayNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if (paramJsonParser.isExpectedStartArrayToken()) {
        return deserializeArray(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
      }
      throw paramDeserializationContext.mappingException(ArrayNode.class);
    }
  }
  
  static final class ObjectDeserializer
    extends BaseNodeDeserializer<ObjectNode>
  {
    protected static final ObjectDeserializer _instance = new ObjectDeserializer();
    private static final long serialVersionUID = 1L;
    
    protected ObjectDeserializer()
    {
      super();
    }
    
    public static ObjectDeserializer getInstance()
    {
      return _instance;
    }
    
    public ObjectNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      if ((paramJsonParser.isExpectedStartObjectToken()) || (paramJsonParser.hasToken(JsonToken.FIELD_NAME))) {
        return deserializeObject(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
      }
      if (paramJsonParser.hasToken(JsonToken.END_OBJECT)) {
        return paramDeserializationContext.getNodeFactory().objectNode();
      }
      throw paramDeserializationContext.mappingException(ObjectNode.class);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */