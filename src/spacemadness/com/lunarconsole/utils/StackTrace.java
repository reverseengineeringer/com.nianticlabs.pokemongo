package spacemadness.com.lunarconsole.utils;

import spacemadness.com.lunarconsole.debug.Log;

public class StackTrace
{
  public static final String MARKER_ASSETS = "/Assets/";
  public static final String MARKER_AT = " (at ";
  
  public static String optimize(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.length() > 0)
      {
        localObject = paramString.split("\n");
        String[] arrayOfString = new String[localObject.length];
        int i = 0;
        while (i < localObject.length)
        {
          arrayOfString[i] = optimizeLine(localObject[i]);
          i += 1;
        }
        localObject = StringUtils.Join(arrayOfString, "\n");
      }
      return (String)localObject;
    }
    catch (Exception localException)
    {
      Log.e(localException, "Error while optimizing stacktrace: %s", new Object[] { paramString });
    }
    return paramString;
  }
  
  private static String optimizeLine(String paramString)
  {
    int i = paramString.indexOf(" (at ");
    if (i == -1) {}
    int j;
    do
    {
      return paramString;
      j = paramString.lastIndexOf("/Assets/");
    } while (j == -1);
    return paramString.substring(0, " (at ".length() + i) + paramString.substring(j + 1);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.utils.StackTrace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */