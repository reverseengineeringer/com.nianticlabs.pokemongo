package crittercism.android;

import java.util.List;
import java.util.Map;

public abstract class n
{
  Map a;
  
  public n(Map paramMap)
  {
    a = paramMap;
  }
  
  private String c(String paramString)
  {
    paramString = (List)a.get(paramString);
    if (paramString != null) {
      return (String)paramString.get(paramString.size() - 1);
    }
    return null;
  }
  
  public final long a(String paramString)
  {
    long l = Long.MAX_VALUE;
    paramString = c(paramString);
    if (paramString != null) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return Long.MAX_VALUE;
  }
  
  public final int b(String paramString)
  {
    int i = -1;
    paramString = c(paramString);
    if (paramString != null) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public final String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */