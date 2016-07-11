package com.crittercism.integrations;

import crittercism.android.dx;

public class PluginException
  extends Throwable
{
  private static final String EMPTY_STRING = "";
  private static final long serialVersionUID = -1947260712494608235L;
  private String exceptionName = null;
  
  private PluginException(String paramString)
  {
    super(paramString);
  }
  
  public PluginException(String paramString1, String paramString2)
  {
    this("", paramString1, paramString2);
  }
  
  public PluginException(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    setExceptionName(checkString(paramString1), checkString(paramString2));
    setStackTrace(createStackTraceArrayFromStack(checkStringStack(paramString3)));
  }
  
  public PluginException(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt)
  {
    super(paramString2);
    setExceptionName(checkString(paramString1), checkString(paramString2));
    setStackTrace(createStackTraceArrayFromStack(paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfInt));
  }
  
  private static String checkString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String[] checkStringStack(String paramString)
  {
    if (paramString == null) {
      return new String[0];
    }
    return paramString.split("\\r?\\n");
  }
  
  private StackTraceElement[] createStackTraceArrayFromStack(String[] paramArrayOfString)
  {
    int k = 0;
    StackTraceElement[] arrayOfStackTraceElement;
    int j;
    if ((paramArrayOfString.length >= 2) && (paramArrayOfString[0] != null) && (paramArrayOfString[1] != null) && (paramArrayOfString[0].equals(paramArrayOfString[1])))
    {
      arrayOfStackTraceElement = new StackTraceElement[paramArrayOfString.length - 1];
      j = 1;
    }
    for (;;)
    {
      int i = k;
      if (j == 0)
      {
        arrayOfStackTraceElement = new StackTraceElement[paramArrayOfString.length];
        i = k;
      }
      if (i < paramArrayOfString.length)
      {
        if ((i != 0) || (j == 0)) {
          if (j == 0) {
            break label111;
          }
        }
        label111:
        for (k = i - 1;; k = i)
        {
          arrayOfStackTraceElement[k] = new StackTraceElement("", paramArrayOfString[i], "", -1);
          i += 1;
          break;
        }
      }
      return arrayOfStackTraceElement;
      j = 0;
      arrayOfStackTraceElement = null;
    }
  }
  
  private StackTraceElement[] createStackTraceArrayFromStack(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt)
  {
    int m = paramArrayOfString1.length;
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[m];
    int i = 0;
    while (i < m)
    {
      int k = paramArrayOfInt[i];
      int j = k;
      if (k <= 0) {
        j = -1;
      }
      arrayOfStackTraceElement[i] = new StackTraceElement(checkString(paramArrayOfString1[i]), checkString(paramArrayOfString2[i]), checkString(paramArrayOfString3[i]), j);
      i += 1;
    }
    return arrayOfStackTraceElement;
  }
  
  public static PluginException createUnityException(String paramString1, String paramString2)
  {
    try
    {
      PluginException localPluginException = unsafeCreateUnityException(paramString1, paramString2);
      return localPluginException;
    }
    catch (ThreadDeath paramString1)
    {
      throw paramString1;
    }
    catch (Throwable localThrowable)
    {
      dx.a("Unable to log unity exception <" + paramString1 + "> " + paramString2, localThrowable);
    }
    return null;
  }
  
  private static PluginException unsafeCreateUnityException(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    int i = ((String)localObject1).indexOf(":");
    Object localObject3;
    Object localObject2;
    if (i != -1)
    {
      localObject3 = ((String)localObject1).substring(0, i).trim();
      paramString2 = (String)localObject3;
      localObject2 = localObject1;
      if (i + 1 < ((String)localObject1).length())
      {
        localObject2 = ((String)localObject1).substring(i + 1).trim();
        paramString2 = (String)localObject3;
      }
    }
    for (;;)
    {
      localObject1 = new PluginException((String)localObject2);
      exceptionName = paramString2;
      localObject2 = paramString1.trim();
      if (((String)localObject2).length() == 0)
      {
        ((PluginException)localObject1).setStackTrace(new StackTraceElement[0]);
        return (PluginException)localObject1;
      }
      localObject3 = ((String)localObject2).split("\\r?\\n");
      StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[localObject3.length];
      int j = 0;
      if (j < localObject3.length)
      {
        Object localObject4 = localObject3[j].trim();
        String str1;
        String str2;
        int k;
        String str3;
        if (((String)localObject4).length() != 0)
        {
          paramString1 = localObject4.split(" ")[0];
          i = paramString1.lastIndexOf(".");
          if (i == -1)
          {
            dx.b("Unable to parse unity exception.  No class and method found for frame frame <" + (String)localObject4 + ">" + (String)localObject2);
            return null;
          }
          if (i == paramString1.length() - 1)
          {
            dx.b("Unable to parse unity exception.  Method is zero length for frame <" + (String)localObject4 + ">" + (String)localObject2);
            return null;
          }
          str1 = paramString1.substring(0, i);
          str2 = paramString1.substring(i + 1);
          paramString2 = null;
          k = -1;
          int m = ((String)localObject4).indexOf(" (at ");
          i = k;
          paramString1 = paramString2;
          if (m != -1)
          {
            str3 = ((String)localObject4).substring(m + 5, localObject3[j].length() - 1);
            localObject4 = str3.split(":");
            if (localObject4.length < 2) {
              break label440;
            }
            paramString1 = localObject4[0];
            i = k;
          }
        }
        for (;;)
        {
          try
          {
            paramString2 = localObject4[(localObject4.length - 1)];
            i = k;
            k = Integer.parseInt(paramString2);
            i = k;
            paramString2 = str3.substring(0, str3.length() - paramString2.length() - 1);
            paramString1 = paramString2;
            i = k;
          }
          catch (NumberFormatException paramString2)
          {
            new StringBuilder("Couldn't parse integer: ").append(localObject4[1]);
            dx.a();
            continue;
          }
          arrayOfStackTraceElement[j] = new StackTraceElement(str1, str2, paramString1, i);
          j += 1;
          break;
          label440:
          new StringBuilder("Unable to parse file & line out of Unity stack trace frame: ").append(localObject4).append(" ::: ").append(localObject3[j]);
          dx.b();
          i = k;
          paramString1 = paramString2;
        }
      }
      ((PluginException)localObject1).setStackTrace(arrayOfStackTraceElement);
      return (PluginException)localObject1;
      paramString2 = (String)localObject1;
      localObject2 = localObject1;
    }
  }
  
  public String getExceptionName()
  {
    return exceptionName;
  }
  
  public void setExceptionName(String paramString1, String paramString2)
  {
    if (paramString1.length() > 0)
    {
      exceptionName = paramString1;
      return;
    }
    exceptionName = "JavaScript Exception";
  }
  
  public final String toString()
  {
    String str1 = getLocalizedMessage();
    String str2 = getExceptionName();
    if (str1 == null) {
      return str2;
    }
    return str2 + ": " + str1;
  }
}

/* Location:
 * Qualified Name:     com.crittercism.integrations.PluginException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */