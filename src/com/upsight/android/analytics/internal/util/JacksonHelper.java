package com.upsight.android.analytics.internal.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract interface JacksonHelper
{
  public static class JSONArraySerializer
  {
    private static ObjectMapper sMapper = new ObjectMapper();
    
    public static JSONArray fromArrayNode(ArrayNode paramArrayNode)
    {
      JSONArray localJSONArray = null;
      if (paramArrayNode != null) {}
      try
      {
        localJSONArray = new JSONArray(paramArrayNode.toString());
        return localJSONArray;
      }
      catch (JSONException paramArrayNode) {}
      return null;
    }
    
    public static ArrayNode toArrayNode(JSONArray paramJSONArray)
    {
      try
      {
        paramJSONArray = (ArrayNode)sMapper.readTree(paramJSONArray.toString());
        return paramJSONArray;
      }
      catch (IOException paramJSONArray) {}
      return null;
    }
  }
  
  public static class JSONObjectSerializer
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.util.JacksonHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */