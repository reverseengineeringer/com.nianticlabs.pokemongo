package crittercism.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class d
{
  private ConnectivityManager a;
  
  public d(Context paramContext)
  {
    if (paramContext == null)
    {
      dx.b("Given a null Context.");
      return;
    }
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0)
    {
      a = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
      return;
    }
    dx.b("Add android.permission.ACCESS_NETWORK_STATE to AndroidManifest.xml to get more detailed OPTMZ data");
  }
  
  public final b a()
  {
    if (a == null) {
      return b.c;
    }
    NetworkInfo localNetworkInfo = a.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      return b.d;
    }
    return b.a(localNetworkInfo.getType());
  }
  
  public final String b()
  {
    if (a == null) {
      return "unknown";
    }
    NetworkInfo localNetworkInfo = a.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      return "disconnected";
    }
    int i = localNetworkInfo.getType();
    if (i == 0) {
      switch (localNetworkInfo.getSubtype())
      {
      }
    }
    while (i != 1)
    {
      return "unknown";
      return "2G";
      return "3G";
      return "LTE";
    }
    return "wifi";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */