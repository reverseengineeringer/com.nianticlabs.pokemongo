package com.voxelbusters.nativeplugins.utilities;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtility
{
  public static int findString(JSONArray paramJSONArray, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        return -1;
      }
      Object localObject = null;
      try
      {
        String str = paramJSONArray.getString(i);
        localObject = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        i += 1;
      }
      if ((localObject != null) && (((String)localObject).equals(paramString))) {
        return i;
      }
    }
  }
  
  public static JSONObject getJSON(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static JSONArray getJSONArray(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return new JSONArray();
  }
  
  public static String getJSONString(HashMap paramHashMap)
  {
    return new JSONObject(paramHashMap).toString();
  }
  
  public static JSONObject getJSONfromBundle(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localJSONObject;
      }
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      try
      {
        localJSONObject.put(str, localObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        Debug.error("NativePlugins.JSONUtility", "Exception while entering key " + str);
      }
    }
  }
  
  public static String[] getKeys(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.names();
    String[] arrayOfString = new String[paramJSONObject.length()];
    int i = 0;
    int j = paramJSONObject.length();
    for (;;)
    {
      if (i >= j) {
        return arrayOfString;
      }
      try
      {
        arrayOfString[i] = paramJSONObject.getString(i);
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public static JSONArray removeIndex(JSONArray paramJSONArray, int paramInt)
  {
    localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      for (;;)
      {
        if (i >= paramJSONArray.length()) {
          return localJSONArray;
        }
        if (i != paramInt) {
          localJSONArray.put(paramJSONArray.get(i));
        }
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.JSONUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */