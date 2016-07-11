package com.upsight.android.analytics.internal.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class JacksonHelper$JSONObjectSerializer
{
  private static ObjectMapper sMapper = new ObjectMapper();
  
  public static JSONObject fromObjectNode(ObjectNode paramObjectNode)
  {
    JSONObject localJSONObject = null;
    if (paramObjectNode != null) {}
    try
    {
      localJSONObject = new JSONObject(paramObjectNode.toString());
      return localJSONObject;
    }
    catch (JSONException paramObjectNode) {}
    return null;
  }
  
  public static ObjectNode toObjectNode(JSONObject paramJSONObject)
  {
    ObjectNode localObjectNode = null;
    if (paramJSONObject != null) {}
    try
    {
      localObjectNode = (ObjectNode)sMapper.readTree(paramJSONObject.toString());
      return localObjectNode;
    }
    catch (IOException paramJSONObject) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.util.JacksonHelper.JSONObjectSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */