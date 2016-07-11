package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;

final class ActivityCompat$1
  implements Runnable
{
  ActivityCompat$1(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[val$permissions.length];
    PackageManager localPackageManager = val$activity.getPackageManager();
    String str = val$activity.getPackageName();
    int j = val$permissions.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = localPackageManager.checkPermission(val$permissions[i], str);
      i += 1;
    }
    ((ActivityCompat.OnRequestPermissionsResultCallback)val$activity).onRequestPermissionsResult(val$requestCode, val$permissions, arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityCompat.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */