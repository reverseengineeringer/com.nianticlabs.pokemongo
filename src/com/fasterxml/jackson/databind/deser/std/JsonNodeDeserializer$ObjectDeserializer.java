package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

final class JsonNodeDeserializer$ObjectDeserializer
  extends BaseNodeDeserializer<ObjectNode>
{
  protected static final ObjectDeserializer _instance = new ObjectDeserializer();
  private static final long serialVersionUID = 1L;
  
  protected JsonNodeDeserializer$ObjectDeserializer()
  {
    super(ObjectNode.class);
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer.ObjectDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */