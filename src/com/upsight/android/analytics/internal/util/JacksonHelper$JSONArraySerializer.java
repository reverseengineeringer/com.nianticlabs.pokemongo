package com.upsight.android.analytics.internal.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

public class JacksonHelper$JSONArraySerializer
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.util.JacksonHelper.JSONArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */