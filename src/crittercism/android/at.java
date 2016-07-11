package crittercism.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crittercism.app.CrittercismConfig;

public final class at
{
  public String a = "1.0";
  public int b = 0;
  
  public at(Context paramContext, CrittercismConfig paramCrittercismConfig)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      a = versionName;
      b = versionCode;
      paramContext = paramCrittercismConfig.getCustomVersionName();
      if ((paramContext != null) && (paramContext.length() > 0)) {
        a = paramContext;
      }
      if (paramCrittercismConfig.isVersionCodeToBeIncludedInVersionString()) {
        a = (a + "-" + Integer.toString(b));
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.at
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */