package com.upsight.android.analytics.internal.dispatcher.schema;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.logger.UpsightLogger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppBlockProvider
  extends UpsightDataProvider
{
  public static final String BUNDLEID_KEY = "app.bundleid";
  public static final String TOKEN_KEY = "app.token";
  public static final String VERSION_KEY = "app.version";
  private final UpsightLogger mLogger;
  
  AppBlockProvider(UpsightContext paramUpsightContext)
  {
    put("app.token", paramUpsightContext.getApplicationToken());
    mLogger = paramUpsightContext.getLogger();
    paramUpsightContext = getPackageInfo(paramUpsightContext);
    if (paramUpsightContext != null)
    {
      put("app.version", versionName);
      put("app.bundleid", packageName);
    }
  }
  
  private PackageInfo getPackageInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      mLogger.e("AppBlock", "Could not get package info", new Object[] { paramContext });
    }
    return null;
  }
  
  public Set<String> availableKeys()
  {
    return new HashSet(Arrays.asList(new String[] { "app.token", "app.version", "app.bundleid" }));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.AppBlockProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */