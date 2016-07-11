package crittercism.android;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class bx$o
  implements bw
{
  public Integer a = Integer.valueOf(0);
  
  public bx$o()
  {
    bx.b();
    try
    {
      String str = ((TelephonyManager)bx.b().getSystemService("phone")).getNetworkOperator();
      if (str != null) {
        a = Integer.valueOf(Integer.parseInt(str.substring(0, 3)));
      }
      new StringBuilder("mobileCountryCode == ").append(a);
      dx.b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final String a()
  {
    return "mobile_country_code";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */