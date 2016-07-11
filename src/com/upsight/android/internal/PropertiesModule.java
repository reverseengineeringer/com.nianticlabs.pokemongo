package com.upsight.android.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.upsight.android.logger.UpsightLogger;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public final class PropertiesModule
{
  public static final String KEY_APP_TOKEN = "com.upsight.app_token";
  public static final String KEY_PUBLIC_KEY = "com.upsight.public_key";
  public static final String KEY_SDK_PLUGIN = "com.upsight.sdk_plugin";
  
  @Provides
  @Named("com.upsight.app_token")
  @Singleton
  String provideApplicationToken(Context paramContext, UpsightLogger paramUpsightLogger)
  {
    Object localObject = null;
    try
    {
      Bundle localBundle = getPackageManagergetApplicationInfogetPackageName128metaData;
      paramContext = (Context)localObject;
      if (localBundle != null) {
        paramContext = localBundle.getString("com.upsight.app_token");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramUpsightLogger.e("Upsight", "Unexpected error: Package name missing", new Object[] { paramContext });
        paramContext = (Context)localObject;
      }
    }
    if (TextUtils.isEmpty(paramContext)) {
      throw new IllegalStateException("App token must be set in the Android Manifest with <meta-data android:name=\"com.upsight.app_token\" android:value=\"UPSIGHT_APPLICATION_TOKEN\" />");
    }
    return paramContext;
  }
  
  @Provides
  @Named("com.upsight.public_key")
  @Singleton
  String providePublicKey(Context paramContext, UpsightLogger paramUpsightLogger)
  {
    Object localObject = null;
    try
    {
      Bundle localBundle = getPackageManagergetApplicationInfogetPackageName128metaData;
      paramContext = (Context)localObject;
      if (localBundle != null) {
        paramContext = localBundle.getString("com.upsight.public_key");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramUpsightLogger.e("Upsight", "Unexpected error: Package name missing", new Object[] { paramContext });
        paramContext = (Context)localObject;
      }
    }
    if (TextUtils.isEmpty(paramContext)) {
      throw new IllegalStateException("Public key must be set in the Android Manifest with <meta-data android:name=\"com.upsight.public_key\" android:value=\"UPSIGHT_PUBLIC_KEY\" />");
    }
    return paramContext;
  }
  
  @Provides
  @Named("com.upsight.sdk_plugin")
  @Singleton
  String provideSdkPlugin(Context paramContext, UpsightLogger paramUpsightLogger)
  {
    String str = "";
    try
    {
      Bundle localBundle = getPackageManagergetApplicationInfogetPackageName128metaData;
      paramContext = str;
      if (localBundle != null) {
        paramContext = localBundle.getString("com.upsight.sdk_plugin", "");
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramUpsightLogger.e("Upsight", "Unexpected error: Package name missing", new Object[] { paramContext });
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.PropertiesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */