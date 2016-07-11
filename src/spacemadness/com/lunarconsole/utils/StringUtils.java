package spacemadness.com.lunarconsole.utils;

import android.util.Log;
import java.util.Iterator;
import java.util.List;

public class StringUtils
{
  public static boolean IsNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static <T> String Join(List<T> paramList)
  {
    return Join(paramList, ",");
  }
  
  public static <T> String Join(List<T> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      int j = i + 1;
      i = j;
      if (j < paramList.size())
      {
        localStringBuilder.append(paramString);
        i = j;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(byte[] paramArrayOfByte)
  {
    return Join(paramArrayOfByte, ",");
  }
  
  public static String Join(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(paramArrayOfByte[i]);
      if (i < paramArrayOfByte.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(char[] paramArrayOfChar)
  {
    return Join(paramArrayOfChar, ",");
  }
  
  public static String Join(char[] paramArrayOfChar, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      localStringBuilder.append(paramArrayOfChar[i]);
      if (i < paramArrayOfChar.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(double[] paramArrayOfDouble)
  {
    return Join(paramArrayOfDouble, ",");
  }
  
  public static String Join(double[] paramArrayOfDouble, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      localStringBuilder.append(paramArrayOfDouble[i]);
      if (i < paramArrayOfDouble.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(float[] paramArrayOfFloat)
  {
    return Join(paramArrayOfFloat, ",");
  }
  
  public static String Join(float[] paramArrayOfFloat, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      localStringBuilder.append(paramArrayOfFloat[i]);
      if (i < paramArrayOfFloat.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(int[] paramArrayOfInt)
  {
    return Join(paramArrayOfInt, ",");
  }
  
  public static String Join(int[] paramArrayOfInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      localStringBuilder.append(paramArrayOfInt[i]);
      if (i < paramArrayOfInt.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(long[] paramArrayOfLong)
  {
    return Join(paramArrayOfLong, ",");
  }
  
  public static String Join(long[] paramArrayOfLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localStringBuilder.append(paramArrayOfLong[i]);
      if (i < paramArrayOfLong.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static <T> String Join(T[] paramArrayOfT)
  {
    return Join(paramArrayOfT, ",");
  }
  
  public static <T> String Join(T[] paramArrayOfT, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfT.length)
    {
      localStringBuilder.append(paramArrayOfT[i]);
      if (i < paramArrayOfT.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(short[] paramArrayOfShort)
  {
    return Join(paramArrayOfShort, ",");
  }
  
  public static String Join(short[] paramArrayOfShort, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      localStringBuilder.append(paramArrayOfShort[i]);
      if (i < paramArrayOfShort.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String Join(boolean[] paramArrayOfBoolean)
  {
    return Join(paramArrayOfBoolean, ",");
  }
  
  public static String Join(boolean[] paramArrayOfBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      localStringBuilder.append(paramArrayOfBoolean[i]);
      if (i < paramArrayOfBoolean.length - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String NonNullOrEmpty(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static String TryFormat(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length <= 0) {}
      }
    }
    try
    {
      str = String.format(paramString, paramVarArgs);
      return str;
    }
    catch (Exception paramVarArgs)
    {
      Log.e("Lunar", "Error while formatting String: " + paramVarArgs.getMessage());
    }
    return paramString;
  }
  
  public static boolean contains(String paramString, CharSequence paramCharSequence)
  {
    return (paramString != null) && (paramCharSequence != null) && (paramString.contains(paramCharSequence));
  }
  
  public static boolean containsIgnoreCase(String paramString1, String paramString2)
  {
    return (paramString1 != null) && (paramString2 != null) && (paramString1.length() >= paramString2.length()) && (paramString1.toLowerCase().contains(paramString2.toLowerCase()));
  }
  
  public static boolean hasPrefix(String paramString1, String paramString2)
  {
    return (paramString1 != null) && (paramString2 != null) && (paramString1.startsWith(paramString2));
  }
  
  public static int length(String paramString)
  {
    if (paramString != null) {
      return paramString.length();
    }
    return 0;
  }
  
  public static String nullOrNonEmpty(String paramString)
  {
    String str = paramString;
    if (IsNullOrEmpty(paramString)) {
      str = null;
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.utils.StringUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */