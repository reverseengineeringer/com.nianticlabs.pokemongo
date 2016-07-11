package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public final class MissingNode
  extends ValueNode
{
  private static final MissingNode instance = new MissingNode();
  
  public static MissingNode getInstance()
  {
    return instance;
  }
  
  public String asText()
  {
    return "";
  }
  
  public String asText(String paramString)
  {
    return paramString;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.NOT_AVAILABLE;
  }
  
  public <T extends JsonNode> T deepCopy()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.MISSING;
  }
  
  public int hashCode()
  {
    return JsonNodeType.MISSING.ordinal();
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNull();
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNull();
  }
  
  public String toString()
  {
    return "";
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.MissingNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */