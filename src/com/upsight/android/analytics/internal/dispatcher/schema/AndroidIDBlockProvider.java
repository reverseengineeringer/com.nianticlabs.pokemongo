package com.upsight.android.analytics.internal.dispatcher.schema;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AndroidIDBlockProvider
  extends UpsightDataProvider
{
  public static final String ANDROID_ID_KEY = "ids.android_id";
  private static final String ANDROID_ID_NON_UNIQUE = "9774d56d682e549c";
  
  AndroidIDBlockProvider(Context paramContext)
  {
    put("ids.android_id", getAndroidID(paramContext));
  }
  
  private String getAndroidID(Context paramContext)
  {
    String str1 = "9774d56d682e549c";
    String str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((!TextUtils.isEmpty(str2)) && (!"9774d56d682e549c".equals(str2))) {
      paramContext = str2;
    }
    do
    {
      return paramContext;
      str2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      paramContext = str1;
    } while (TextUtils.isEmpty(str2));
    return str2;
  }
  
  public Set<String> availableKeys()
  {
    return new HashSet(Arrays.asList(new String[] { "ids.android_id" }));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.AndroidIDBlockProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */