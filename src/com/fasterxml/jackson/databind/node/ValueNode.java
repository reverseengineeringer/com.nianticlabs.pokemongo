package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.List;

public abstract class ValueNode
  extends BaseJsonNode
{
  protected JsonNode _at(JsonPointer paramJsonPointer)
  {
    return MissingNode.getInstance();
  }
  
  public abstract JsonToken asToken();
  
  public <T extends JsonNode> T deepCopy()
  {
    return this;
  }
  
  public final ObjectNode findParent(String paramString)
  {
    return null;
  }
  
  public final List<JsonNode> findParents(String paramString, List<JsonNode> paramList)
  {
    return paramList;
  }
  
  public final JsonNode findValue(String paramString)
  {
    return null;
  }
  
  public final List<JsonNode> findValues(String paramString, List<JsonNode> paramList)
  {
    return paramList;
  }
  
  public final List<String> findValuesAsText(String paramString, List<String> paramList)
  {
    return paramList;
  }
  
  public final JsonNode get(int paramInt)
  {
    return null;
  }
  
  public final JsonNode get(String paramString)
  {
    return null;
  }
  
  public final boolean has(int paramInt)
  {
    return false;
  }
  
  public final boolean has(String paramString)
  {
    return false;
  }
  
  public final boolean hasNonNull(int paramInt)
  {
    return false;
  }
  
  public final boolean hasNonNull(String paramString)
  {
    return false;
  }
  
  public final JsonNode path(int paramInt)
  {
    return MissingNode.getInstance();
  }
  
  public final JsonNode path(String paramString)
  {
    return MissingNode.getInstance();
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    paramTypeSerializer.writeTypePrefixForScalar(this, paramJsonGenerator);
    serialize(paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForScalar(this, paramJsonGenerator);
  }
  
  public String toString()
  {
    return asText();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.ValueNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */