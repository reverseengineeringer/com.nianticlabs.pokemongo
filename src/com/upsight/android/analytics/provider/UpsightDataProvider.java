package com.upsight.android.analytics.provider;

import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.logger.UpsightLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class UpsightDataProvider
{
  private final Map<String, Object> mCachedValues = new HashMap();
  
  public static void register(UpsightContext paramUpsightContext, UpsightDataProvider paramUpsightDataProvider)
  {
    UpsightAnalyticsExtension localUpsightAnalyticsExtension = (UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics");
    if (localUpsightAnalyticsExtension != null)
    {
      localUpsightAnalyticsExtension.getApi().registerDataProvider(paramUpsightDataProvider);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.analytics must be registered in your Android Manifest", new Object[0]);
  }
  
  public abstract Set<String> availableKeys();
  
  public Object get(String paramString)
  {
    try
    {
      paramString = mCachedValues.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void put(String paramString, Object paramObject)
  {
    try
    {
      mCachedValues.put(paramString, paramObject);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.provider.UpsightDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */