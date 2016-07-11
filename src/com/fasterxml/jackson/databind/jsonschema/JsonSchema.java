package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Deprecated
public class JsonSchema
{
  private final ObjectNode schema;
  
  @JsonCreator
  public JsonSchema(ObjectNode paramObjectNode)
  {
    schema = paramObjectNode;
  }
  
  public static JsonNode getDefaultSchemaNode()
  {
    ObjectNode localObjectNode = JsonNodeFactory.instance.objectNode();
    localObjectNode.put("type", "any");
    return localObjectNode;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof JsonSchema)) {
        return false;
      }
      paramObject = (JsonSchema)paramObject;
      if (schema != null) {
        break;
      }
    } while (schema == null);
    return false;
    return schema.equals(schema);
  }
  
  @JsonValue
  public ObjectNode getSchemaNode()
  {
    return schema;
  }
  
  public int hashCode()
  {
    return schema.hashCode();
  }
  
  public String toString()
  {
    return schema.toString();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonschema.JsonSchema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */