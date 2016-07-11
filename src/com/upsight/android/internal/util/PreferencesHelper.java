package com.upsight.android.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public final class PreferencesHelper
{
  public static final String INSTALL_TIMESTAMP_NAME = "install_ts";
  private static final String SHARED_PREFERENCES_NAME = "upsight";
  
  public static void clear(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("upsight", 0).edit();
    paramContext.remove(paramString);
    paramContext.apply();
  }
  
  public static boolean contains(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("upsight", 0).contains(paramString);
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("upsight", 0).getBoolean(paramString, paramBoolean);
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    return paramContext.getSharedPreferences("upsight", 0).getFloat(paramString, paramFloat);
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("upsight", 0).getInt(paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    return paramContext.getSharedPreferences("upsight", 0).getLong(paramString, paramLong);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("upsight", 0).getString(paramString1, paramString2);
  }
  
  public static void putBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("upsight", 0).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static void putFloat(Context paramContext, String paramString, float paramFloat)
  {
    paramContext = paramContext.getSharedPreferences("upsight", 0).edit();
    paramContext.putFloat(paramString, paramFloat);
    paramContext.apply();
  }
  
  public static void putInt(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("upsight", 0).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.apply();
  }
  
  public static void putLong(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("upsight", 0).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.apply();
  }
  
  public static void putString(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("upsight", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void registerListener(Context paramContext, SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    paramContext.getSharedPreferences("upsight", 0).registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public static void unregisterListener(Context paramContext, SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    paramContext.getSharedPreferences("upsight", 0).unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.util.PreferencesHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */