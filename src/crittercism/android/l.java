package crittercism.android;

import java.lang.reflect.Constructor;

public final class l
{
  public static Constructor a(String paramString, String[] paramArrayOfString)
  {
    paramString = Class.forName(paramString).getDeclaredConstructors();
    int j = 0;
    while (j < paramString.length)
    {
      Class[] arrayOfClass = paramString[j].getParameterTypes();
      int i;
      if (arrayOfClass.length != paramArrayOfString.length) {
        i = 0;
      }
      while (i != 0)
      {
        return paramString[j];
        i = 0;
        for (;;)
        {
          if (i >= arrayOfClass.length) {
            break label79;
          }
          if (!arrayOfClass[i].getName().equals(paramArrayOfString[i]))
          {
            i = 0;
            break;
          }
          i += 1;
        }
        label79:
        i = 1;
      }
      j += 1;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */