package com.upsight.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Upsight
{
  private static final String CORE_COMPONENT_FACTORY = "com.upsight.core";
  private static final String EXTENSION_PREFIX = "com.upsight.extension.";
  public static final String LOG_TAG = "Upsight";
  private static final int MIN_ANDROID_API_LEVEL = 14;
  private static UpsightContext sUpsight;
  
  static UpsightContext create(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return new UpsightContextCompat(paramContext);
    }
    UpsightCoreComponent localUpsightCoreComponent = loadCoreComponent(paramContext);
    paramContext = loadExtensions(paramContext);
    UpsightContext localUpsightContext = localUpsightCoreComponent.upsightContext();
    localUpsightContext.onCreate(localUpsightCoreComponent, paramContext);
    return localUpsightContext;
  }
  
  public static UpsightContext createContext(Context paramContext)
  {
    try
    {
      if (sUpsight == null) {
        sUpsight = create(paramContext);
      }
      paramContext = sUpsight;
      return paramContext;
    }
    finally {}
  }
  
  private static UpsightCoreComponent loadCoreComponent(Context paramContext)
  {
    Object localObject = loadMetadataByName(paramContext, "com.upsight.core");
    if (localObject != null) {
      try
      {
        localObject = Class.forName((String)second);
        if (!UpsightCoreComponent.Factory.class.isAssignableFrom((Class)localObject)) {
          throw new IllegalStateException(String.format("Class %s must implement %s", new Object[] { ((Class)localObject).getName(), UpsightCoreComponent.Factory.class.getName() }));
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        throw new IllegalStateException(paramContext.getMessage(), paramContext);
        paramContext = ((UpsightCoreComponent.Factory)((Class)localObject).newInstance()).create(paramContext);
        return paramContext;
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(paramContext.getMessage(), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(paramContext.getMessage(), paramContext);
      }
    }
    return null;
  }
  
  private static Map<String, UpsightExtension> loadExtensions(Context paramContext)
    throws IllegalStateException
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = loadMetadataByPrefix(paramContext, "com.upsight.extension.").entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramContext = (Map.Entry)localIterator.next();
      try
      {
        localClass = Class.forName((String)paramContext.getValue());
        if (!UpsightExtension.class.isAssignableFrom(localClass)) {
          throw new IllegalStateException(String.format("Class %s must implement %s", new Object[] { localClass.getName(), UpsightExtension.class.getName() }));
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Class localClass;
        throw new IllegalStateException("Unable to load extension: " + (String)paramContext.getKey(), localClassNotFoundException);
        localClassNotFoundException.put(paramContext.getKey(), (UpsightExtension)localClass.newInstance());
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new IllegalStateException("Unable to load extension: " + (String)paramContext.getKey(), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalStateException("Unable to load extension: " + (String)paramContext.getKey(), localIllegalAccessException);
      }
    }
    return localIllegalAccessException;
  }
  
  private static Pair<String, String> loadMetadataByName(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      Bundle localBundle = getPackageManagergetApplicationInfogetPackageName128metaData;
      paramContext = (Context)localObject;
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        String str;
        do
        {
          do
          {
            paramContext = (Context)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramContext = (String)localIterator.next();
          } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(paramString)));
          str = localBundle.getString(paramContext);
        } while (TextUtils.isEmpty(str));
        paramContext = new Pair(paramContext, str);
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("Upsight", "Unexpected error: Package name missing", paramContext);
    }
    return null;
  }
  
  private static Map<String, String> loadMetadataByPrefix(Context paramContext, String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramContext = getPackageManagergetApplicationInfogetPackageName128metaData;
      if (paramContext != null)
      {
        Iterator localIterator = paramContext.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if ((!TextUtils.isEmpty(str1)) && (str1.startsWith(paramString)))
          {
            String str2 = paramContext.getString(str1);
            if (!TextUtils.isEmpty(str2)) {
              localHashMap.put(str1, str2);
            }
          }
        }
      }
      return localHashMap;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("Upsight", "Unexpected error: Package name missing", paramContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.Upsight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */