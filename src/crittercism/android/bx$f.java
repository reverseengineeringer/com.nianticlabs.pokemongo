package crittercism.android;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

public final class bx$f
  implements bw
{
  public String a = null;
  
  public bx$f()
  {
    bx.b();
    try
    {
      String str1 = ((TelephonyManager)bx.b().getSystemService("phone")).getNetworkOperatorName();
      a = str1;
      new StringBuilder("carrier == ").append(a);
      dx.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = Build.BRAND;
      }
    }
  }
  
  public final String a()
  {
    return "carrier";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */