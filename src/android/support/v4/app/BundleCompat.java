package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

public class BundleCompat
{
  public static IBinder getBinder(Bundle paramBundle, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return BundleCompatJellybeanMR2.getBinder(paramBundle, paramString);
    }
    return BundleCompatDonut.getBinder(paramBundle, paramString);
  }
  
  public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      BundleCompatJellybeanMR2.putBinder(paramBundle, paramString, paramIBinder);
      return;
    }
    BundleCompatDonut.putBinder(paramBundle, paramString, paramIBinder);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.BundleCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */