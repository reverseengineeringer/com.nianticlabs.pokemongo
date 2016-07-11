package com.upsight.android.analytics.provider;

import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.logger.UpsightLogger;
import java.util.HashSet;
import java.util.Set;

public abstract class UpsightUserAttributes
{
  public static final String USER_ATTRIBUTES_PREFIX = "com.upsight.user_attribute.";
  
  public static Boolean getBoolean(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null) {
      return localUpsightAnalyticsExtension.getApi().getBooleanUserAttribute(paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return null;
  }
  
  public static Set<Entry> getDefault(UpsightContext paramUpsightContext)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null) {
      return localUpsightAnalyticsExtension.getApi().getDefaultUserAttributes();
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return new HashSet();
  }
  
  public static Float getFloat(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null) {
      return localUpsightAnalyticsExtension.getApi().getFloatUserAttribute(paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return null;
  }
  
  public static Integer getInteger(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null) {
      return localUpsightAnalyticsExtension.getApi().getIntUserAttribute(paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return null;
  }
  
  public static String getString(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null) {
      return localUpsightAnalyticsExtension.getApi().getStringUserAttribute(paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
    return null;
  }
  
  public static void put(UpsightContext paramUpsightContext, String paramString, Boolean paramBoolean)
    throws IllegalArgumentException
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().putUserAttribute(paramString, paramBoolean);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public static void put(UpsightContext paramUpsightContext, String paramString, Float paramFloat)
    throws IllegalArgumentException
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().putUserAttribute(paramString, paramFloat);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public static void put(UpsightContext paramUpsightContext, String paramString, Integer paramInteger)
    throws IllegalArgumentException
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().putUserAttribute(paramString, paramInteger);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public static void put(UpsightContext paramUpsightContext, String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().putUserAttribute(paramString1, paramString2);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public abstract Boolean getBoolean(String paramString);
  
  public abstract Set<Entry> getDefault();
  
  public abstract Float getFloat(String paramString);
  
  public abstract Integer getInt(String paramString);
  
  public abstract String getString(String paramString);
  
  public abstract void put(String paramString, Boolean paramBoolean);
  
  public abstract void put(String paramString, Float paramFloat);
  
  public abstract void put(String paramString, Integer paramInteger);
  
  public abstract void put(String paramString1, String paramString2);
  
  public static class Entry
  {
    private Object mDefaultValue;
    private String mKey;
    
    public Entry(String paramString, Object paramObject)
    {
      mKey = paramString;
      mDefaultValue = paramObject;
    }
    
    public Object getDefaultValue()
    {
      return mDefaultValue;
    }
    
    public String getKey()
    {
      return mKey;
    }
    
    public Class getType()
    {
      return mDefaultValue.getClass();
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.provider.UpsightUserAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */