package crittercism.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;

public final class bx$t
  implements bw
{
  private Integer a = null;
  
  public bx$t()
  {
    bx.b();
    int j = bgetResourcesgetConfigurationorientation;
    int i = j;
    Display localDisplay;
    if (j == 0)
    {
      localDisplay = ((WindowManager)bx.b().getSystemService("window")).getDefaultDisplay();
      if (localDisplay.getWidth() != localDisplay.getHeight()) {
        break label71;
      }
      i = 3;
    }
    for (;;)
    {
      a = Integer.valueOf(i);
      return;
      label71:
      if (localDisplay.getWidth() > localDisplay.getHeight()) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public final String a()
  {
    return "orientation";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */