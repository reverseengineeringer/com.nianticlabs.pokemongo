package com.voxelbusters.nativeplugins.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONArray;

public class SharedPreferencesUtility
{
  public static JSONArray getJsonArray(String paramString1, int paramInt, Context paramContext, String paramString2)
  {
    return JSONUtility.getJSONArray(getSharedPreferences(paramString1, paramInt, paramContext).getString(paramString2, ""));
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt, Context paramContext)
  {
    return paramContext.getSharedPreferences(paramString, paramInt);
  }
  
  public static void setJSONArray(String paramString1, int paramInt, Context paramContext, String paramString2, JSONArray paramJSONArray)
  {
    paramString1 = getSharedPreferences(paramString1, paramInt, paramContext).edit();
    paramString1.putString(paramString2, paramJSONArray.toString());
    paramString1.commit();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.SharedPreferencesUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */