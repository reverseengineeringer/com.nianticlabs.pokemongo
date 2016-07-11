package com.voxelbusters.nativeplugins.utilities;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class StringUtility
{
  public static boolean contains(String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      if (paramString.contains(paramArrayOfString[i])) {
        return true;
      }
      i += 1;
    }
  }
  
  public static String[] convertJsonStringToStringArray(String paramString)
  {
    String[] arrayOfString = null;
    if (isNullOrEmpty(paramString)) {
      return null;
    }
    Object localObject = arrayOfString;
    int j;
    int i;
    do
    {
      try
      {
        localJSONArray = new JSONArray(paramString);
        localObject = arrayOfString;
        j = localJSONArray.length();
        localObject = arrayOfString;
        arrayOfString = new String[j];
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        JSONArray localJSONArray;
        localJSONException.printStackTrace();
        Debug.error("NativePlugins.StringUtility", "Error in parsing jsonString " + paramString);
        break;
      }
      localObject = arrayOfString;
      arrayOfString[i] = new String(localJSONArray.getString(i));
      i += 1;
    } while (i < j);
    localObject = localJSONException;
    return (String[])localObject;
  }
  
  public static String getBase64DecodedString(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    try
    {
      paramString = new String(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String getCurrencySymbolFromCode(String paramString)
  {
    try
    {
      String str = Currency.getInstance(paramString).getSymbol();
      return str;
    }
    catch (Exception localException)
    {
      Debug.log("NativePlugins.StringUtility", "Error in converting currency code : " + paramString);
    }
    return "";
  }
  
  public static String getCurrentTimeStamp()
  {
    return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
  }
  
  public static String getFileNameWithoutExtension(String paramString)
  {
    String str = paramString;
    int i = paramString.lastIndexOf('.');
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.equals("")) || (paramString.equals("null"));
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.StringUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */