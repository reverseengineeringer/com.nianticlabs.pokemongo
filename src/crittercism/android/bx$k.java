package crittercism.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

public final class bx$k
  implements bw
{
  public String a = null;
  
  public bx$k()
  {
    bx.b();
    a = bgetResourcesgetConfigurationlocale.getLanguage();
    if ((a == null) || (a.length() == 0)) {
      a = "en";
    }
  }
  
  public final String a()
  {
    return "locale";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */