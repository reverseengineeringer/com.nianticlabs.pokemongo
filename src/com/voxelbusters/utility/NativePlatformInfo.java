package com.voxelbusters.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.voxelbusters.common.Configuration;

public class NativePlatformInfo
{
  private static PackageInfo getPackageInfo()
  {
    Object localObject = Configuration.getContext().getApplicationContext();
    PackageManager localPackageManager = ((Context)localObject).getPackageManager();
    try
    {
      localObject = localPackageManager.getPackageInfo(((Context)localObject).getPackageName(), 0);
      return (PackageInfo)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return null;
  }
  
  public static String getPackageName()
  {
    String str = null;
    PackageInfo localPackageInfo = getPackageInfo();
    Log.e("Utility", localPackageInfo.toString());
    if (localPackageInfo != null) {
      str = packageName;
    }
    return str;
  }
  
  public static String getPackageVersionName()
  {
    String str = null;
    PackageInfo localPackageInfo = getPackageInfo();
    if (localPackageInfo != null) {
      str = versionName;
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.utility.NativePlatformInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */