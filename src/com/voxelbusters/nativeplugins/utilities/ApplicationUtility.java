package com.voxelbusters.nativeplugins.utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Environment;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.File;
import java.util.List;

public class ApplicationUtility
{
  static final int PLAY_SERVICES_RESOLUTION_REQUEST = 100000;
  
  public static Class<?> GetMainLauncherActivity(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = paramContext.getPackageManager().getLaunchIntentForPackage(str).getComponent().getClassName();
    try
    {
      paramContext = Class.forName(paramContext);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Context getApplicationContext(Context paramContext)
  {
    return paramContext.getApplicationContext();
  }
  
  public static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(getPackageName(paramContext), 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      Debug.error("NativePlugins.ApplicationUtility", "Package name not found!");
    }
    return null;
  }
  
  public static String getApplicationName(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext);
    return paramContext.getPackageManager().getApplicationLabel(localApplicationInfo).toString();
  }
  
  public static File getExternalTempDirectoryIfExists(Context paramContext, String paramString)
  {
    if (hasExternalStorageWritable(paramContext)) {
      return getSaveDirectory(paramContext, paramString, paramContext.getApplicationContext().getExternalCacheDir());
    }
    return getLocalSaveDirectory(paramContext, paramString);
  }
  
  public static String getFileProviderAuthoityName(Context paramContext)
  {
    return getPackageName(paramContext) + ".fileprovider";
  }
  
  public static File getLocalSaveDirectory(Context paramContext, String paramString)
  {
    return getSaveDirectory(paramContext, paramString, paramContext.getApplicationContext().getFilesDir());
  }
  
  public static String getPackageName(Context paramContext)
  {
    return paramContext.getPackageName();
  }
  
  public static int getResourceId(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = StringUtility.getFileNameWithoutExtension(paramString1);
    String str = getPackageName(paramContext);
    return paramContext.getResources().getIdentifier(paramString1, paramString2, str);
  }
  
  static File getSaveDirectory(Context paramContext, String paramString, File paramFile)
  {
    String str = paramString;
    if (StringUtility.isNullOrEmpty(paramString)) {
      str = getApplicationName(paramContext);
    }
    paramContext = new File(paramFile, str);
    paramContext.mkdirs();
    return paramContext;
  }
  
  public static String getString(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getString(paramInt);
  }
  
  public static Object getSystemService(Context paramContext, String paramString)
  {
    return paramContext.getSystemService(paramString);
  }
  
  public static boolean hasExternalStorageWritable(Context paramContext)
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean hasPermission(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, getPackageName(paramContext)) == 0;
  }
  
  public static boolean isGooglePlayServicesAvailable(Context paramContext)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
        GooglePlayServicesUtil.getErrorDialog(i, (Activity)paramContext, 100000).show();
      }
      for (;;)
      {
        return false;
        Debug.error("NativePlugins.ApplicationUtility", "This device does not support Google Play Services.");
      }
    }
    return true;
  }
  
  public static boolean isIntentAvailable(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  public static boolean isIntentAvailable(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Intent(paramString1);
    paramString1.setType(paramString2);
    if (paramString3 != null) {
      paramString1.setPackage(paramString3);
    }
    return isIntentAvailable(paramContext, paramString1);
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.ApplicationUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */