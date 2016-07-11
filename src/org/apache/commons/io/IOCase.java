package org.apache.commons.io;

import java.io.Serializable;

public final class IOCase
  implements Serializable
{
  public static final IOCase INSENSITIVE;
  public static final IOCase SENSITIVE;
  public static final IOCase SYSTEM;
  private static final long serialVersionUID = -6343169151696340687L;
  private final String name;
  private final transient boolean sensitive;
  
  static
  {
    boolean bool = true;
    SENSITIVE = new IOCase("Sensitive", true);
    INSENSITIVE = new IOCase("Insensitive", false);
    if (!FilenameUtils.isSystemWindows()) {}
    for (;;)
    {
      SYSTEM = new IOCase("System", bool);
      return;
      bool = false;
    }
  }
  
  private IOCase(String paramString, boolean paramBoolean)
  {
    name = paramString;
    sensitive = paramBoolean;
  }
  
  public static IOCase forName(String paramString)
  {
    if (SENSITIVEname.equals(paramString)) {
      return SENSITIVE;
    }
    if (INSENSITIVEname.equals(paramString)) {
      return INSENSITIVE;
    }
    if (SYSTEMname.equals(paramString)) {
      return SYSTEM;
    }
    throw new IllegalArgumentException("Invalid IOCase name: " + paramString);
  }
  
  private Object readResolve()
  {
    return forName(name);
  }
  
  public int checkCompareTo(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("The strings must not be null");
    }
    if (sensitive) {
      return paramString1.compareTo(paramString2);
    }
    return paramString1.compareToIgnoreCase(paramString2);
  }
  
  public boolean checkEndsWith(String paramString1, String paramString2)
  {
    int i = paramString2.length();
    if (!sensitive) {}
    for (boolean bool = true;; bool = false) {
      return paramString1.regionMatches(bool, paramString1.length() - i, paramString2, 0, i);
    }
  }
  
  public boolean checkEquals(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("The strings must not be null");
    }
    if (sensitive) {
      return paramString1.equals(paramString2);
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public int checkIndexOf(String paramString1, int paramInt, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if (i >= paramInt) {
      while (paramInt <= i)
      {
        if (checkRegionMatches(paramString1, paramInt, paramString2)) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  public boolean checkRegionMatches(String paramString1, int paramInt, String paramString2)
  {
    if (!sensitive) {}
    for (boolean bool = true;; bool = false) {
      return paramString1.regionMatches(bool, paramInt, paramString2, 0, paramString2.length());
    }
  }
  
  public boolean checkStartsWith(String paramString1, String paramString2)
  {
    if (!sensitive) {}
    for (boolean bool = true;; bool = false) {
      return paramString1.regionMatches(bool, 0, paramString2, 0, paramString2.length());
    }
  }
  
  public String getName()
  {
    return name;
  }
  
  public boolean isCaseSensitive()
  {
    return sensitive;
  }
  
  public String toString()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.IOCase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */