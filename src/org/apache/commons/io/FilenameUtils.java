package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class FilenameUtils
{
  public static final char EXTENSION_SEPARATOR = '.';
  public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
  private static final char OTHER_SEPARATOR = '\\';
  private static final char SYSTEM_SEPARATOR = File.separatorChar;
  private static final char UNIX_SEPARATOR = '/';
  private static final char WINDOWS_SEPARATOR = '\\';
  
  static
  {
    if (isSystemWindows())
    {
      OTHER_SEPARATOR = '/';
      return;
    }
  }
  
  public static String concat(String paramString1, String paramString2)
  {
    int i = getPrefixLength(paramString2);
    if (i < 0) {}
    do
    {
      return null;
      if (i > 0) {
        return normalize(paramString2);
      }
    } while (paramString1 == null);
    i = paramString1.length();
    if (i == 0) {
      return normalize(paramString2);
    }
    if (isSeparator(paramString1.charAt(i - 1))) {
      return normalize(paramString1 + paramString2);
    }
    return normalize(paramString1 + '/' + paramString2);
  }
  
  public static boolean directoryContains(String paramString1, String paramString2)
    throws IOException
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Directory must not be null");
    }
    if (paramString2 == null) {}
    while (IOCase.SYSTEM.checkEquals(paramString1, paramString2)) {
      return false;
    }
    return IOCase.SYSTEM.checkStartsWith(paramString2, paramString1);
  }
  
  private static String doGetFullPath(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      i = getPrefixLength(paramString);
      if (i < 0) {
        return null;
      }
      if (i < paramString.length()) {
        break;
      }
      str = paramString;
    } while (!paramBoolean);
    return getPrefix(paramString);
    int j = indexOfLastSeparator(paramString);
    if (j < 0) {
      return paramString.substring(0, i);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      j += i;
      i = j;
      if (j == 0) {
        i = j + 1;
      }
      return paramString.substring(0, i);
    }
  }
  
  private static String doGetPath(String paramString, int paramInt)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = getPrefixLength(paramString);
    } while (i < 0);
    int j = indexOfLastSeparator(paramString);
    paramInt = j + paramInt;
    if ((i >= paramString.length()) || (j < 0) || (i >= paramInt)) {
      return "";
    }
    return paramString.substring(i, paramInt);
  }
  
  private static String doNormalize(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null) {
      localObject = null;
    }
    do
    {
      return (String)localObject;
      k = paramString.length();
      localObject = paramString;
    } while (k == 0);
    int i2 = getPrefixLength(paramString);
    if (i2 < 0) {
      return null;
    }
    Object localObject = new char[k + 2];
    paramString.getChars(0, paramString.length(), (char[])localObject, 0);
    if (paramChar == SYSTEM_SEPARATOR) {}
    for (int i = OTHER_SEPARATOR;; i = SYSTEM_SEPARATOR)
    {
      j = 0;
      while (j < localObject.length)
      {
        if (localObject[j] == i) {
          localObject[j] = paramChar;
        }
        j += 1;
      }
    }
    i = 1;
    int j = k;
    if (localObject[(k - 1)] != paramChar)
    {
      localObject[k] = paramChar;
      i = 0;
      j = k + 1;
    }
    int k = i2 + 1;
    int m;
    while (k < j)
    {
      n = k;
      m = j;
      if (localObject[k] == paramChar)
      {
        n = k;
        m = j;
        if (localObject[(k - 1)] == paramChar)
        {
          System.arraycopy(localObject, k, localObject, k - 1, j - k);
          m = j - 1;
          n = k - 1;
        }
      }
      k = n + 1;
      j = m;
    }
    k = i2 + 1;
    int i1;
    while (k < j)
    {
      i1 = k;
      n = i;
      m = j;
      if (localObject[k] == paramChar)
      {
        i1 = k;
        n = i;
        m = j;
        if (localObject[(k - 1)] == '.') {
          if (k != i2 + 1)
          {
            i1 = k;
            n = i;
            m = j;
            if (localObject[(k - 2)] != paramChar) {}
          }
          else
          {
            if (k == j - 1) {
              i = 1;
            }
            System.arraycopy(localObject, k + 1, localObject, k - 1, j - k);
            m = j - 2;
            i1 = k - 1;
            n = i;
          }
        }
      }
      k = i1 + 1;
      i = n;
      j = m;
    }
    k = i2 + 2;
    int n = j;
    j = k;
    if (j < n)
    {
      m = j;
      i1 = i;
      k = n;
      if (localObject[j] == paramChar)
      {
        m = j;
        i1 = i;
        k = n;
        if (localObject[(j - 1)] == '.')
        {
          m = j;
          i1 = i;
          k = n;
          if (localObject[(j - 2)] == '.') {
            if (j != i2 + 2)
            {
              m = j;
              i1 = i;
              k = n;
              if (localObject[(j - 3)] != paramChar) {}
            }
            else
            {
              if (j == i2 + 2) {
                return null;
              }
              if (j == n - 1) {
                i = 1;
              }
              k = j - 4;
              label528:
              if (k < i2) {
                break label612;
              }
              if (localObject[k] != paramChar) {
                break label603;
              }
              System.arraycopy(localObject, j + 1, localObject, k + 1, n - j);
              j = n - (j - k);
              m = k + 1;
              k = j;
            }
          }
        }
      }
      for (i1 = i;; i1 = i)
      {
        j = m + 1;
        i = i1;
        n = k;
        break;
        label603:
        k -= 1;
        break label528;
        label612:
        System.arraycopy(localObject, j + 1, localObject, i2, n - j);
        k = n - (j + 1 - i2);
        m = i2 + 1;
      }
    }
    if (n <= 0) {
      return "";
    }
    if (n <= i2) {
      return new String((char[])localObject, 0, n);
    }
    if ((i != 0) && (paramBoolean)) {
      return new String((char[])localObject, 0, n);
    }
    return new String((char[])localObject, 0, n - 1);
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, false, IOCase.SENSITIVE);
  }
  
  public static boolean equals(String paramString1, String paramString2, boolean paramBoolean, IOCase paramIOCase)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return (paramString1 == null) && (paramString2 == null);
    }
    String str1 = paramString1;
    String str2 = paramString2;
    if (paramBoolean)
    {
      str1 = normalize(paramString1);
      paramString1 = normalize(paramString2);
      if (str1 != null)
      {
        str2 = paramString1;
        if (paramString1 != null) {}
      }
      else
      {
        throw new NullPointerException("Error normalizing one or both of the file names");
      }
    }
    paramString1 = paramIOCase;
    if (paramIOCase == null) {
      paramString1 = IOCase.SENSITIVE;
    }
    return paramString1.checkEquals(str1, str2);
  }
  
  public static boolean equalsNormalized(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, true, IOCase.SENSITIVE);
  }
  
  public static boolean equalsNormalizedOnSystem(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, true, IOCase.SYSTEM);
  }
  
  public static boolean equalsOnSystem(String paramString1, String paramString2)
  {
    return equals(paramString1, paramString2, false, IOCase.SYSTEM);
  }
  
  public static String getBaseName(String paramString)
  {
    return removeExtension(getName(paramString));
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = indexOfExtension(paramString);
    if (i == -1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFullPath(String paramString)
  {
    return doGetFullPath(paramString, true);
  }
  
  public static String getFullPathNoEndSeparator(String paramString)
  {
    return doGetFullPath(paramString, false);
  }
  
  public static String getName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.substring(indexOfLastSeparator(paramString) + 1);
  }
  
  public static String getPath(String paramString)
  {
    return doGetPath(paramString, 1);
  }
  
  public static String getPathNoEndSeparator(String paramString)
  {
    return doGetPath(paramString, 0);
  }
  
  public static String getPrefix(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = getPrefixLength(paramString);
    } while (i < 0);
    if (i > paramString.length()) {
      return paramString + '/';
    }
    return paramString.substring(0, i);
  }
  
  public static int getPrefixLength(String paramString)
  {
    int i = 1;
    if (paramString == null) {
      i = -1;
    }
    char c1;
    do
    {
      int m;
      do
      {
        return i;
        m = paramString.length();
        if (m == 0) {
          return 0;
        }
        c1 = paramString.charAt(0);
        if (c1 == ':') {
          return -1;
        }
        if (m != 1) {
          break;
        }
        if (c1 == '~') {
          return 2;
        }
      } while (isSeparator(c1));
      return 0;
      int k;
      int j;
      if (c1 == '~')
      {
        k = paramString.indexOf('/', 1);
        j = paramString.indexOf('\\', 1);
        if ((k == -1) && (j == -1)) {
          return m + 1;
        }
        i = k;
        if (k == -1) {
          i = j;
        }
        k = j;
        if (j == -1) {
          k = i;
        }
        return Math.min(i, k) + 1;
      }
      char c2 = paramString.charAt(1);
      if (c2 == ':')
      {
        i = Character.toUpperCase(c1);
        if ((i >= 65) && (i <= 90))
        {
          if ((m == 2) || (!isSeparator(paramString.charAt(2)))) {
            return 2;
          }
          return 3;
        }
        return -1;
      }
      if ((isSeparator(c1)) && (isSeparator(c2)))
      {
        k = paramString.indexOf('/', 2);
        j = paramString.indexOf('\\', 2);
        if (((k == -1) && (j == -1)) || (k == 2) || (j == 2)) {
          return -1;
        }
        i = k;
        if (k == -1) {
          i = j;
        }
        k = j;
        if (j == -1) {
          k = i;
        }
        return Math.min(i, k) + 1;
      }
    } while (isSeparator(c1));
    return 0;
  }
  
  public static int indexOfExtension(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int j = paramString.lastIndexOf('.');
    int i = j;
    if (indexOfLastSeparator(paramString) > j) {
      i = -1;
    }
    return i;
  }
  
  public static int indexOfLastSeparator(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
  }
  
  public static boolean isExtension(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      return false;
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break;
      }
    } while (indexOfExtension(paramString1) != -1);
    return true;
    return getExtension(paramString1).equals(paramString2);
  }
  
  public static boolean isExtension(String paramString, Collection<String> paramCollection)
  {
    boolean bool = true;
    if (paramString == null) {}
    do
    {
      while (!paramCollection.hasNext())
      {
        return false;
        if ((paramCollection == null) || (paramCollection.isEmpty()))
        {
          if (indexOfExtension(paramString) == -1) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
        paramString = getExtension(paramString);
        paramCollection = paramCollection.iterator();
      }
    } while (!paramString.equals((String)paramCollection.next()));
    return true;
  }
  
  public static boolean isExtension(String paramString, String[] paramArrayOfString)
  {
    boolean bool = true;
    if (paramString == null) {}
    for (;;)
    {
      return false;
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      {
        if (indexOfExtension(paramString) == -1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      paramString = getExtension(paramString);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static boolean isSeparator(char paramChar)
  {
    return (paramChar == '/') || (paramChar == '\\');
  }
  
  static boolean isSystemWindows()
  {
    return SYSTEM_SEPARATOR == '\\';
  }
  
  public static String normalize(String paramString)
  {
    return doNormalize(paramString, SYSTEM_SEPARATOR, true);
  }
  
  public static String normalize(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (char c = '/';; c = '\\') {
      return doNormalize(paramString, c, true);
    }
  }
  
  public static String normalizeNoEndSeparator(String paramString)
  {
    return doNormalize(paramString, SYSTEM_SEPARATOR, false);
  }
  
  public static String normalizeNoEndSeparator(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (char c = '/';; c = '\\') {
      return doNormalize(paramString, c, false);
    }
  }
  
  public static String removeExtension(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = indexOfExtension(paramString);
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static String separatorsToSystem(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (isSystemWindows()) {
      return separatorsToWindows(paramString);
    }
    return separatorsToUnix(paramString);
  }
  
  public static String separatorsToUnix(String paramString)
  {
    if ((paramString == null) || (paramString.indexOf('\\') == -1)) {
      return paramString;
    }
    return paramString.replace('\\', '/');
  }
  
  public static String separatorsToWindows(String paramString)
  {
    if ((paramString == null) || (paramString.indexOf('/') == -1)) {
      return paramString;
    }
    return paramString.replace('/', '\\');
  }
  
  static String[] splitOnTokens(String paramString)
  {
    if ((paramString.indexOf('?') == -1) && (paramString.indexOf('*') == -1)) {
      return new String[] { paramString };
    }
    paramString = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length)
    {
      if ((paramString[i] == '?') || (paramString[i] == '*'))
      {
        if (localStringBuilder.length() != 0)
        {
          localArrayList.add(localStringBuilder.toString());
          localStringBuilder.setLength(0);
        }
        if (paramString[i] == '?') {
          localArrayList.add("?");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localArrayList.isEmpty()) || ((i > 0) && (!((String)localArrayList.get(localArrayList.size() - 1)).equals("*"))))
        {
          localArrayList.add("*");
          continue;
          localStringBuilder.append(paramString[i]);
        }
      }
    }
    if (localStringBuilder.length() != 0) {
      localArrayList.add(localStringBuilder.toString());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static boolean wildcardMatch(String paramString1, String paramString2)
  {
    return wildcardMatch(paramString1, paramString2, IOCase.SENSITIVE);
  }
  
  public static boolean wildcardMatch(String paramString1, String paramString2, IOCase paramIOCase)
  {
    if ((paramString1 == null) && (paramString2 == null)) {}
    label148:
    label164:
    label205:
    label312:
    for (;;)
    {
      return true;
      if ((paramString1 == null) || (paramString2 == null)) {
        return false;
      }
      IOCase localIOCase = paramIOCase;
      if (paramIOCase == null) {
        localIOCase = IOCase.SENSITIVE;
      }
      paramString2 = splitOnTokens(paramString2);
      int m = 0;
      int i = 0;
      int k = 0;
      paramIOCase = new Stack();
      if (paramIOCase.size() > 0)
      {
        int[] arrayOfInt = (int[])paramIOCase.pop();
        k = arrayOfInt[0];
        i = arrayOfInt[1];
        m = 1;
      }
      int j = i;
      if (k < paramString2.length)
      {
        if (!paramString2[k].equals("?")) {
          break label164;
        }
        i += 1;
        if (i <= paramString1.length()) {
          break label148;
        }
        j = i;
      }
      for (;;)
      {
        if ((k == paramString2.length) && (j == paramString1.length())) {
          break label312;
        }
        i = j;
        if (paramIOCase.size() > 0) {
          break;
        }
        return false;
        j = 0;
        for (;;)
        {
          k += 1;
          m = j;
          break;
          if (!paramString2[k].equals("*")) {
            break label205;
          }
          m = 1;
          j = m;
          if (k == paramString2.length - 1)
          {
            i = paramString1.length();
            j = m;
          }
        }
        if (m != 0)
        {
          i = localIOCase.checkIndexOf(paramString1, i, paramString2[k]);
          j = i;
          if (i == -1) {
            continue;
          }
          m = localIOCase.checkIndexOf(paramString1, i + 1, paramString2[k]);
          j = i;
          if (m >= 0)
          {
            paramIOCase.push(new int[] { k, m });
            j = i;
          }
        }
        do
        {
          i = j + paramString2[k].length();
          j = 0;
          break;
          j = i;
        } while (localIOCase.checkRegionMatches(paramString1, i, paramString2[k]));
        j = i;
      }
    }
  }
  
  public static boolean wildcardMatchOnSystem(String paramString1, String paramString2)
  {
    return wildcardMatch(paramString1, paramString2, IOCase.SYSTEM);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.FilenameUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */