package crittercism.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class bx$e
  implements bw
{
  private Double a = null;
  
  public bx$e()
  {
    bx.b();
    double d2 = 1.0D;
    Intent localIntent = bx.b().getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    int i = localIntent.getIntExtra("level", -1);
    double d3 = localIntent.getIntExtra("scale", -1);
    double d1 = d2;
    if (i >= 0)
    {
      d1 = d2;
      if (d3 > 0.0D) {
        d1 = i / d3;
      }
    }
    a = Double.valueOf(d1);
  }
  
  public final String a()
  {
    return "battery_level";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */