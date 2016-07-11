package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class PrefixFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final IOCase caseSensitivity;
  private final String[] prefixes;
  
  public PrefixFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The prefix must not be null");
    }
    prefixes = new String[] { paramString };
    paramString = paramIOCase;
    if (paramIOCase == null) {
      paramString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramString;
  }
  
  public PrefixFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The list of prefixes must not be null");
    }
    prefixes = ((String[])paramList.toArray(new String[paramList.size()]));
    paramList = paramIOCase;
    if (paramIOCase == null) {
      paramList = IOCase.SENSITIVE;
    }
    caseSensitivity = paramList;
  }
  
  public PrefixFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public PrefixFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The array of prefixes must not be null");
    }
    prefixes = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, prefixes, 0, paramArrayOfString.length);
    paramArrayOfString = paramIOCase;
    if (paramIOCase == null) {
      paramArrayOfString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramArrayOfString;
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    String[] arrayOfString = prefixes;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (caseSensitivity.checkStartsWith(paramFile, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = prefixes;
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      String str = paramFile[i];
      if (caseSensitivity.checkStartsWith(paramString, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (prefixes != null)
    {
      int i = 0;
      while (i < prefixes.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(prefixes[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.PrefixFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */